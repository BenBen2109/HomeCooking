package com.cntt.homecooking.model;

public class GioHang {
    private String nameFood;
    private String linkHinhAnh;
    private Integer soluong;
    private Integer price;

    public GioHang(String nameFood, String linkHinhAnh, Integer soluong, Integer price) {
        this.nameFood = nameFood;
        this.linkHinhAnh = linkHinhAnh;
        this.soluong = soluong;
        this.price = price;
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
}
