package com.cntt.homecooking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KhuyenMai {
    @SerializedName("idKhuyenMai")
    @Expose
    private String idKhuyenMai;
    @SerializedName("ngayBatDau")
    @Expose
    private String ngayBatDau;
    @SerializedName("ngayKetThuc")
    @Expose
    private String ngayKetThuc;
    @SerializedName("moTaKhuyenMai")
    @Expose
    private String moTaKhuyenMai;
    @SerializedName("phanTramKhuyenMai")
    @Expose
    private Integer phanTramKhuyenMai;

    public KhuyenMai(String idKhuyenMai, String ngayBatDau, String ngayKetThuc, String moTaKhuyenMai, Integer phanTramKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.moTaKhuyenMai = moTaKhuyenMai;
        this.phanTramKhuyenMai = phanTramKhuyenMai;
    }

    public String getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(String idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMoTaKhuyenMai() {
        return moTaKhuyenMai;
    }

    public void setMoTaKhuyenMai(String moTaKhuyenMai) {
        this.moTaKhuyenMai = moTaKhuyenMai;
    }

    public Integer getPhanTramKhuyenMai() {
        return phanTramKhuyenMai;
    }

    public void setPhanTramKhuyenMai(Integer phanTramKhuyenMai) {
        this.phanTramKhuyenMai = phanTramKhuyenMai;
    }
}
