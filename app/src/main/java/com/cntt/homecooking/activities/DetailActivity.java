package com.cntt.homecooking.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cntt.homecooking.R;
import com.cntt.homecooking.db.DBManager;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView detailCTMota,detailCTName;
    LinearLayout btnliked;
    ImageView detailCTPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String tenCongThuc = intent.getStringExtra("tenCongThuc");
        String moTaMonAn = intent.getStringExtra("moTaMonAn");
        String linkVideo = intent.getStringExtra("linkVideo");
        String linkHinhAnh = intent.getStringExtra("linkHinhAnh");

        detailCTMota = findViewById(R.id.detailCTMota);
        detailCTName = findViewById(R.id.detailCTName);
        detailCTPic = findViewById(R.id.detailCTPic);


        detailCTName.setText(tenCongThuc);
        detailCTMota.setText(moTaMonAn);

        if(!linkHinhAnh.isEmpty()){
            Picasso.get()
                    .load(linkHinhAnh)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(detailCTPic);
        }



    }
}
