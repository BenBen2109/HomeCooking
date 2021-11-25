package com.cntt.homecooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.cntt.homecooking.activities.DetailActivity;
import com.cntt.homecooking.api.GoogleAPI;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class LinkYoutube extends YouTubeBaseActivity {

    private YouTubePlayerView youTubePlayerView;
    Button btn_danau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_youtube);
        initView();

        btn_danau = findViewById(R.id.btn_danau);
        btn_danau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LinkYoutube.this, DetailActivity.class);
                startActivity(intent);
            }
        });


        Intent in =getIntent();
        String videoLink = in.getStringExtra("linkVideo");

        //Cắt ra id của video youtube
        String[] link=videoLink.split("embed/");
        String videoid = link[1];

        //Cấu hình Youtube
        YouTubePlayer.OnInitializedListener listener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                // Chèn id
                youTubePlayer.loadVideo(videoid);
                // Tự động play
                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(LinkYoutube.this, "Có lỗi xảy ra", Toast.LENGTH_SHORT).show();
            }
        };

        //Truyền Api Key
        youTubePlayerView.initialize(GoogleAPI.getYoutubeApiKey(),listener);

    }

    private void initView() {
        youTubePlayerView=findViewById(R.id.formula_video);
    }
}