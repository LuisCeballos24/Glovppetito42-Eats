package gg.glovpptetio42.components.recipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import gg.glovpptetio42.R;
import gg.glovpptetio42.adapters.DetailsRecipeListViewAdapter;
import gg.glovpptetio42.adapters.RecipeListViewAdapter;
import gg.glovpptetio42.api.ApiService;
import gg.glovpptetio42.api.request.AddRecipes;
import gg.glovpptetio42.api.request.Recipes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsRecipeActivity extends AppCompatActivity {

    ListView lstdetallada;
    Button bttnFav, bttnEli;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallada);
        this.Inicializar_Controles();
        this.Obtener_Detallada();
        Verificar_Botones();
    }
    private void Verificar_Botones()
    {
        Intent i = getIntent();
        int tipo = i.getIntExtra("Tipo",0);

        if(tipo == 1)
        {
            bttnEli.setVisibility(View.INVISIBLE);
            bttnFav.setVisibility(View.VISIBLE);
        }
        else
        {
            bttnFav.setVisibility(View.INVISIBLE);
            bttnEli.setVisibility(View.VISIBLE);
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
            int position;
            Intent i = getIntent();
            position = i.getIntExtra("idReceta",0);
            AddRecipes re=new AddRecipes();
            re.setReceta_id(Integer.toString(position));
            Call<List<AddRecipes>> response = ApiService.getApiService().getRecipeId(re);
            response.enqueue(new Callback<List<AddRecipes>>() {
                @Override
                public void onResponse(Call<List<AddRecipes>> call, Response<List<AddRecipes>> response) {
                    if (response.isSuccessful()) {
                        List<AddRecipes> table = response.body();
                        DetailsRecipeListViewAdapter adapter = new DetailsRecipeListViewAdapter(getApplicationContext(), table);
                        lstdetallada.setVisibility(View.VISIBLE);
                        lstdetallada.setAdapter(adapter);
                    }
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



    /*public void eliminar_Rece(View v)
    {
        try{
            Intent i = getIntent();
            ProcesosBD pdb = new ProcesosBD(getApplicationContext());
            int position = i.getIntExtra("idReceta",0);

            if (pdb.Eliminar_Receta(position) > 0) {
                Toast.makeText(getApplicationContext(),"Receta Eliminada Correctamente",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),PrincipalRecetasActivity.class));
            }else{
                Toast.makeText(getApplicationContext(),"Error eliminado la receta, intentelo de nuevo...",Toast.LENGTH_LONG).show();
            }

        }
        catch(Exception e){

        }
    }

    public void anadir_Fav(View v)
    {
        try{
            Intent i = getIntent();
            ProcesosBD pdb = new ProcesosBD(getApplicationContext());
            int position = i.getIntExtra("idReceta",0);
            int idUsu;
            idUsu = pdb.Obtener_id_Sesion();

            if (pdb.Anadir_Favorita(idUsu, position))
            {
                Toast.makeText(getApplicationContext(),"Receta añadida a favoritos",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),PrincipalRecetasActivity.class));
            }
            else
                Toast.makeText(getApplicationContext(),"Error con la receta, intentelo de nuevo",Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
        }
    }*/


}
