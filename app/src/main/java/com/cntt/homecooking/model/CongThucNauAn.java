package com.cntt.homecooking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CongThucNauAn {
    @SerializedName("idCongThuc")
    @Expose
    private String idCongThuc;
    @SerializedName("tenCongThuc")
    @Expose
    private String tenCongThuc;
    @SerializedName("tacGia")
    @Expose
    private Object tacGia;
    @SerializedName("moTaMonAn")
    @Expose
    private String moTaMonAn;
    @SerializedName("linkVideo")
    @Expose
    private String linkVideo;
    @SerializedName("linkHinhAnh")
    @Expose
    private String linkHinhAnh;
    @SerializedName("ngayTao")
    @Expose
    private String ngayTao;

    public String getIdCongThuc() {
        return idCongThuc;
    }

    public void setIdCongThuc(String idCongThuc) {
        this.idCongThuc = idCongThuc;
    }

    public String getTenCongThuc() {
        return tenCongThuc;
    }

    public void setTenCongThuc(String tenCongThuc) {
        this.tenCongThuc = tenCongThuc;
    }

    public Object getTacGia() {
        return tacGia;
    }

    public void setTacGia(Object tacGia) {
        this.tacGia = tacGia;
    }

    public String getMoTaMonAn() {
        return moTaMonAn;
    }

    public void setMoTaMonAn(String moTaMonAn) {
        this.moTaMonAn = moTaMonAn;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }

    public String getLinkHinhAnh() {
        return linkHinhAnh;
    }

    public void setLinkHinhAnh(String linkHinhAnh) {
        this.linkHinhAnh = linkHinhAnh;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
}
