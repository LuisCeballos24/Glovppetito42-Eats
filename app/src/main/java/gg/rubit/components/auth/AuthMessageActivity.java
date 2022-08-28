package gg.rubit.components.auth;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import gg.rubit.adapters.TablaListViewAdapter;
import gg.rubit.api.ApiService;
import gg.rubit.api.request.RequestUser;
import gg.rubit.api.response.CVID_Tabla;
import gg.rubit.api.response.UserResponse;
import gg.rubit.data.User;
import gg.rubit.data.UserDataValues;
import gg.rubit.database.DatabaseManager;
import gg.rubit.ui.bar.navigation.NavigationBarUI;
import gg.rubit.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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