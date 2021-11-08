package com.cntt.homecooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cntt.homecooking.db.DBManager;
import com.cntt.homecooking.model.Popular;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    TextView detailfoodName, formula_ingredient, formula_instruct,idct;
    LinearLayout btnliked;
    ImageView detailfoodPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);




        final DBManager db = new DBManager(this);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("tencongthuc");
        final String ctcb = intent.getStringExtra("CTCB");
        final String thanhPhan = intent.getStringExtra("thanhphan");
        final int idct = intent.getIntExtra("idcongthuc",0);
        final String images = intent.getStringExtra("hinhanh");

//        Toast.makeText(this, "name"+thanhPhan, Toast.LENGTH_SHORT).show();




        detailfoodName = findViewById(R.id.detailfoodName);
        formula_ingredient = findViewById(R.id.formula_ingredient);
        formula_instruct = findViewById(R.id.formula_instruct);
        btnliked = findViewById(R.id.btnliked);
        detailfoodPic = findViewById(R.id.detailfoodPic);


        detailfoodName.setText(name);
        formula_instruct.setText(ctcb);
        formula_ingredient.setText(thanhPhan);
        if(!images.isEmpty()){
            Picasso.get()
                    .load(images)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(detailfoodPic);
        }

        btnliked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInsert = db.insertLiked(name,null,idct);

                if(isInsert)
                    Toast.makeText(DetailActivity.this, "Đã thêm vào yêu thích", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DetailActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
