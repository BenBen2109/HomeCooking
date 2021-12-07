package com.cntt.homecooking.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cntt.homecooking.LinkYoutube;
import com.cntt.homecooking.R;
import com.cntt.homecooking.adapter.ChiTietCongThucNauAnAdapter;
import com.cntt.homecooking.api.ApiService;
import com.cntt.homecooking.model.ChiTietCongThucNauAn;
import com.cntt.homecooking.model.ThucPham;
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

    private List<ChiTietCongThucNauAn> chiTietCongThucNauAnListold = new ArrayList<>();
    private List<ChiTietCongThucNauAn> chiTietCongThucNauAnList = new ArrayList<>();
    private List<ThucPham> thucPhamList=new ArrayList<>();
    private ChiTietCongThucNauAnAdapter chiTietCongThucNauAnAdapter;
    private RecyclerView rcvThanhphan;


    String idCongThuc,tenCongThuc,moTaMonAn,linkVideo,linkHinhAnh;

    TextView detailCTMota,detailCTName;
    LinearLayout btnliked;
    ImageView detailCTPic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();

        chiTietCongThucNauAnAdapter=new ChiTietCongThucNauAnAdapter(chiTietCongThucNauAnList,thucPhamList,getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rcvThanhphan.setLayoutManager(linearLayoutManager);
        rcvThanhphan.setAdapter(chiTietCongThucNauAnAdapter);

        getListCtCongthuc();


        Intent intent = getIntent();
        idCongThuc = intent.getStringExtra("idCongThuc");
        tenCongThuc = intent.getStringExtra("tenCongThuc");
        moTaMonAn = intent.getStringExtra("moTaMonAn");
        linkVideo = intent.getStringExtra("linkVideo");
        linkHinhAnh = intent.getStringExtra("linkHinhAnh");

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


    private void getListCtCongthuc() {
        //Api GET List CT Công thức
        ApiService.apiService.getListChiTietCongThucNauAn().enqueue(new Callback<List<ChiTietCongThucNauAn>>() {
            @Override
            public void onResponse(Call<List<ChiTietCongThucNauAn>> call, Response<List<ChiTietCongThucNauAn>> response) {
                chiTietCongThucNauAnListold.addAll(response.body());
                chiTietCongThucNauAnAdapter.notifyDataSetChanged();
                for(ChiTietCongThucNauAn chiTietCongThucNauAn: chiTietCongThucNauAnListold){
                    if(chiTietCongThucNauAn.getIdCongThuc().equals(idCongThuc)){
                        chiTietCongThucNauAnList.add(chiTietCongThucNauAn);
                        chiTietCongThucNauAnAdapter.notifyDataSetChanged();
                    }
                    else{
                    }
                }
//                Toast.makeText(getApplicationContext(), chiTietCongThucNauAnListold+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ChiTietCongThucNauAn>> call, Throwable t) {
            }
        });
        //API GET List Thực phẩm
        ApiService.apiService.getListThucPhams().enqueue(new Callback<List<ThucPham>>() {
            @Override
            public void onResponse(Call<List<ThucPham>> call, Response<List<ThucPham>> response) {
                thucPhamList.addAll(response.body());
                chiTietCongThucNauAnAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ThucPham>> call, Throwable t) {
            }
        });

    }

    private void initView() {
        detailCTMota = findViewById(R.id.detailCTMota);
        detailCTName = findViewById(R.id.detailCTName);
        detailCTPic = findViewById(R.id.detailCTPic);
        linkYTVideo = findViewById(R.id.linkVideo);
        rcvThanhphan=findViewById(R.id.rcvThanhphan);
        btn_detail_formula_cook = findViewById(R.id.btn_detail_formula_cook);
    }
}
