package com.example.android_member.model;

public class NguoiDung {
    private String ID;
    private String TenNguoiDung;
    private String Email;
    private int    Phone;
    private int    imgURL;

    public NguoiDung() {
    }

    public NguoiDung(String ID, String tenNguoiDung, String email, int phone, int imgURL) {
        this.ID = ID;
        TenNguoiDung = tenNguoiDung;
        Email = email;
        Phone = phone;
        this.imgURL = imgURL;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenNguoiDung() {
        return TenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        TenNguoiDung = tenNguoiDung;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public int getImgURL() {
        return imgURL;
    }

    public void setImgURL(int imgURL) {
        this.imgURL = imgURL;
    }
}
