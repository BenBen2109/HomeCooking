package com.cntt.homecooking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChuDeCongThuc {
    @SerializedName("idChuDe")
    @Expose
    private String idChuDe;
    @SerializedName("tenChuDe")
    @Expose
    private String tenChuDe;
    @SerializedName("moTaChuDe")
    @Expose
    private String moTaChuDe;
    @SerializedName("linkHinhAnh")
    @Expose
    private String linkHinhAnh;

    public ChuDeCongThuc(String idChuDe, String tenChuDe, String moTaChuDe, String linkHinhAnh) {
        this.idChuDe = idChuDe;
        this.tenChuDe = tenChuDe;
        this.moTaChuDe = moTaChuDe;
        this.linkHinhAnh = linkHinhAnh;
    }

    public String getIdChuDe() {
        return idChuDe;
    }

    public void setIdChuDe(String idChuDe) {
        this.idChuDe = idChuDe;
    }

    public String getTenChuDe() {
        return tenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }

    public String getMoTaChuDe() {
        return moTaChuDe;
    }

    public void setMoTaChuDe(String moTaChuDe) {
        this.moTaChuDe = moTaChuDe;
    }

    public String getLinkHinhAnh() {
        return linkHinhAnh;
    }

    public void setLinkHinhAnh(String linkHinhAnh) {
        this.linkHinhAnh = linkHinhAnh;
    }
}
