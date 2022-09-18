package gg.glovpptetio42.components.recipe;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import gg.glovpptetio42.R;
import gg.glovpptetio42.adapters.TablaListViewAdapter;
import gg.glovpptetio42.api.ApiService;
import gg.glovpptetio42.api.response.Recipes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IngredientsActivity extends AppCompatActivity {

    ListView lstRecetas;
    int tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas_principal);

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
                    lstRecetas.setVisibility(View.VISIBLE);
                    lstRecetas.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Recipes>> call, Throwable t) {

            }
        });
    }

    private void InicializarControles() {
        lstRecetas = findViewById(R.id.lstRecetas);
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