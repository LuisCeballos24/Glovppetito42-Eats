package components.auth;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.glovppetito42eats.R;


public class AuthMessageActivity extends AppCompatActivity {
    TextView txtNombre,txtApellido,txtCorreo,txtCedula;

    private String Nombre, Apellido,Correo,Cedula;
    private int type;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje_login);



        i = getIntent();
        Nombre = i.getStringExtra("Nombre");
        Apellido = i.getStringExtra("Apellido");
        Correo = i.getStringExtra("Correo");
        Cedula = i.getStringExtra("Cedula");

        initializeControllers();
    }

    public void initializeControllers() {

        txtNombre = (TextView)findViewById(R.id.nombre);
        txtApellido = (TextView)findViewById(R.id.apellido);
        txtCedula = (TextView)findViewById(R.id.cedula);
        txtCorreo = (TextView)findViewById(R.id.correo);

        txtNombre.setText("Nombre:"+"\n"+Nombre);
        txtApellido.setText("Apellido:"+"\n"+Apellido);
        txtCedula.setText("Correo:"+"\n"+Cedula);
        txtCorreo.setText("Cedula:"+"\n"+Correo);
    }


}