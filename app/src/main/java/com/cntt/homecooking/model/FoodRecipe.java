package com.cntt.homecooking.model;

import java.util.Date;

public class FoodRecipe {

    private int IdCongThuc;
    private int IdBuoi;
    private String TenCongThuc;
    private String CTCB;
    private String MoTa;
    private Date NgayDang;
    private String ThanhPhan;
    private String HinhAnh;



    public FoodRecipe(int idCongThuc, int idBuoi, String tenCongThuc, String CTCB, String moTa, Date ngayDang, String thanhPhan, String HinhAnh) {
        IdCongThuc = idCongThuc;
        IdBuoi = idBuoi;
        TenCongThuc = tenCongThuc;
        this.CTCB = CTCB;
        MoTa = moTa;
        this.HinhAnh = HinhAnh;
        NgayDang = ngayDang;
        ThanhPhan = thanhPhan;
    }

    public int getIdCongThuc() {
        return IdCongThuc;
    }

    public void setIdCongThuc(int idCongThuc) {
        IdCongThuc = idCongThuc;
    }

    public int getIdBuoi() {
        return IdBuoi;
    }

    public void setIdBuoi(int idBuoi) {
        IdBuoi = idBuoi;
    }

    public String getTenCongThuc() {
        return TenCongThuc;
    }

    public void setTenCongThuc(String tenCongThuc) {
        TenCongThuc = tenCongThuc;
    }

    public String getCTCB() {
        return CTCB;
    }

    public void setCTCB(String CTCB) {
        this.CTCB = CTCB;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public Date getNgayDang() {
        return NgayDang;
    }

    public void setNgayDang(Date ngayDang) {
        NgayDang = ngayDang;
    }

    public String getThanhPhan() {
        return ThanhPhan;
    }

    public void setThanhPhan(String thanhPhan) {
        ThanhPhan = thanhPhan;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        TenCongThuc = hinhAnh;
    }
}
