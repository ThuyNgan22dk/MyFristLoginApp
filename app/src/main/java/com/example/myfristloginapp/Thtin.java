package com.example.myfristloginapp;

public class Thtin {
    private String ngay;
    private String soLan;
    private String danhGia;

    public Thtin(String ngay, String soLan, String danhGia) {
        this.ngay = ngay;
        this.soLan = soLan;
        this.danhGia = danhGia;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getSoLan() {
        return soLan;
    }

    public void setSoLan(String soLan) {
        this.soLan = soLan;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }
}
