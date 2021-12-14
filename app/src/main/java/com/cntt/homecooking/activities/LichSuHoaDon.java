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
import com.cntt.homecooking.data_local.DataLocalManager;
import com.cntt.homecooking.model.HoaDonKhachHang;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LichSuHoaDon extends AppCompatActivity {

    private List<HoaDonKhachHang> hoaDonKhachHangList = new ArrayList<>();
    private List<HoaDonKhachHang> hoaDonKhachHangListold = new ArrayList<>();
    private RecyclerView rclview_LichSuHoaDon;
    private HoaDonKhachHangAdapter hoaDonKhachHangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_hoa_don);

        initView();
        
        hoaDonKhachHangAdapter = new HoaDonKhachHangAdapter(hoaDonKhachHangList,getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rclview_LichSuHoaDon.setLayoutManager(linearLayoutManager);
        rclview_LichSuHoaDon.setAdapter(hoaDonKhachHangAdapter);
        
        getListHoadonkhachhang();


    }

    private void LocHoadon(String idKH) {
        for(HoaDonKhachHang hoaDonKhachHang: hoaDonKhachHangListold){
            if(hoaDonKhachHang.getIdKh().equals(idKH)){
                hoaDonKhachHangList.add(hoaDonKhachHang);
                hoaDonKhachHangAdapter.notifyDataSetChanged();
            }
        }
        hoaDonKhachHangAdapter.notifyDataSetChanged();
    }

    private void getListHoadonkhachhang() {
        ApiService.apiService.getListHoaDonKhachHang().enqueue(new Callback<List<HoaDonKhachHang>>() {
            @Override
            public void onResponse(Call<List<HoaDonKhachHang>> call, Response<List<HoaDonKhachHang>> response) {
                hoaDonKhachHangListold.addAll(response.body());
                LocHoadon(DataLocalManager.getUserId());
                hoaDonKhachHangAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<HoaDonKhachHang>> call, Throwable t) {

            }
        });
    }

    private void initView() {
        rclview_LichSuHoaDon= findViewById(R.id.rclview_LichSuHoaDon);
    }

}