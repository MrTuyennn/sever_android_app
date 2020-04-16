package com.example.android_member.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SanPham implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("MaSP")
    @Expose
    private String maSP;
    @SerializedName("TenLoaiSP")
    @Expose
    private TenLoaiSP tenLoaiSP;
    @SerializedName("TenSP")
    @Expose
    private String tenSP;
    @SerializedName("GiaSP")
    @Expose
    private Integer giaSP;
    @SerializedName("MotaSP")
    @Expose
    private String motaSP;
    @SerializedName("imageSP")
    @Expose
    private String imageSP;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public TenLoaiSP getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(TenLoaiSP tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Integer getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(Integer giaSP) {
        this.giaSP = giaSP;
    }

    public String getMotaSP() {
        return motaSP;
    }

    public void setMotaSP(String motaSP) {
        this.motaSP = motaSP;
    }

    public String getImageSP() {
        return imageSP;
    }

    public void setImageSP(String imageSP) {
        this.imageSP = imageSP;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
