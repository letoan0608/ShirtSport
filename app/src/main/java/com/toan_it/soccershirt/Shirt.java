package com.toan_it.soccershirt;

public class Shirt {

    public String hinh;
    public String tenhinh;
    public String nhanhieu;
    public String gia;

    public Shirt(){}

    public Shirt(String hinh, String tenhinh, String nhanhieu, String gia) {
        this.hinh = hinh;
        this.tenhinh = tenhinh;
        this.nhanhieu = nhanhieu;
        this.gia = gia;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getTenhinh() {
        return tenhinh;
    }

    public void setTenhinh(String tenhinh) {
        this.tenhinh = tenhinh;
    }

    public String getNhanhieu() {
        return nhanhieu;
    }

    public void setNhanhieu(String nhanhieu) {
        this.nhanhieu = nhanhieu;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
