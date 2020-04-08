package com.example.android_member.model;

public class SanPham {
    private int    ID;
    private String MaSP;
    private String TenSP;
    private int    GiaSP;
    private String MoTa;
    private int    ImgSP;

    public SanPham() {
    }

    public SanPham(int ID, String maSP, String tenSP, int giaSP, String moTa, int imgSP) {
        this.ID = ID;
        MaSP = maSP;
        TenSP = tenSP;
        GiaSP = giaSP;
        MoTa = moTa;
        ImgSP = imgSP;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public int getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(int giaSP) {
        GiaSP = giaSP;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public int getImgSP() {
        return ImgSP;
    }

    public void setImgSP(int imgSP) {
        ImgSP = imgSP;
    }
}
