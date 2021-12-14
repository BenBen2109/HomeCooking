package com.cntt.homecooking.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cntt.homecooking.MainActivity;
import com.cntt.homecooking.R;
import com.cntt.homecooking.model.GioHang;
import com.squareup.picasso.Picasso;

public class DetailProduct extends AppCompatActivity {

    TextView detailProductName,productPrice;
    ImageView detailproductPic;
    Button btnAddtocart;
    EditText qtyProduct;

    String id,name,linkHinhAnh,donViTinh;
    Integer price,soluongmua,soluong,sotien;

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
        soluong = intent.getIntExtra("soLuong",0);


        detailProductName.setText(name+" "+soluong+" "+donViTinh);
        productPrice.setText(price+" đ");
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
        soluongmua=Integer.parseInt(qtyProduct.getText().toString().trim());
        boolean tontai = false;
        if(MainActivity.gioHangList.size()>0){
            for(int i=0;i<MainActivity.gioHangList.size();i++){
                if(MainActivity.gioHangList.get(i).getIdFood().equals(id)){
                    MainActivity.gioHangList.get(i).setSoluongmua(MainActivity.gioHangList.get(i).getSoluongmua()+soluongmua);
                    MainActivity.gioHangList.get(i).setSoluong(MainActivity.gioHangList.get(i).getSoluongmua()*soluong);
                    MainActivity.gioHangList.get(i).setPrice(MainActivity.gioHangList.get(i).getSoluongmua()*price);
                    MainActivity.giohangAdapter.notifyDataSetChanged();
                    tontai=true;
                }
            }
            if (tontai==false){
                sotien=soluongmua*price;
                MainActivity.gioHangList.add(new GioHang(id,name,linkHinhAnh,soluong,soluongmua,sotien,donViTinh));
                MainActivity.giohangAdapter.notifyDataSetChanged();
            }
        }
        else {
            sotien=soluongmua*price;
            MainActivity.gioHangList.add(new GioHang(id,name,linkHinhAnh,soluong,soluongmua,sotien,donViTinh));
            MainActivity.giohangAdapter.notifyDataSetChanged();
        };
        Toast.makeText(DetailProduct.this, "Đã thêm sản phẩm vào giỏ hàng", Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        detailProductName=findViewById(R.id.detailProductName);
        productPrice=findViewById(R.id.productPrice);
        detailproductPic=findViewById(R.id.detailproductPic);
        btnAddtocart=findViewById(R.id.btn_add_to_cart);
        qtyProduct=findViewById(R.id.edt_qty);
    }
}