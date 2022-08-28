package gg.rubit.components.ranking;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gg.rubit.R;
import gg.rubit.api.ApiService;
import gg.rubit.api.request.RankingPodioRequest;
import gg.rubit.ui.bar.navigation.NavigationBarUI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RankingPodioActivity extends AppCompatActivity {

    ImageView imv1, imv2, imv3;
    TextView nombre1, nombre2, nombre3;
    TextView punto1, punto2, punto3;
    TextView titulo, subtitulo;

    LinearLayout ll1, ll2, ll3;
    List<RankingPodioRequest> ranking = new ArrayList<>();

    Button continuar;
    //ObjectAnimator tituloAnimator,subtituloAnimator,im1Animator;

    Animation tituloAn, subAn, imv1An, nomAn1, puntAn1, imv2An, nomAn2, puntAn2, imv3An, nomAn3, puntAn3;

    MediaPlayer click, music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_podio);

        initializeControllers();
        titulo.startAnimation(tituloAn);
        titulo.setText("¡Llegaron los resultados!");
        subtitulo.startAnimation(subAn);
        subtitulo.setText("Estos son los ganadores.");

        click = MediaPlayer.create(this, R.raw.click);
        music = MediaPlayer.create(this, R.raw.resum);
        music.start();

        setRanking();
    }

    private void initializeControllers() {
        titulo = findViewById(R.id.titulo);
        subtitulo = findViewById(R.id.subitulo);

        imv1 = findViewById(R.id.imvFoto1);
        imv2 = findViewById(R.id.imvFoto2);
        imv3 = findViewById(R.id.imvFoto3);

        nombre1 = findViewById(R.id.nombre1);
        nombre2 = findViewById(R.id.nombre2);
        nombre3 = findViewById(R.id.nombre3);

        punto1 = findViewById(R.id.puntaje1);
        punto2 = findViewById(R.id.puntaje2);
        punto3 = findViewById(R.id.puntaje3);

        ll1 = findViewById(R.id.ll1);
        ll2 = findViewById(R.id.ll2);
        ll3 = findViewById(R.id.ll3);

        tituloAn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
        subAn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
        imv1An = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
        nomAn1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
        puntAn1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);

        imv2An = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
        nomAn2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
        puntAn2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);

        imv3An = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
        nomAn3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
        puntAn3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);

        continuar = findViewById(R.id.btnContinuar);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NavigationBarUI.class));
            }
        });
    }

    public void setRanking() {
        try {
            Call<List<RankingPodioRequest>> response = ApiService.getApiService().getParticipantes();
            response.enqueue(new Callback<List<RankingPodioRequest>>() {
                @Override
                public void onResponse(Call<List<RankingPodioRequest>> call, Response<List<RankingPodioRequest>> response) {
                    if (response.isSuccessful()) {
                        List<RankingPodioRequest> rankingList = response.body();
                        for (RankingPodioRequest list : rankingList) {
                            ranking.add(new RankingPodioRequest(list.getFirstName(), list.getLastName(), list.getScore()));
                            System.out.println(list.getFirstName() + " " + list.getLastName() + " " + list.getScore());
                        }
                        setValuesForUI(ranking);
                    } else {
                        Toast.makeText(getApplicationContext(), "Hubo un error al conseguir los datos!!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<List<RankingPodioRequest>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Hubo un error al conseguir los datos!!", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception ignored) {
        }

    }

    @SuppressLint("SetTextI18n")
    public void setValuesForUI(List<RankingPodioRequest> ranking) {
        imv1.startAnimation(imv1An);
        imv1.setImageResource(R.drawable.gold);

        nombre1.startAnimation(nomAn1);
        nombre1.setText(ranking.get(0).getFirstName() + " " + ranking.get(0).getLastName());

        punto1.startAnimation(puntAn1);
        punto1.setText(Long.toString(ranking.get(0).getScore()));

        imv2.startAnimation(imv2An);
        imv2.setImageResource(R.drawable.silver);

        nombre2.startAnimation(nomAn2);
        nombre2.setText(ranking.get(1).getFirstName() + " " + ranking.get(1).getLastName());

        punto2.startAnimation(puntAn2);
        punto2.setText(Long.toString(ranking.get(1).getScore()));

        imv3.startAnimation(imv3An);
        imv3.setImageResource(R.drawable.bronce);

        nombre3.startAnimation(nomAn3);
        nombre3.setText(ranking.get(2).getFirstName() + " " + ranking.get(2).getLastName());

        punto3.startAnimation(puntAn3);
        punto3.setText(Long.toString(ranking.get(2).getScore()));
    }

    /*private void AnimarTitulos(){
        tituloAnimator = ObjectAnimator.ofFloat(titulo,View.TRANSLATION_Y, titulo.getTranslationY() + 100f,titulo.getTranslationY());
        tituloAnimator.setDuration(2000);
        tituloAnimator.start();
        titulo.setText("¡Llegaron los resultados!");
    }

    private void AnimarSubtitulo(){
        subtituloAnimator = ObjectAnimator.ofFloat(subtitulo,View.TRANSLATION_Y, subtitulo.getTranslationY() + 100f,subtitulo.getTranslationY());
        subtituloAnimator.setStartDelay(4000);
        subtituloAnimator.setDuration(2000);
        subtituloAnimator.start();
        subtitulo.setText("Estos son los ganadores.");
    }*/
}