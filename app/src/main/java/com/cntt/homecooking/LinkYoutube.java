package com.cntt.homecooking;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class LinkYoutube extends AppCompatActivity {

    private VideoView videoView;

    String videoLink = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_youtube);
//
//                          VideoView
//        videoView = findViewById(R.id.formula_video);
//        Uri uri = Uri.parse("https://www.youtube.com/watch?v=Rzs897JoYQA");
//        videoView.setVideoPath("https://www.youtube.com/watch?v=XXPlZJan--s");
//
//        MediaController mediaController = new MediaController(this);
//        mediaController.setMediaPlayer(videoView);
//        videoView.setMediaController(mediaController);
//        videoView.start();

    }
}