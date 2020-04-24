package com.example.android_member.api;

import com.example.android_member.model.BaseResponse;
import com.example.android_member.model.SanPham;
import com.example.android_member.model.TenLoaiSP;
import com.example.android_member.model.User;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    // Lấy Toàn bộ sản phẩm
    @GET("api/sanpham")
    Call<BaseResponse<List<SanPham>>> getAll();

    // lấy sản phẩm theo loại sản phẩm
    @GET("api/sanphamnote/{id}")
    Call<BaseResponse<List<SanPham>>> getSanphamcualoai(@Path("id") String loaiId);

    // lấy loại sản phẩm
    @GET("api/loaisanpham")
    Call<BaseResponse<List<TenLoaiSP>>> getAllloaisanpham();

    // lấy sản phẩm theo giá >= 5.000.000
    @GET("api/getpricegte")
    Call<BaseResponse<List<SanPham>>> Getpricegte();

    // lấy sản phẩm theo giá <= 5.000.000
    @GET("api/getpricelte")
    Call<BaseResponse<List<SanPham>>> Getpricelte();


    @POST("loginuser")
    Call<User> logiuser (@Body HashMap<String,String> map);

    @Headers("Content-Type: application/json")
    @POST("signup")
    Call<Void> signupUser (@Body HashMap<String,String> map);

    @GET("/getalluser")
    Call<BaseResponse<List<User>>> getUser();
}
