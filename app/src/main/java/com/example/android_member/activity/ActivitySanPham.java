package com.example.android_member.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.android_member.R;
import com.example.android_member.api.API;
import com.example.android_member.api.RetrofitClient;
import com.example.android_member.model.BaseResponse;
import com.example.android_member.model.SanPham;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitySanPham extends AppCompatActivity {
    String loaiId = "";
    RetrofitClient retrofit = new RetrofitClient();
    List<SanPham> sanPhamList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);
        Intent i = getIntent();
        if (i != null){
            loaiId = i.getStringExtra("Id");
        }
        getData();
    }

    private void getData() {
        API api = retrofit.getClient().create(API.class);
        api.getSanphamcualoai(loaiId).enqueue(new Callback<BaseResponse<List<SanPham>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<SanPham>>> call, Response<BaseResponse<List<SanPham>>> response) {
                Log.d("fff", loaiId);
                Log.d("vvv" , response.code() + " " );
                if (response.isSuccessful()){
                    sanPhamList = response.body().getData();
                    Log.d("alo",sanPhamList.get(0).getTenSP());
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<SanPham>>> call, Throwable t) {
                Log.d("bbb" , t.getMessage());
            }
        });
    }
}
