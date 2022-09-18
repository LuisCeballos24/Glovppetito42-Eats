package gg.glovpptetio42.components.recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import gg.glovpptetio42.R;
import gg.glovpptetio42.adapters.TablaListViewAdapter;
import gg.glovpptetio42.api.ApiService;
import gg.glovpptetio42.api.response.Recipes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SavedActivity extends AppCompatActivity {

    ListView lstTabla;
    int tipo;

    ImageView imgCargando;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        imgCargando = findViewById(R.id.imgCargando);
        imgCargando.setBackgroundResource(R.drawable.cargando);
        imgCargando.setVisibility(View.VISIBLE);

        animationDrawable = (AnimationDrawable) imgCargando.getBackground();
        animationDrawable.start();

        InicializarControles();
        LoadListView(0);
    }

    private void LoadListView(int n) {
        Call<List<Recipes>> response = ApiService.getApiService().getRanking();
        response.enqueue(new Callback<List<Recipes>>() {
            @Override
            public void onResponse(Call<List<Recipes>> call, Response<List<Recipes>> response) {
                if (response.isSuccessful()) {
                    List<Recipes> table = response.body();
                    TablaListViewAdapter adapter = new TablaListViewAdapter(getApplicationContext(), table);
                    imgCargando.setVisibility(View.GONE);
                    lstTabla.setVisibility(View.VISIBLE);
                    lstTabla.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Recipes>> call, Throwable t) {

            }
        });
    }

    private void InicializarControles() {
        lstTabla = findViewById(R.id.lstTabla);
    }

    public void General(View v) {
        tipo = 1;
        LoadListView(tipo);
    }

    public void Local(View v) {
        tipo = 0;
        LoadListView(tipo);
    }
}