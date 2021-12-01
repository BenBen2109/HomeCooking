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
    @SerializedName("chiTietKhoBeps")
    @Expose
    private ChiTietKhoBep chiTietKhoBeps;

    public KhoBepOnline(String idKhobep, String idKh, ChiTietKhoBep chiTietKhoBeps) {
        this.idKhobep = idKhobep;
        this.idKh = idKh;
        this.chiTietKhoBeps = chiTietKhoBeps;
    }

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
        return chiTietKhoBeps;
    }

    public void setChiTietKhoBeps(ChiTietKhoBep chiTietKhoBeps) {
        this.chiTietKhoBeps = chiTietKhoBeps;
    }
}
