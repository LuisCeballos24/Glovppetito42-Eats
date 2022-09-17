package gg.glovpptetio42.components.recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import gg.glovpptetio42.R;
import gg.glovpptetio42.menu.MenuActivity;

public class AddRecipesActivity extends AppCompatActivity {

    EditText receta_nombre, txt_Ingrediente1, txt_Ingrediente2, txt_Ingrediente3, txt_Ingrediente4, txt_Ingrediente5, txtpreparacion;


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

    public void Anadir_Receta(View v) {
        String nombre_recipe = receta_nombre.getText().toString();
        String ing1 = txt_Ingrediente1.getText().toString();
        String ing2 = txt_Ingrediente2.getText().toString();
        String ing3 = txt_Ingrediente3.getText().toString();
        String preparacion = txtpreparacion.getText().toString();
    }
    public void Volver (View v)
    {
        Intent i = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(i);
    }
}