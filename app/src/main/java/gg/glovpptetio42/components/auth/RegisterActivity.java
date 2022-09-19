package gg.glovpptetio42.components.auth;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import gg.glovpptetio42.R;
import gg.glovpptetio42.api.ApiService;
import gg.glovpptetio42.api.response.IdResponse;
import gg.glovpptetio42.data.UserDataValues;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText nombre, correo, password, apellido, cedula, usuario_id;
    MediaPlayer click, music;
    int tipo;
    Intent i;
    int x;
    RadioButton r1,r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        i = getIntent();
        x = i.getIntExtra("num", 0);

        initializeControllers();
    }

    private void initializeControllers() {
        nombre = (EditText) findViewById(R.id.nombre);
        correo = (EditText) findViewById(R.id.correo);
        password = (EditText) findViewById(R.id.Rptpassword);
        apellido = (EditText) findViewById(R.id.apellido);
        cedula = (EditText) findViewById(R.id.cedula);
        r1 = (RadioButton) findViewById(R.id.rbConsu);
        r2 = (RadioButton) findViewById(R.id.rbAdmin);
    }

    public void registerUser(View v) {
        try {
            if (r1.isChecked()==true) {
                tipo=2;
            } else
            if (r2.isChecked()==true) {
                tipo=1;
            }
            UserDataValues estudiante = new UserDataValues();
            estudiante.setNombre(nombre.getText().toString());
            estudiante.setCorreo(correo.getText().toString());
            estudiante.setPassword(password.getText().toString());
            estudiante.setApellido(apellido.getText().toString());
            estudiante.setCedula(cedula.getText().toString());

            Call<IdResponse> response1 = ApiService.getApiService().postRegistrarUsuarios(estudiante);
            response1.enqueue(new Callback<IdResponse>() {

                @Override
                public void onResponse(Call<IdResponse> call, Response<IdResponse> response) {
                    if (response.isSuccessful()) {
                        UserDataValues estudiante = new UserDataValues();
                        estudiante.setNombre(nombre.getText().toString());
                        estudiante.setCorreo(correo.getText().toString());
                        estudiante.setPassword(password.getText().toString());
                        estudiante.setApellido(apellido.getText().toString());
                        estudiante.setCedula(cedula.getText().toString());
                        estudiante.setTipo_usuario(tipo);

                        IdResponse id = response.body();
                        estudiante.setUsuario_id(id.getId());

                        Call<Integer> responses = ApiService.getApiService().postRegistrarDatosUsuarios(estudiante);
                        responses.enqueue(new Callback<Integer>() {
                            @Override
                            public void onResponse(Call<Integer> call, Response<Integer> response) {
                                if (response.isSuccessful()) {
                                    //UserResponse id = response.body();
                                    Toast.makeText(getApplicationContext(), "Datos del Usuario Creados Correctamente", Toast.LENGTH_LONG).show();
                                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivity(i);
                                    int x = 1;
                                } else {
                                    int x = 1;
                                }
                            }

                            @Override
                            public void onFailure(Call<Integer> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Datos del Usuario Creados Correctamente", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(i);
                                int x = 1;
                            }
                        });
                    } else {
                        int x = 1;
                    }
                }

                @Override
                public void onFailure(Call<IdResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Datos del Usuario Creados Correctamente", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                    int x = 1;
                }
            });
        } catch (Exception e) {
            int x = 1;
        }
    }

    public void goBack(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}