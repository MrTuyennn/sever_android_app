package com.example.android_member.model;

import android.graphics.drawable.Drawable;

public class LoaiSanPham {
    private int    ID;
    private String MaLoaiSP;
    private String TenLoaiSP;
    private int    ImgLoaiSP;

    public LoaiSanPham() {
    }

    public LoaiSanPham(int ID, String maLoaiSP, String tenLoaiSP, int imgLoaiSP) {
        this.ID = ID;
        MaLoaiSP = maLoaiSP;
        TenLoaiSP = tenLoaiSP;
        ImgLoaiSP = imgLoaiSP;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaLoaiSP() {
        return MaLoaiSP;
    }

    public void setMaLoaiSP(String maLoaiSP) {
        MaLoaiSP = maLoaiSP;
    }

    public String getTenLoaiSP() {
        return TenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        TenLoaiSP = tenLoaiSP;
    }

    public int getImgLoaiSP() {
        return ImgLoaiSP;
    }

    public void setImgLoaiSP(int imgLoaiSP) {
        ImgLoaiSP = imgLoaiSP;
    }
}
