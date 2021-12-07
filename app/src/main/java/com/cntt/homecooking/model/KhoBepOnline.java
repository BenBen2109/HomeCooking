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

    public KhoBepOnline(String idKhobep, String idKh) {
        this.idKhobep = idKhobep;
        this.idKh = idKh;
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
}
