package com.cntt.homecooking.model;

public class GioHang {
    private String idFood;
    private String nameFood;
    private String linkHinhAnh;
    private Integer soluong;
    private Integer price;
    private String donViTinh;

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

    public String getLinkHinhAnh() {
        return linkHinhAnh;
    }

    public void setLinkHinhAnh(String linkHinhAnh) {
        this.linkHinhAnh = linkHinhAnh;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public GioHang(String idFood, String nameFood, String linkHinhAnh, Integer soluong, Integer price, String donViTinh) {
        this.idFood = idFood;
        this.nameFood = nameFood;
        this.linkHinhAnh = linkHinhAnh;
        this.soluong = soluong;
        this.price = price;
        this.donViTinh = donViTinh;


    }
}
