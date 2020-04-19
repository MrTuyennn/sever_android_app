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
    @GET("api/sanpham")
    Call<BaseResponse<List<SanPham>>> getAll();
    @GET("api/sanphamnote/{id}")
    Call<BaseResponse<List<SanPham>>> getSanphamcualoai(@Path("id") String loaiId);

    @GET("api/loaisanpham")
    Call<BaseResponse<List<TenLoaiSP>>> getAllloaisanpham();


    @POST("loginuser")
    Call<User> logiuser (@Body HashMap<String,String> map);

    @Headers("Content-Type: application/json")
    @POST("signup")
    Call<Void> signupUser (@Body HashMap<String,String> map);
}
