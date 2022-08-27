package components.auth;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.glovppetito42eats.R;

import api.ApiService;
import api.response.IdResponse;
import retrofit2.Call;
import retrofit2.Callback;
import data.UserDataValues;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity {

    EditText nombre, correo, password, apellido, cedula, usuario_id;
    MediaPlayer click, music;
    Intent i;
    int x;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        ;
        music.start();

        i = getIntent();
        x = i.getIntExtra("num", 0);

        initializeControllers();
    }

    @Override
    protected void onStart() {
        super.onStart();
        music.start();
    }

    private void initializeControllers() {
        nombre = (EditText) findViewById(R.id.nombre);
        correo = (EditText) findViewById(R.id.correo);
        password = (EditText) findViewById(R.id.Rptpassword);
        apellido = (EditText) findViewById(R.id.apellido);
        cedula = (EditText) findViewById(R.id.cedula);
    }

    public void registerUser(View v) {
        try {
            UserDataValues estudiante = new UserDataValues();
            estudiante.setNombre(nombre.getText().toString());
            estudiante.setCorreo(correo.getText().toString());
            estudiante.setPassword(password.getText().toString());
            estudiante.setApellido(apellido.getText().toString());
            estudiante.setCedula(cedula.getText().toString());
            estudiante.setTipo_usuario("");

            retrofit2.Call<IdResponse> response1 = ApiService.getApiService().postRegistrarUsuarios(estudiante);
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

                        IdResponse id = response.body();
                        estudiante.setUsuario_id(id.getId());

                        retrofit2.Call<Integer> responses = ApiService.getApiService().postRegistrarDatosUsuarios(estudiante);
                        responses.enqueue(new Callback<Integer>() {
                            @Override
                            public void onResponse(retrofit2.Call<Integer> call, Response<Integer> response) {
                                if (response.isSuccessful()) {
                                    //UserResponse id = response.body();
                                    Toast.makeText(getApplicationContext(), "Datos del Usuario Creados Correctamente", Toast.LENGTH_LONG).show();
                                    Intent i = new Intent(getApplicationContext(), components.auth.LoginActivity.class);
                                    startActivity(i);
                                    int x = 1;
                                } else {
                                    int x = 1;
                                }

                            }

                            @Override
                            public void onFailure(retrofit2.Call<Integer> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Datos del Usuario Creados Correctamente", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(getApplicationContext(), components.auth.LoginActivity.class);
                                startActivity(i);
                                int x = 1;
                            }
                        });
                    } else {
                        int x = 1;
                    }
                }

                @Override
                public void onFailure(retrofit2.Call<IdResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Datos del Usuario Creados Correctamente", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), components.auth.LoginActivity.class);
                    startActivity(i);
                    int x = 1;
                }
            });
        } catch (Exception e) {
            int x = 1;
        }
    }

    public void goBack(View view) {
        click.start();
        startActivity(new Intent(getApplicationContext(), components.auth.LoginActivity.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        music.pause();
    }
}