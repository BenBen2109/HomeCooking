package com.cntt.homecooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cntt.homecooking.db.DBManager;
import com.squareup.picasso.Picasso;

public class DetailFormulaActivity extends AppCompatActivity {

    TextView formula_ingredient,detailformulaName,formula_instruct;
    ImageView detailfoodPic;
    LinearLayout btnlikedf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_formula);

        final DBManager db = new DBManager(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String ctcb = intent.getStringExtra("CTCB");
        String thanhPhan = intent.getStringExtra("thanhphan");
        final int idct = intent.getIntExtra("IdCongthuc",0);
        String images = intent.getStringExtra("hinhanh");

        formula_instruct=findViewById(R.id.formula_instruct);
        formula_ingredient=findViewById(R.id.formula_ingredient);
        detailformulaName=findViewById(R.id.detailformulaName);
        detailfoodPic=findViewById(R.id.detailfoodPic);


        detailformulaName.setText(name);
        formula_instruct.setText(ctcb);
        formula_ingredient.setText(thanhPhan);
        if(!images.isEmpty()){
            Picasso.get()
                    .load(images)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(detailfoodPic);
        }



        btnlikedf = findViewById(R.id.btnlikedf);

        btnlikedf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInsert = db.insertLiked(name,null,idct);

                if(isInsert)
                    Toast.makeText(DetailFormulaActivity.this, "Đã thêm vào yêu thích", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DetailFormulaActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}