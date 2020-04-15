package com.example.android_member.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TenLoaiSP {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("TenLoaiSP")
    @Expose
    private String tenLoaiSP;
    @SerializedName("image")
    @Expose
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}