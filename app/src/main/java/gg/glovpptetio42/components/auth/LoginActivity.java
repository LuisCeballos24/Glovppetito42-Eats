package gg.glovpptetio42.components.auth;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import gg.glovpptetio42.R;
import gg.glovpptetio42.api.ApiService;
import gg.glovpptetio42.api.request.RequestUser;
import gg.glovpptetio42.api.response.UserResponse;
import gg.glovpptetio42.data.User;
import gg.glovpptetio42.menu.MenuActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText userEmail, userPassword;
    int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEmail = (EditText) findViewById(R.id.email);
        userPassword = (EditText) findViewById(R.id.password);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    public void performUserLogin(View v) {
        try {
            String user = userEmail.getText().toString();
            String pass = userPassword.getText().toString();
            RequestUser request = new RequestUser();
            request.setCorreo(user);
            request.setPassword(pass);

            Call<UserResponse> response = ApiService.getApiService().login(request);
            response.enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    if (response.isSuccessful()) {
                        UserResponse estudiante = response.body();
                        if (estudiante != null) {
                            User user = new User(estudiante.getId(), estudiante.getCorreo(), "", estudiante.getNombre());
                            Toast.makeText(getApplicationContext(), "Login Exitoso", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                            type=estudiante.getTipo_usuario();
                            if(type==1){
                                i.putExtra("Tipo", 1);
                                startActivity(i);
                            }else{
                                i.putExtra("Tipo", 2);
                                startActivity(i);
                            }

                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Error Al Iniciar Sesión", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Error Al Iniciar Sesión", Toast.LENGTH_LONG).show();
                    int x = 1;
                }
            });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error Al Iniciar Sesión", Toast.LENGTH_LONG).show();
            int x = 1;
        }
    }

    public void registerUser(View v) {
        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
        i.putExtra("num", 1);
        startActivity(i);
    }

    public void recoverUserPassword(View view) {
        startActivity(new Intent(getApplicationContext(), PasswordRecoveryActivity.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}