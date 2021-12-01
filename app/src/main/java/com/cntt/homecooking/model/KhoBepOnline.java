package com.cntt.homecooking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KhoBepOnline {
    @SerializedName("idKhobep")
    @Expose
    private String idKhobep;
    @SerializedName("idKh")
    @Expose
    private String idKh;
    @SerializedName("chiTietKhoBep")// "chiTietKhoBeps" bị lỗi
    @Expose
    private ChiTietKhoBep chiTietKhoBep;

    public String getIdKhobep() {
        return idKhobep;
    }

    public void setIdKhobep(String idKhobep) {
        this.idKhobep = idKhobep;
    }

    public String getIdKh() {
        return idKh;
    }

    public void setIdKh(String idKh) {
        this.idKh = idKh;
    }

    public ChiTietKhoBep getChiTietKhoBeps() {
        return chiTietKhoBep;
    }

    public void setChiTietKhoBeps(ChiTietKhoBep chiTietKhoBeps) {
        this.chiTietKhoBep = chiTietKhoBeps;
    }

    public KhoBepOnline(String idKhobep, String idKh, ChiTietKhoBep chiTietKhoBeps) {
        this.idKhobep = idKhobep;
        this.idKh = idKh;
        this.chiTietKhoBep = chiTietKhoBeps;
    }
}
