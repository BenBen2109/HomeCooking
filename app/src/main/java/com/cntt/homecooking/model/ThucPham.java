package com.cntt.homecooking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ThucPham {


        @SerializedName("idFood")
        @Expose
        private String idFood;
        @SerializedName("nameFood")
        @Expose
        private String nameFood;
        @SerializedName("soLuong")
        @Expose
        private Integer soLuong;
        @SerializedName("donViTinh")
        @Expose
        private String donViTinh;
        @SerializedName("purchasePrice")
        @Expose
        private Integer purchasePrice;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("idNsx")
        @Expose
        private String idNsx;
        @SerializedName("dateCreated")
        @Expose
        private String dateCreated;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("idLoai")
        @Expose
        private String idLoai;
        @SerializedName("idKhuyenMai")
        @Expose
        private String idKhuyenMai;
        @SerializedName("linkHinhAnh")
        @Expose
        private String linkHinhAnh;

    public String getIdFood() {
        return idFood;
    }

    public void setIdFood(String idFood) {
        this.idFood = idFood;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getIdNsx() {
        return idNsx;
    }

    public void setIdNsx(String idNsx) {
        this.idNsx = idNsx;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(String idLoai) {
        this.idLoai = idLoai;
    }

    public String getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(String idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public String getLinkHinhAnh() {
        return linkHinhAnh;
    }

    public void setLinkHinhAnh(String linkHinhAnh) {
        this.linkHinhAnh = linkHinhAnh;
    }

    @Override
    public String toString() {
        return "ThucPham{" +'\n'+
                "IdFood='" + idFood + "'\n" +
                ", NameFood='" + nameFood + "'\n" +
                ", SoLuong=" + soLuong +
                ", DonViTinh='" + donViTinh + "'\n" +
                ", PurchasePrice=" + purchasePrice +
                ", Price=" + price +
                ", IdNSX='" + idNsx + "'\n" +
                ", DateCreated='" + dateCreated + "'\n" +
                ", Status='" + status + "'\n" +
                ", IdLoai='" + idLoai + "'\n" +
                ", IdKhuyenMai='" + idKhuyenMai + "'\n" +
                ", LinkHinhAnh='" + linkHinhAnh + "'\n" +
                '}';
    }
}