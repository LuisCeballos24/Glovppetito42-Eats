package gg.rubit.components.summary;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gg.rubit.R;
import gg.rubit.api.ApiService;
import gg.rubit.api.request.RequestGame;
import gg.rubit.data.Game;
import gg.rubit.database.DatabaseManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SummaryActivity extends AppCompatActivity {

    TextView player, score;

    List<Game> games = new ArrayList<>();
    MediaPlayer click, music;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        int game = getIntent().getIntExtra("Partida", 0);
        loadViewByGameId(game);
        initializeControllers();
        assignValues();
        saveGameToApi(games);

        i = getIntent();

        click = MediaPlayer.create(this, R.raw.click);
        music = MediaPlayer.create(this, R.raw.resum);
        music.start();
    }

    private void saveGameToApi(List<Game> games) {
        RequestGame request = new RequestGame();
        request.setNombre(games.get(0).getPlayer());
        request.setPuntaje(getScore(games));

        Call<Integer> response = ApiService.getApiService().postRegistrarPartida(request);
        response.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {
                    int registered = response.body();
                    if (registered > 0) {

                    }
                } else {
                    int x = 1;
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                int x = 1;
            }
        });
    }

    public void getGames(View v) {
        click.start();
        //Intent i = new Intent(getApplicationContext(), MenuLoginActivity.class);
        startActivity(i);
    }

    @SuppressLint("SetTextI18n")
    private void assignValues() {
        player.setText(games.get(0).getPlayer());
        score.setText(Integer.toString(getScore(games)));
    }

    private int getScore(List<Game> games) {
        int puntaje = 0;
        for (Game part : games) {
            puntaje = puntaje + part.getScore();
        }

        return puntaje;
    }

    private void loadViewByGameId(int game) {
        DatabaseManager db = new DatabaseManager(getApplicationContext());
        games = db.getGameById(game);
    }

    private void initializeControllers() {
        player = (TextView) findViewById(R.id.txtJugador);
        score = (TextView) findViewById(R.id.txtPuntos);
    }

    @Override
    protected void onPause() {
        super.onPause();
        music.pause();
    }
}