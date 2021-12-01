package com.cntt.homecooking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChiTietKhoBep {
    @SerializedName("idKhoBep")
    @Expose
    private String idKhoBep;
    @SerializedName("idInvoice")
    @Expose
    private String idInvoice;
    @SerializedName("idLoHang")
    @Expose
    private String idLoHang;
    @SerializedName("soLuongTrongChiTietHoDonKhachHang")
    @Expose
    private Integer soLuongTrongChiTietHoDonKhachHang;
    @SerializedName("status")
    @Expose
    private String status;

    public ChiTietKhoBep(String idKhoBep, String idInvoice, String idLoHang, Integer soLuongTrongChiTietHoDonKhachHang, String status) {
        this.idKhoBep = idKhoBep;
        this.idInvoice = idInvoice;
        this.idLoHang = idLoHang;
        this.soLuongTrongChiTietHoDonKhachHang = soLuongTrongChiTietHoDonKhachHang;
        this.status = status;
    }

    public String getIdKhoBep() {
        return idKhoBep;
    }

    public void setIdKhoBep(String idKhoBep) {
        this.idKhoBep = idKhoBep;
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

    public Integer getSoLuongTrongChiTietHoDonKhachHang() {
        return soLuongTrongChiTietHoDonKhachHang;
    }

    public void setSoLuongTrongChiTietHoDonKhachHang(Integer soLuongTrongChiTietHoDonKhachHang) {
        this.soLuongTrongChiTietHoDonKhachHang = soLuongTrongChiTietHoDonKhachHang;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
