package com.cntt.homecooking.model;

public class HoaDonKhachHang {

    private String idInvoice;
    private String idKh;
    private String createdDate;
    private String deliveryDate;
    private int tongTien;
    private String phuongThucThanhToan;
    private String status;
    private String idKhNavigation;
    private String idNvNavigation;
    private String chiTietHoaDonKhachHangs;
    private String chiTietKhoBeps;


    public String getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getIdKh() {
        return idKh;
    }

    public void setIdKh(String idKh) {
        this.idKh = idKh;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdKhNavigation() {
        return idKhNavigation;
    }

    public void setIdKhNavigation(String idKhNavigation) {
        this.idKhNavigation = idKhNavigation;
    }

    public String getIdNvNavigation() {
        return idNvNavigation;
    }

    public void setIdNvNavigation(String idNvNavigation) {
        this.idNvNavigation = idNvNavigation;
    }

    public String getChiTietHoaDonKhachHangs() {
        return chiTietHoaDonKhachHangs;
    }

    public void setChiTietHoaDonKhachHangs(String chiTietHoaDonKhachHangs) {
        this.chiTietHoaDonKhachHangs = chiTietHoaDonKhachHangs;
    }

    public String getChiTietKhoBeps() {
        return chiTietKhoBeps;
    }

    public void setChiTietKhoBeps(String chiTietKhoBeps) {
        this.chiTietKhoBeps = chiTietKhoBeps;
    }
}
