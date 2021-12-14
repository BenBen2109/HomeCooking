package com.cntt.homecooking.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cntt.homecooking.R;
import com.cntt.homecooking.api.ApiService;
import com.cntt.homecooking.data_local.DataLocalManager;
import com.cntt.homecooking.model.KhachHang;
import com.google.android.gms.common.api.Api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfo extends AppCompatActivity {


    private EditText user_Name,user_Email,user_Phone;
    private Button update;

    KhachHang khachHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        user_Name = findViewById(R.id.userName);
        user_Email = findViewById(R.id.userEmail);
        user_Phone = findViewById(R.id.userPhone);
        update = findViewById(R.id.update);

        String userName = DataLocalManager.getUserName();
        user_Name.setText(userName.toString());

        String userEmail = DataLocalManager.getUserEmail();
        user_Email.setText(userEmail.toString());

        String userPhone = DataLocalManager.getUserPhone();
        user_Phone.setText(userPhone.toString());

        String name = user_Name.getText().toString().trim();
        String email = user_Email.getText().toString().trim();
        String sdt = user_Phone.getText().toString().trim();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KhachHang khachHang = new KhachHang(name,email,sdt);
//                updateinfo(khachHang);
            }
        });

    }

//    private void updateinfo(KhachHang khachHang) {
//        String idKh = DataLocalManager.getUserId();
//        ApiService.apiService.update("KH000001",khachHang).enqueue(new Callback<KhachHang>() {
//            @Override
//            public void onResponse(Call<KhachHang> call, Response<KhachHang> response) {
//                if(response.isSuccessful()){
//                    Toast.makeText(UserInfo.this, "success", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(UserInfo.this, "Error", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<KhachHang> call, Throwable t) {
//                Toast.makeText(UserInfo.this, "Eorrirrr", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}