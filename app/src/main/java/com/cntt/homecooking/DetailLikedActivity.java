package com.cntt.homecooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.cntt.homecooking.db.DBManager;

public class DetailLikedActivity extends AppCompatActivity {

    TextView detaillikedfoodName,formula_ingredient_liked,formula_instruct_liked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_liked);

        final DBManager db = new DBManager(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("tencongthuc");
        String thanhphan = intent.getStringExtra("thanhPhan");
        String ctcb = intent.getStringExtra("CTCB");


        detaillikedfoodName = findViewById(R.id.detaillikedfoodName);
        formula_ingredient_liked = findViewById(R.id.formula_ingredient_liked);
        formula_instruct_liked = findViewById(R.id.formula_instruct_liked);


        formula_ingredient_liked.setText(thanhphan);
        formula_instruct_liked.setText(ctcb);
        detaillikedfoodName.setText(name);

    }
}