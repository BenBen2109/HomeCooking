package com.cntt.homecooking.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cntt.homecooking.LinkYoutube;
import com.cntt.homecooking.R;
import com.cntt.homecooking.api.ApiService;
import com.cntt.homecooking.db.DBManager;
import com.cntt.homecooking.model.ChiTietCongThucNauAn;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    Button linkYTVideo,btn_detail_formula_cook;

    private SharedPreferences sharedPreferences;

    private ChiTietCongThucNauAn chiTietCongThucNauAn;

    private List<ChiTietCongThucNauAn> chiTietCongThucNauAns = new ArrayList<>();

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
        linkYTVideo = findViewById(R.id.linkVideo);
        btn_detail_formula_cook = findViewById(R.id.btn_detail_formula_cook);


        detailCTName.setText(tenCongThuc);
        detailCTMota.setText(moTaMonAn);

        if(!linkHinhAnh.isEmpty()){
            Picasso.get()
                    .load(linkHinhAnh)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(detailCTPic);
        }

        linkYTVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(DetailActivity.this, LinkYoutube.class);
                in.putExtra("linkVideo",linkVideo);
                startActivity(in);
            }
        });
//        btn_detail_formula_cook.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ApiService.apiService.getTP().enqueue(new Callback<List<ChiTietCongThucNauAn>>() {
//                    @Override
//                    public void onResponse(Call<List<ChiTietCongThucNauAn>> call, Response<List<ChiTietCongThucNauAn>> response) {
//                        if(response.isSuccessful()){
//                            List<ChiTietCongThucNauAn> chiTietCongThucNauAns=response.body();
//                            String text ="";
//                            for(int i=0;i<chiTietCongThucNauAns.size();i++){
//                                text = text + chiTietCongThucNauAns.get(i).toString()+"\n";
//                            }
//                            Log.e("List TP",chiTietCongThucNauAns.size()+"");
//                            Toast.makeText(DetailActivity.this, text, Toast.LENGTH_SHORT).show();
//                        }else {
//                            Toast.makeText(DetailActivity.this, ""+response.errorBody().toString(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<ChiTietCongThucNauAn>> call, Throwable t) {
//                        Toast.makeText(DetailActivity.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });

    }
}
