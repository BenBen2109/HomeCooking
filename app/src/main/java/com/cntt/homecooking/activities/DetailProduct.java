package com.cntt.homecooking.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cntt.homecooking.R;
import com.cntt.homecooking.databinding.ActivityDetailProductBinding;
import com.squareup.picasso.Picasso;

public class DetailProduct extends AppCompatActivity {

    TextView detailProductName,productPrice,productDetailDVT;
    ImageView detailproductPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        initView();


        Intent intent  = getIntent();
        String name = intent.getStringExtra("nameFood");
        Integer price = intent.getIntExtra("price",0);
        String linkHinhAnh = intent.getStringExtra("linkHinhAnh");
        String donViTinh = intent.getStringExtra("donViTinh");

        detailProductName.setText(name);
        productPrice.setText(""+price);
        productDetailDVT.setText(donViTinh);
        if(!linkHinhAnh.isEmpty()){
            Picasso.get()
                    .load(linkHinhAnh)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(detailproductPic);
        }


    }

    private void initView() {
        detailProductName=findViewById(R.id.detailProductName);
        productPrice=findViewById(R.id.productPrice);
        detailproductPic=findViewById(R.id.detailproductPic);
        productDetailDVT=findViewById(R.id.productDetailDVT);


    }
}