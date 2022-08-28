package gg.rubit.ui.loading;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import gg.rubit.R;
import gg.rubit.components.auth.LoginActivity;

public class LoadingUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        int duration = 2000;
        new Handler().postDelayed(() -> {
            startActivity(new Intent(LoadingUI.this, LoginActivity.class));
            finish();
        }, duration);
    }
}