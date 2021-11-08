package com.cntt.homecooking.model;

public class LikedModel {
    String HinhAnh,ThanhPhan,CTCB;
    String TenCongThuc,soLiked;
    int idLiked;
    public LikedModel(){}

    public int getIdLiked() {
        return idLiked;
    }

    public void setIdLiked(int idLiked) {
        this.idLiked = idLiked;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getTenCongThuc() {
        return TenCongThuc;
    }

    public void setTenCongThuc(String tenCongThuc) {
        TenCongThuc = tenCongThuc;
    }

    public String getSoLiked() {
        return soLiked;
    }

    public void setSoLiked(String soLiked) {
        this.soLiked = soLiked;
    }

    public String getThanhPhan() {
        return ThanhPhan;
    }

    public void setThanhPhan(String thanhPhan) {
        ThanhPhan = thanhPhan;
    }

    public String getCTCB() {
        return CTCB;
    }

    public void setCTCB(String CTCB) {
        this.CTCB = CTCB;
    }
}
