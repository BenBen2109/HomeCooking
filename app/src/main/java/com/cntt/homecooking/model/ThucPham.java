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
        private Object idKhuyenMai;
        @SerializedName("linkHinhAnh")
        @Expose
        private String linkHinhAnh;
        @SerializedName("idKhuyenMaiNavigation")
        @Expose
        private Object idKhuyenMaiNavigation;
        @SerializedName("idLoaiNavigation")
        @Expose
        private Object idLoaiNavigation;
        @SerializedName("idNsxNavigation")
        @Expose
        private Object idNsxNavigation;
        @SerializedName("chiTietCongThucNauAns")
        @Expose
        private List<Object> chiTietCongThucNauAns = null;
        @SerializedName("loHangs")
        @Expose
        private List<Object> loHangs = null;
        @SerializedName("theoDoiThucPhams")
        @Expose
        private List<Object> theoDoiThucPhams = null;

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

        public Object getIdKhuyenMai() {
            return idKhuyenMai;
        }

        public void setIdKhuyenMai(Object idKhuyenMai) {
            this.idKhuyenMai = idKhuyenMai;
        }

        public String getLinkHinhAnh() {
            return linkHinhAnh;
        }

        public void setLinkHinhAnh(String linkHinhAnh) {
            this.linkHinhAnh = linkHinhAnh;
        }

        public Object getIdKhuyenMaiNavigation() {
            return idKhuyenMaiNavigation;
        }

        public void setIdKhuyenMaiNavigation(Object idKhuyenMaiNavigation) {
            this.idKhuyenMaiNavigation = idKhuyenMaiNavigation;
        }

        public Object getIdLoaiNavigation() {
            return idLoaiNavigation;
        }

        public void setIdLoaiNavigation(Object idLoaiNavigation) {
            this.idLoaiNavigation = idLoaiNavigation;
        }

        public Object getIdNsxNavigation() {
            return idNsxNavigation;
        }

        public void setIdNsxNavigation(Object idNsxNavigation) {
            this.idNsxNavigation = idNsxNavigation;
        }

        public List<Object> getChiTietCongThucNauAns() {
            return chiTietCongThucNauAns;
        }

        public void setChiTietCongThucNauAns(List<Object> chiTietCongThucNauAns) {
            this.chiTietCongThucNauAns = chiTietCongThucNauAns;
        }

        public List<Object> getLoHangs() {
            return loHangs;
        }

        public void setLoHangs(List<Object> loHangs) {
            this.loHangs = loHangs;
        }

        public List<Object> getTheoDoiThucPhams() {
            return theoDoiThucPhams;
        }

        public void setTheoDoiThucPhams(List<Object> theoDoiThucPhams) {
            this.theoDoiThucPhams = theoDoiThucPhams;
        }
    }