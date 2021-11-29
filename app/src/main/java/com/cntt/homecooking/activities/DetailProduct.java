package com.cntt.homecooking.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cntt.homecooking.Cart;
import com.cntt.homecooking.MainActivity;
import com.cntt.homecooking.R;
import com.cntt.homecooking.adapter.GioHangAdapter;
import com.cntt.homecooking.databinding.ActivityDetailProductBinding;
import com.cntt.homecooking.model.GioHang;
import com.squareup.picasso.Picasso;

public class DetailProduct extends AppCompatActivity {

    TextView detailProductName,productPrice,productDetailDVT;
    ImageView detailproductPic;
    Button btnAddtocart;
    EditText qtyProduct;

    String id,name,linkHinhAnh,donViTinh;
    Integer price,soluong,sotien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        initView();

        Intent intent = getIntent();
        id=intent.getStringExtra("idFood");
        name = intent.getStringExtra("nameFood");
        price = intent.getIntExtra("price",0);
        linkHinhAnh = intent.getStringExtra("linkHinhAnh");
        donViTinh = intent.getStringExtra("donViTinh");


        detailProductName.setText(name);
        productPrice.setText(price+" đ");
        productDetailDVT.setText(donViTinh);
        if(!linkHinhAnh.isEmpty()){
            Picasso.get()
                    .load(linkHinhAnh)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(detailproductPic);
        }

        btnAddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addtocart();
            }
        });




    }
    // Xử lý thêm sản phẩm vào giỏ hàng
    private void addtocart() {
        soluong=Integer.parseInt(qtyProduct.getText().toString().trim());
        boolean tontai = false;
        if(MainActivity.gioHangList.size()>0){
            for(int i=0;i<MainActivity.gioHangList.size();i++){
                if(MainActivity.gioHangList.get(i).getIdFood().equals(id)){
                    MainActivity.gioHangList.get(i).setSoluong(MainActivity.gioHangList.get(i).getSoluong()+soluong);
                    MainActivity.gioHangList.get(i).setPrice(MainActivity.gioHangList.get(i).getSoluong()*price);
                    tontai=true;
                }
            }
            if (tontai==false){
                sotien=soluong*price;
                MainActivity.gioHangList.add(new GioHang(id,name,linkHinhAnh,soluong,sotien,donViTinh));
                MainActivity.giohangAdapter.notifyItemInserted(MainActivity.gioHangList.size()-1);
            }
        }
        else {
            sotien=soluong*price;
            MainActivity.gioHangList.add(new GioHang(id,name,linkHinhAnh,soluong,sotien,donViTinh));
        };
        Toast.makeText(DetailProduct.this, "Đã thêm sản phẩm vào giỏ hàng", Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        detailProductName=findViewById(R.id.detailProductName);
        productPrice=findViewById(R.id.productPrice);
        detailproductPic=findViewById(R.id.detailproductPic);
        productDetailDVT=findViewById(R.id.productDetailDVT);
        btnAddtocart=findViewById(R.id.btn_add_to_cart);
        qtyProduct=findViewById(R.id.edt_qty);
    }
}