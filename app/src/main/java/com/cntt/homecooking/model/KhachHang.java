package com.cntt.homecooking.model;

import java.io.Serializable;

public class KhachHang implements Serializable {
    private String idKh;
    private String name;
    private String email;
    private String sdt;
    private String diaChi;
    private String password;
    private String dateCreated;
    private HoaDonKhachHang hoaDonKhachHang;
    private KhoBepOnline khoBepOnline;
    private TheoDoiThucPham theoDoiThucPham;

    public String getIdKh() {
        return idKh;
    }

    public void setIdKh(String idKh) {
        this.idKh = idKh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public HoaDonKhachHang getHoaDonKhachHang() {
        return hoaDonKhachHang;
    }

    public void setHoaDonKhachHang(HoaDonKhachHang hoaDonKhachHang) {
        this.hoaDonKhachHang = hoaDonKhachHang;
    }

    public KhoBepOnline getKhoBepOnline() {
        return khoBepOnline;
    }

    public void setKhoBepOnline(KhoBepOnline khoBepOnline) {
        this.khoBepOnline = khoBepOnline;
    }

    public TheoDoiThucPham getTheoDoiThucPham() {
        return theoDoiThucPham;
    }

    public void setTheoDoiThucPham(TheoDoiThucPham theoDoiThucPham) {
        this.theoDoiThucPham = theoDoiThucPham;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "idKh='" + idKh + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", password='" + password + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", hoaDonKhachHang=" + hoaDonKhachHang +
                ", khoBepOnline=" + khoBepOnline +
                ", theoDoiThucPham=" + theoDoiThucPham +
                '}';
    }
}
