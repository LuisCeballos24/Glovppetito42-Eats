package gg.glovpptetio42.components.recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import gg.glovpptetio42.R;
import gg.glovpptetio42.adapters.FavRecipeListViewAdapter;
import gg.glovpptetio42.adapters.RecipeListViewAdapter;
import gg.glovpptetio42.api.ApiService;
import gg.glovpptetio42.api.request.AddRecipes;
import gg.glovpptetio42.api.request.FavRecipes;
import gg.glovpptetio42.api.request.Recipes;
import gg.glovpptetio42.api.response.UserResponse;
import gg.glovpptetio42.menu.MenuActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddRecipesActivity extends AppCompatActivity {

    EditText receta_nombre, txt_Ingrediente1, txt_Ingrediente2, txt_Ingrediente3, txtpreparacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_receta);
        this.InicializarComponentes();
    }


    public void InicializarComponentes() {
        receta_nombre = (EditText)findViewById(R.id.txt_receta_nombre);
        txt_Ingrediente1 = (EditText)findViewById(R.id.txt_Ingrediente1);
        txt_Ingrediente2 = (EditText)findViewById(R.id.txt_Ingrediente2);
        txt_Ingrediente3 = (EditText)findViewById(R.id.txt_Ingrediente3);
        txtpreparacion = (EditText)findViewById(R.id.txt_Preparacion);
    }

    public void anadir_Receta(View v) {
        String nombre_recipe = receta_nombre.getText().toString();
        String ing1 = txt_Ingrediente1.getText().toString();
        String ing2 = txt_Ingrediente2.getText().toString();
        String ing3 = txt_Ingrediente3.getText().toString();

        String preparacion = txtpreparacion.getText().toString();
        AddRecipes receta = new AddRecipes();
        receta.setIngredientes(ing1+" "+ing2+" "+ing3);
        receta.setPreparacion(preparacion);
        receta.setProducto(nombre_recipe);

        Call<Integer> responses = ApiService.getApiService().postRecipe(receta);
        responses.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Receta Creada Exitosamente", Toast.LENGTH_LONG).show();
                    int x = 1;
                } else {
                    int x = 1;
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Reseta Exitosa", Toast.LENGTH_LONG).show();
                int x = 1;
            }
        });
    }
}