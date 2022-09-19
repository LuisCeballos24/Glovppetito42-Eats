package gg.glovpptetio42.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gg.glovpptetio42.R;
import gg.glovpptetio42.components.auth.RegisterActivity;
import gg.glovpptetio42.components.recipe.AddRecipesActivity;
import gg.glovpptetio42.components.recipe.FavRecipeActivity;
import gg.glovpptetio42.components.recipe.IngredientsActivity;

public class MenuActivity extends AppCompatActivity {
    Button recetas_d,agregar_r,guardados,anadir;
    int tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recetas_d=(Button) findViewById(R.id.recetas_d);
        agregar_r=(Button) findViewById(R.id.agregar_r);
        guardados=(Button) findViewById(R.id.guardados);
        anadir=(Button) findViewById(R.id.anadir);
        Verificar_Botones();
    }


    private void Verificar_Botones()
    {
        Intent i = getIntent();
        tipo = i.getIntExtra("Tipo",0);
        if(tipo == 1)
        {
            anadir.setVisibility(View.VISIBLE);
            agregar_r.setVisibility(View.VISIBLE);
        }
        else
        {
            anadir.setVisibility(View.INVISIBLE);
            agregar_r.setVisibility(View.INVISIBLE);
        }
    }
    public void menuPrincipal(View v){
        switch (v.getId()){
            case R.id.agregar_r: Intent d = new Intent(getApplicationContext(), AddRecipesActivity.class);
                                 startActivity(d);
                break;
           case R.id.recetas_d:
               Intent e = new Intent(getApplicationContext(), IngredientsActivity.class);
               e.putExtra("Tipo",tipo);
               startActivity(e);
                break;
            case R.id.guardados:
                Intent c = new Intent(getApplicationContext(), FavRecipeActivity.class);
                startActivity(c);
                break;
            case R.id.anadir: Intent b = new Intent(getApplicationContext(), RegisterActivity.class);
                             startActivity(b);
                break;
        }
    }
}