package com.example.android_member.model;

public class GioHang {
    private int ID;
    private String Image;
    private String Tensanpham;
    private int Giasanpham;
    private String NgayMua;
    private String Trangthai;

    public GioHang(int ID, String image, String tensanpham, int giasanpham, String ngayMua, String trangthai) {
        this.ID = ID;
        Image = image;
        Tensanpham = tensanpham;
        Giasanpham = giasanpham;
        NgayMua = ngayMua;
        Trangthai = trangthai;
    }

    public GioHang(String image, String tensanpham, int giasanpham, String ngayMua, String trangthai) {
        Image = image;
        Tensanpham = tensanpham;
        Giasanpham = giasanpham;
        NgayMua = ngayMua;
        Trangthai = trangthai;
    }

    public int getID() {
        return ID;
    }

    public String getImage() {
        return Image;
    }

    public String getTensanpham() {
        return Tensanpham;
    }

    public int getGiasanpham() {
        return Giasanpham;
    }

    public String getNgayMua() {
        return NgayMua;
    }

    public String getTrangthai() {
        return Trangthai;
    }
}
