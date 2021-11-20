package com.cntt.homecooking.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cntt.homecooking.Me;
import com.cntt.homecooking.R;
import com.cntt.homecooking.databinding.ActivityDetailProductBinding;
import com.cntt.homecooking.model.ThucPham;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailProduct extends AppCompatActivity {

    TextView detailProductName,productPrice,productDetailDVT;
    ImageView detailproductPic;
    Button btnAddToCart;

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


        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        final Me me = new Me();
        final ThucPham thucPham = new ThucPham();

//
//        btnAddToCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v,int position) {
//                Bundle bundle = new Bundle();
//                bundle.putString("name",thucPham.getNameFood());
//                Toast.makeText(DetailProduct.this, "" + thucPham.getNameFood(), Toast.LENGTH_SHORT).show();
////                me.setArguments(bundle);
////                fragmentTransaction.add(R.id.cart_view,me).commit();
//            }
//        });
    }

    private void initView() {
        detailProductName=findViewById(R.id.detailProductName);
        productPrice=findViewById(R.id.productPrice);
        detailproductPic=findViewById(R.id.detailproductPic);
        productDetailDVT=findViewById(R.id.productDetailDVT);
        btnAddToCart=findViewById(R.id.btnAddToCart);


    }
}