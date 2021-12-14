package com.cntt.homecooking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoHang {
    @SerializedName("idLoHang")
    @Expose
    private String idLoHang;
    @SerializedName("idFood")
    @Expose
    private String idFood;
    @SerializedName("soLuong")
    @Expose
    private Integer soLuong;
    @SerializedName("ngaySanXuat")
    @Expose
    private String ngaySanXuat;
    @SerializedName("ngayHetHan")
    @Expose
    private String ngayHetHan;
    @SerializedName("ngayNhapLoHang")
    @Expose
    private String ngayNhapLoHang;

    public LoHang(String idLoHang, String idFood, Integer soLuong, String ngaySanXuat, String ngayHetHan, String ngayNhapLoHang) {
        this.idLoHang = idLoHang;
        this.idFood = idFood;
        this.soLuong = soLuong;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.ngayNhapLoHang = ngayNhapLoHang;
    }

    public String getIdLoHang() {
        return idLoHang;
    }

    public void setIdLoHang(String idLoHang) {
        this.idLoHang = idLoHang;
    }

    public String getIdFood() {
        return idFood;
    }

    public void setIdFood(String idFood) {
        this.idFood = idFood;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(String ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getNgayNhapLoHang() {
        return ngayNhapLoHang;
    }

    public void setNgayNhapLoHang(String ngayNhapLoHang) {
        this.ngayNhapLoHang = ngayNhapLoHang;
    }
}
