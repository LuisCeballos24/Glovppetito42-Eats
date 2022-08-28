package gg.rubit.components.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import gg.rubit.R;
import gg.rubit.components.conversation.ConversacionActivity;

public class EngineeringActivity extends AppCompatActivity {

    private Button video, chat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ing);

        initializeControllers();

        chat.setOnClickListener(view -> {
            startActivity(new Intent(EngineeringActivity.this, VideoLessonActivity.class));
        });

        video.setOnClickListener(view -> {
            startActivity(new Intent(EngineeringActivity.this, ConversacionActivity.class));
        });
    }

    private void initializeControllers() {
        video = findViewById(R.id.video);
        chat = findViewById(R.id.chat);
    }
}