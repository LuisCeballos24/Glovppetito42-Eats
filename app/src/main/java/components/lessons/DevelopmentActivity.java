package gg.rubit.components.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import gg.rubit.R;

public class DevelopmentActivity extends AppCompatActivity {

    private Button video, chat;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_des);

        initializeControllers();

        video.setOnClickListener(view -> {
            startActivity(new Intent(DevelopmentActivity.this, VideoLessonActivity.class));
        });

        chat.setOnClickListener(view -> Toast.makeText(this, "deberia ir a la leccion cuento", Toast.LENGTH_LONG).show());

        back.setOnClickListener(view -> {
            startActivity(new Intent(DevelopmentActivity.this, LessonActivity.class));
        });
    }

    private void initializeControllers() {
        video = findViewById(R.id.Dleccion1);
        chat = findViewById(R.id.Dleccion2);
        back = findViewById(R.id.back);
    }
}