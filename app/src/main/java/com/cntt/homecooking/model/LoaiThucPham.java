package com.cntt.homecooking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoaiThucPham {
    @SerializedName("idLoai")
    @Expose
    private String idLoai;
    @SerializedName("tenLoai")
    @Expose
    private String tenLoai;
    @SerializedName("linkHinhAnh")
    @Expose
    private String linkHinhAnh;

    public LoaiThucPham(String idLoai, String tenLoai, String linkHinhAnh) {
        this.idLoai = idLoai;
        this.tenLoai = tenLoai;
        this.linkHinhAnh = linkHinhAnh;
    }

    public String getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(String idLoai) {
        this.idLoai = idLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getLinkHinhAnh() {
        return linkHinhAnh;
    }

    public void setLinkHinhAnh(String linkHinhAnh) {
        this.linkHinhAnh = linkHinhAnh;
    }
}
