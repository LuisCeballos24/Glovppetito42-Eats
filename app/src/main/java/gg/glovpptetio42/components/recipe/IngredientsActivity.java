package gg.glovpptetio42.components.recipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import gg.glovpptetio42.R;
import gg.glovpptetio42.adapters.RecipeListViewAdapter;
import gg.glovpptetio42.api.ApiService;
import gg.glovpptetio42.api.request.FavRecipes;
import gg.glovpptetio42.api.request.Recipes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IngredientsActivity extends AppCompatActivity {

    ListView lstRecetas;
    int posicion;
    int tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas_principal);

        InicializarControles();
        LoadListView(0);
    }

    private void LoadListView(int n) {
        Call<List<Recipes>> response = ApiService.getApiService().getRecipe();
        response.enqueue(new Callback<List<Recipes>>() {
            @Override
            public void onResponse(Call<List<Recipes>> call, Response<List<Recipes>> response) {
                if (response.isSuccessful()) {
                    List<Recipes> table = response.body();
                    RecipeListViewAdapter adapter = new RecipeListViewAdapter(getApplicationContext(), table);
                    lstRecetas.setVisibility(View.VISIBLE);
                    lstRecetas.setAdapter(adapter);
                    lstRecetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(getApplicationContext(),"Ha seleccionado "+adapter.getItemId(position),Toast.LENGTH_LONG).show();
                            Intent idetalle = new Intent(getApplicationContext(),DetailsRecipeActivity.class);
                            posicion = (int)adapter.getItemId(position);
                            tipo = idetalle.getIntExtra("Tipo",0);
                            idetalle.putExtra("idReceta",posicion);
                            idetalle.putExtra("Tipo",tipo);
                            startActivity(idetalle);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<Recipes>> call, Throwable t) {

            }
        });
    }

    private void eliminar_receta(View v){

    }

    private void InicializarControles() {
        lstRecetas = findViewById(R.id.lstRecetas);
    }

}