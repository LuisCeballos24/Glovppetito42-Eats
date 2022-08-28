package gg.rubit.components.puntos;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import gg.rubit.R;
import gg.rubit.ui.bar.navigation.NavigationBarUI;

public class PuntosActivity extends AppCompatActivity implements View.OnClickListener {

    TextView puntaje;
    MediaPlayer click, music;

    Intent i;
    int puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje);
        InicializarControles();
        MapearCampos();

        click = MediaPlayer.create(this, R.raw.click);
        music = MediaPlayer.create(this, R.raw.resum);
        music.start();
    }

    private void MapearCampos() {
        i = getIntent();
        puntos = i.getIntExtra("puntaje", 0);
        puntaje.setText(Integer.toString(puntos));
    }

    private void InicializarControles() {
        puntaje = (TextView) findViewById(R.id.txtPuntos);
    }

    @Override
    protected void onPause() {
        super.onPause();
        music.pause();
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(), NavigationBarUI.class));
    }
}