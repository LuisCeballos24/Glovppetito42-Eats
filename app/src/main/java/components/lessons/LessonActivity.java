package gg.rubit.components.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import gg.rubit.R;

public class LessonActivity extends AppCompatActivity {

    private Button btning, btndes;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leccion);

        btning.setOnClickListener(view -> {
            startActivity(new Intent(LessonActivity.this, EngineeringActivity.class));
        });

        btndes.setOnClickListener(view -> {
            startActivity(new Intent(LessonActivity.this, DevelopmentActivity.class));
        });

        back.setOnClickListener(view -> Toast.makeText(this, "Deberia ir a un menu", Toast.LENGTH_LONG).show());
    }
}