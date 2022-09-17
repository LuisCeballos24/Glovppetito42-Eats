package gg.glovpptetio42.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gg.glovpptetio42.R;
import gg.glovpptetio42.components.auth.RegisterActivity;
import gg.glovpptetio42.components.recipe.AddRecipesActivity;

public class MenuActivity extends AppCompatActivity {
    Button recetas_d,agregar_r,guardados,anadir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recetas_d=(Button) findViewById(R.id.recetas_d);
        agregar_r=(Button) findViewById(R.id.agregar_r);
        guardados=(Button) findViewById(R.id.guardados);
        anadir=(Button) findViewById(R.id.anadir);
    }

    public void menuPrincipal(View v){
        switch (v.getId()){
            case R.id.agregar_r: Intent i = new Intent(getApplicationContext(), AddRecipesActivity.class);
                                 startActivity(i);
                break;
           case R.id.recetas_d:
                break;
            case R.id.guardados:
                break;
            case R.id.anadir:Intent b = new Intent(getApplicationContext(), RegisterActivity.class);
                             startActivity(b);
                break;
        }
    }
}