package com.cntt.homecooking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChiTietHoaDonKhachHang {
    @SerializedName("idInvoice")
    @Expose
    private String idInvoice;
    @SerializedName("idLoHang")
    @Expose
    private String idLoHang;
    @SerializedName("soLuong")
    @Expose
    private Integer soLuong;
    @SerializedName("giaTien")
    @Expose
    private Integer giaTien;

    public ChiTietHoaDonKhachHang(String idInvoice, String idLoHang, Integer soLuong, Integer giaTien) {
        this.idInvoice = idInvoice;
        this.idLoHang = idLoHang;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public String getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getIdLoHang() {
        return idLoHang;
    }

    public void setIdLoHang(String idLoHang) {
        this.idLoHang = idLoHang;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Integer giaTien) {
        this.giaTien = giaTien;
    }
}
