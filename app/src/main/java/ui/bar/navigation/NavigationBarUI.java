package ui.bar.navigation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.glovppetito42eats.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import components.auth.AuthMessageActivity;
import components.ranking.RankingFragment;
import ui.help.HelpUI;;

public class NavigationBarUI extends AppCompatActivity {

    Intent i;
    BottomNavigationView bottomNavigationView;
    RankingFragment rankingFragment = new RankingFragment();

    int userId;
    String firstName, lastName, email, cedula;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);

        i = getIntent();
        userId = i.getIntExtra("UserId", 0);
        firstName = i.getStringExtra("Nombre");
        lastName = i.getStringExtra("Apellido");
        email = i.getStringExtra("Correo");
        cedula = i.getStringExtra("Cedula");

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, rankingFragment).commit();

        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.ranking);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(8);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.lecciones:
                    return true;
                case R.id.ranking:
                    return true;
                case R.id.perfil:
                    Intent i = new Intent(getApplicationContext(), AuthMessageActivity.class);
                    i.putExtra("Nombre", firstName);
                    i.putExtra("Apellido", lastName);
                    i.putExtra("Cedula", email);
                    i.putExtra("Correo", cedula);

                    startActivity(i);
                    return true;
                case R.id.jugar:
                    return true;
                case R.id.ayuda:
                    startActivity(new Intent(getApplicationContext(), HelpUI.class));
                    return true;
            }

            return false;
        });
    }
}