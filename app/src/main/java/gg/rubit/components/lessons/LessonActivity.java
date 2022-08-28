package gg.rubit.components.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import gg.rubit.R;

public class LessonActivity extends AppCompatActivity {

   private Button xd1, xd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeControllers();
        setContentView(R.layout.activity_leccion);

    }   public void xd1(View v) {
        startActivity(new Intent(LessonActivity.this, EngineeringActivity.class));
    }
    public void xd2(View v) {
        startActivity(new Intent(LessonActivity.this, DevelopmentActivity.class));

    }
    private void initializeControllers() {
        xd1 = findViewById(R.id.boton1);
        xd2 = findViewById(R.id.boton2);
    }
}