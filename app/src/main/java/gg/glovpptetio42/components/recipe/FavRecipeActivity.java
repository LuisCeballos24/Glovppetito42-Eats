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
import gg.glovpptetio42.adapters.FavRecipeListViewAdapter;
import gg.glovpptetio42.api.ApiService;
import gg.glovpptetio42.api.request.AddRecipes;
import gg.glovpptetio42.api.request.FavRecipes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavRecipeActivity extends AppCompatActivity {
    ListView lstFavoritas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        InicializarControles();
        LoadListView(0);
    }
    public void LoadListView(int n) {
        Call<List<FavRecipes>> response = ApiService.getApiService().getFavRecipe();
        response.enqueue(new Callback<List<FavRecipes>>() {
            @Override
            public void onResponse(Call<List<FavRecipes>> call, Response<List<FavRecipes>> response) {
                if (response.isSuccessful()) {
                    List<FavRecipes> table = response.body();
                    FavRecipeListViewAdapter adapter = new FavRecipeListViewAdapter(getApplicationContext(), table);
                    lstFavoritas.setVisibility(View.VISIBLE);
                    lstFavoritas.setAdapter(adapter);
                    lstFavoritas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick (AdapterView < ? > parent, View view,
                            int position, long id){
                                Toast.makeText(getApplicationContext(), "Ha seleccionado " + adapter.getItemId(position), Toast.LENGTH_LONG).show();
                                Intent idetalle = new Intent(getApplicationContext(), DetailsRecipeActivity.class);
                                int posicion = (int) adapter.getItemId(position);
                                idetalle.putExtra("idReceta", posicion);
                                startActivity(idetalle);
                            }
                        });

                }
            }

            @Override
            public void onFailure(Call<List<FavRecipes>> call, Throwable t) {

            }
        });
    }
    private void InicializarControles() {
        lstFavoritas = findViewById(R.id.lstFavoritas);
    }
}
