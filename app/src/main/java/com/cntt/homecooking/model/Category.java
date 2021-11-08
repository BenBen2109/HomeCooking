package com.cntt.homecooking.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Category {

    private int IdTheLoai;
    private String TenTheLoai;
    private String HinhAnhLoai;

    public Category(int idTheLoai, String tenTheLoai, String hinhAnhLoai) {
        IdTheLoai = idTheLoai;
        TenTheLoai = tenTheLoai;
        HinhAnhLoai = hinhAnhLoai;
    }

    public int getIdTheLoai() {
        return IdTheLoai;
    }

    public void setIdTheLoai(int idTheLoai) {
        IdTheLoai = idTheLoai;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        TenTheLoai = tenTheLoai;
    }

    public String getHinhAnhLoai() {
        return HinhAnhLoai;
    }

    public void setHinhAnhLoai(String hinhAnhLoai) {
        HinhAnhLoai = hinhAnhLoai;
    }



}
