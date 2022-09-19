package gg.glovpptetio42.components.recipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gg.glovpptetio42.R;
import gg.glovpptetio42.adapters.DetailsRecipeListViewAdapter;
import gg.glovpptetio42.adapters.FavRecipeListViewAdapter;
import gg.glovpptetio42.adapters.RecipeListViewAdapter;
import gg.glovpptetio42.api.ApiService;
import gg.glovpptetio42.api.request.AddRecipes;
import gg.glovpptetio42.api.request.FavRecipes;
import gg.glovpptetio42.api.request.Recipes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsRecipeActivity extends AppCompatActivity {

    ListView lstdetallada;
    Button bttnFav, bttnEli;
    int tipo;
    int position;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallada);
        this.Inicializar_Controles();
        Verificar_Botones();
        this.Obtener_Detallada();
    }
    private void Verificar_Botones()
    {
        Intent i = getIntent();
        tipo = i.getIntExtra("tipo",0);

        if(tipo == 1)
        {
            bttnFav.setVisibility(View.INVISIBLE);
            bttnEli.setVisibility(View.VISIBLE);
        }
        else
        {
            bttnFav.setVisibility(View.VISIBLE);
            bttnEli.setVisibility(View.INVISIBLE);
        }
    }
    private void Inicializar_Controles()
    {
        bttnFav = (Button)findViewById(R.id.bttnFav);
        bttnEli = (Button)findViewById(R.id.bttnEliminar);
        lstdetallada = (ListView)findViewById(R.id.lstRecetaDetallada);
        RecipeListViewAdapter adaptador = new RecipeListViewAdapter(getApplicationContext(), Obtener_Detallada());
    }

    public List<Recipes> Obtener_Detallada()
    {
        try {
            Intent i = getIntent();
            position = i.getIntExtra("idReceta",0);
            tipo =i.getIntExtra("tipo",0);
            i.putExtra("Tipo",tipo);
            Call<List<AddRecipes>> response2 = ApiService.getApiService().getRecipeId2(position);
            response2.enqueue(new Callback<List<AddRecipes>>() {
                @Override
                public void onResponse(Call<List<AddRecipes>> call, Response<List<AddRecipes>> response) {
                    if(response.isSuccessful()){
                        List<AddRecipes> table = response.body();
                        DetailsRecipeListViewAdapter adapter = new DetailsRecipeListViewAdapter(getApplicationContext(), table);
                        lstdetallada.setVisibility(View.VISIBLE);
                        lstdetallada.setAdapter(adapter);}
                    }
                @Override
                public void onFailure(Call<List<AddRecipes>> call, Throwable t) {

                }
            });
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"Error "+e,Toast.LENGTH_LONG).show();
        }
        return null;
    }



    public void eliminar_Rece(View v)
    {
        try{
            Intent i = getIntent();
            position = i.getIntExtra("idReceta",0);
            i.putExtra("Tipo",tipo);
            Call<Integer> response = ApiService.getApiService().deleteRecipe(position);
            response.enqueue(new Callback<Integer>() {
                @Override
                public void onResponse(Call<Integer> call, Response<Integer> response) {
                    if (response.isSuccessful()) {
                        lstdetallada.setVisibility(View.VISIBLE);
                        Toast.makeText(getApplicationContext(),"Eliminado correctamente",Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<Integer> call, Throwable t) {

                }
            });
        }
        catch(Exception e){

        }
    }

    public void anadir_Fav(View v)
    {
        try{
            int position;
            Intent i = getIntent();
            position = i.getIntExtra("idReceta",0);
            i.putExtra("Tipo",tipo);
            Call<List<FavRecipes>> response = ApiService.getApiService().getRecipeId(position);
            response.enqueue(new Callback<List<FavRecipes>>() {
                @Override
                public void onResponse(Call<List<FavRecipes>> call, Response<List<FavRecipes>> response) {
                    if(response.isSuccessful()){
                        List<FavRecipes> table = response.body();
                        FavRecipeListViewAdapter adapter = new FavRecipeListViewAdapter(getApplicationContext(), table);
                        lstdetallada.setVisibility(View.VISIBLE);
                        lstdetallada.setAdapter(adapter);
                        FavRecipes favRecipes = new FavRecipes();
                        favRecipes.setId(table.get(0).getId());
                        favRecipes.setProducto(table.get(0).getProducto());
                    Call<Integer> response1 = ApiService.getApiService().postAddFav(favRecipes);
                    response1.enqueue(new Callback<Integer>() {
                        @Override
                        public void onResponse(Call<Integer> call, Response<Integer> response) {
                            if (response.isSuccessful()) {
                            }
                        }
                        @Override
                        public void onFailure(Call<Integer> call, Throwable t) {

                        }
                    });
                }
                }

                @Override
                public void onFailure(Call<List<FavRecipes>> call, Throwable t) {

                }

            });

        }
        catch (Exception e){
        }
    }


}
