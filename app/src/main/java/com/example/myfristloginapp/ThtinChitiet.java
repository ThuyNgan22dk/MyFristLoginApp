package com.example.myfristloginapp;

public class ThtinChitiet {
    private String ten;
    private int h_anh;
    private String mota;

    public ThtinChitiet(String ten, int h_anh, String mota) {
        this.ten = ten;
        this.h_anh = h_anh;
        this.mota = mota;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getH_anh() {
        return h_anh;
    }

    public void setH_anh(int h_anh) {
        this.h_anh = h_anh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
