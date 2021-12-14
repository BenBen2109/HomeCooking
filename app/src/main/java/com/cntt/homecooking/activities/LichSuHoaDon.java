package com.cntt.homecooking.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.cntt.homecooking.R;
import com.cntt.homecooking.adapter.HoaDonKhachHangAdapter;
import com.cntt.homecooking.api.ApiService;
import com.cntt.homecooking.model.HoaDonKhachHang;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LichSuHoaDon extends AppCompatActivity {

    private List<HoaDonKhachHang> mHoaDonKhachHangs = new ArrayList<>();
    private RecyclerView rclview_LichSuHoaDon;
    private HoaDonKhachHangAdapter hoaDonKhachHangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_hoa_don);


        rclview_LichSuHoaDon= findViewById(R.id.rclview_LichSuHoaDon);

        
        hoaDonKhachHangAdapter = new HoaDonKhachHangAdapter(mHoaDonKhachHangs,getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rclview_LichSuHoaDon.setLayoutManager(linearLayoutManager);
        rclview_LichSuHoaDon.setAdapter(hoaDonKhachHangAdapter);



    }

}