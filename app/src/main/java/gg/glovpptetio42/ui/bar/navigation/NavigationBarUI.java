package gg.glovpptetio42.ui.bar.navigation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import gg.glovpptetio42.R;
import gg.glovpptetio42.components.auth.AuthMessageActivity;
import gg.glovpptetio42.components.conversation.SelectConversation;
import gg.glovpptetio42.components.ranking.RankingActivity;
import gg.glovpptetio42.components.ranking.RankingFragment;
import gg.glovpptetio42.games.wordpicker.WordPickerGameActivity;
import gg.glovpptetio42.ui.help.HelpUI;

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
                    startActivity(new Intent(getApplicationContext(), SelectConversation.class));
                    return true;
                case R.id.ranking:
                    startActivity(new Intent(getApplicationContext(), RankingActivity.class));
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
                    startActivity(new Intent(getApplicationContext(), WordPickerGameActivity.class));
                    return true;
                case R.id.ayuda:
                    startActivity(new Intent(getApplicationContext(), HelpUI.class));
                    return true;
            }

            return false;
        });
    }
}