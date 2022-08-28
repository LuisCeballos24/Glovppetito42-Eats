package gg.rubit.ui.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import gg.rubit.R;

public class TutorialMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_main);
        initializeControllers();
    }

    Button tutorial;

    private void initializeControllers() {
        tutorial = (Button) findViewById(R.id.btntutorial);
    }

    public void confirm(View view) {
        startActivity(new Intent(this, TutorialUI.class));
    }
}
