package gg.rubit.components.lessons;

import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import gg.rubit.R;

public class VideoLessonActivity extends AppCompatActivity {

    VideoView videoView;
    Uri uriSubtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_lectura);

        videoView = findViewById(R.id.videoView);

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.api_v));
        uriSubtitle = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.api);

        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);

        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.BOTTOM;
        mc.setLayoutParams(lp);

        ((ViewGroup) mc.getParent()).removeView(mc);
        ((FrameLayout) findViewById(R.id.frmly)).addView(mc);
    }
}