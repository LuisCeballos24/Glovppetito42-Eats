package gg.rubit.components.auth;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import gg.rubit.R;

public class AuthMessageActivity extends AppCompatActivity {

    ImageView imgCargando;
    TextView txtNombre;

    private String name, userType;
    private int type;

    Intent i;
    AnimationDrawable animationDrawable;
    MediaPlayer click, music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje_login);

        i = getIntent();
        name = i.getStringExtra("Nombre");
        type = i.getIntExtra("Tipaje", 2);

        //imgCargando = (ImageView)findViewById(R.id.imgCargando);
        imgCargando.setBackgroundResource(R.drawable.cargando);

        animationDrawable = (AnimationDrawable) imgCargando.getBackground();
        animationDrawable.start();

        click = MediaPlayer.create(this, R.raw.click);
        music = MediaPlayer.create(this, R.raw.resum);

        initializeControllers();
    }

    public void onResume() {
        super.onResume();
        music.start();
    }

    public void initializeControllers() {
        if (type == 3) {
            userType = "Estudiante";
        }

        txtNombre = (TextView) findViewById(R.id.txtNombreLogin);
        txtNombre.setText(userType + "\n" + name);

        //imgCargando = (ImageView)findViewById(R.id.imgCargando);
        imgCargando.setBackgroundResource(R.drawable.cargando);
    }

    public void Menu(View v) {
        click.start();
        startActivity(new Intent(getApplicationContext(), AuthMessageActivity.class));
    }

    public void utpLogo(View view) {
        click.start();
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://utp.ac.pa/")));
    }

    public void fiscLogo(View view) {
        click.start();
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://fisc.utp.ac.pa/")));
    }

    @Override
    protected void onPause() {
        super.onPause();
        music.pause();
    }
}