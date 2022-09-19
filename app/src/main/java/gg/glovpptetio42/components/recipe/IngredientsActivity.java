package gg.glovpptetio42.components.recipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gg.glovpptetio42.R;
import gg.glovpptetio42.adapters.RecipeListViewAdapter;
import gg.glovpptetio42.api.ApiService;
import gg.glovpptetio42.api.request.FavRecipes;
import gg.glovpptetio42.api.request.Recipes;
import gg.glovpptetio42.api.response.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IngredientsActivity extends AppCompatActivity {

    ListView lstRecetas;
    int tipo;
    Intent i = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tipo = getIntent().getIntExtra("Tipo",0);
        setContentView(R.layout.activity_recetas_principal);
        LoadListView(0);
        InicializarControles();
    }

    private void LoadListView(int n) {
        Call<List<Recipes>> response = ApiService.getApiService().getRecipe();
        response.enqueue(new Callback<List<Recipes>>() {
            @Override
            public void onResponse(Call<List<Recipes>> call, Response<List<Recipes>> response) {
                if (response.isSuccessful()) {
                    List<Recipes> Recipes = response.body();
                    RecipeListViewAdapter adapter =new RecipeListViewAdapter(getApplicationContext(), Recipes);
                    lstRecetas.setVisibility(View.VISIBLE);
                    lstRecetas.setAdapter(adapter);
                    lstRecetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(getApplicationContext(),"Ha seleccionado "+adapter.getItemId(position),Toast.LENGTH_LONG).show();
                            Intent idetalle = new Intent(getApplicationContext(),DetailsRecipeActivity.class);
                            int posicion = (int)adapter.getItemId(position);
                            UserResponse e=new UserResponse();
                            idetalle.putExtra("tipo",tipo);
                            idetalle.putExtra("idReceta",posicion+1);
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

    private void InicializarControles() {
        lstRecetas = findViewById(R.id.lstRecetas);

    }


}