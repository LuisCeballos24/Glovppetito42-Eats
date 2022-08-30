package gg.glovpptetio42.components.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import gg.glovpptetio42.R;
import gg.glovpptetio42.components.conversation.ConversacionActivity;

public class DevelopmentActivity extends AppCompatActivity {

    private Button video, chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_des);
        initializeControllers();

        chat.setOnClickListener(view -> {
            startActivity(new Intent(DevelopmentActivity.this, VideoLessonActivity.class));
        });

        video.setOnClickListener(view -> {
            startActivity(new Intent(DevelopmentActivity.this, ConversacionActivity.class));
        });
    }

    private void initializeControllers() {
        video = findViewById(R.id.Dleccion1);
        chat = findViewById(R.id.Dleccion2);
    }
}