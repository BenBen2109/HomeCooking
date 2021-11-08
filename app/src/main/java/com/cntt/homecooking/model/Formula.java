package com.cntt.homecooking.model;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.cntt.homecooking.R;
import com.cntt.homecooking.adapter.FormulaAdapter;

import java.util.ArrayList;
import java.util.List;

public class Formula  {

    private int IdCongThuc;
    private String TenCongThuc;
    private String HinhAnh;
    private String CTCB;
    private String ThanhPhan;

    public Formula(int idCongThuc, String tenCongThuc, String hinhAnh, String CTCB, String thanhPhan) {
        IdCongThuc = idCongThuc;
        TenCongThuc = tenCongThuc;
        HinhAnh = hinhAnh;
        this.CTCB = CTCB;
        ThanhPhan = thanhPhan;
    }

    public int getIdCongThuc() {
        return IdCongThuc;
    }

    public void setIdCongThuc(int idCongThuc) {
        IdCongThuc = idCongThuc;
    }

    public String getTenCongThuc() {
        return TenCongThuc;
    }

    public void setTenCongThuc(String tenCongThuc) {
        TenCongThuc = tenCongThuc;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getCTCB() {
        return CTCB;
    }

    public void setCTCB(String CTCB) {
        this.CTCB = CTCB;
    }

    public String getThanhPhan() {
        return ThanhPhan;
    }

    public void setThanhPhan(String thanhPhan) {
        ThanhPhan = thanhPhan;
    }
}



