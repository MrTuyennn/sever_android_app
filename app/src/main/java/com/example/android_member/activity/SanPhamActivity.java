package com.example.android_member.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.android_member.R;
import com.example.android_member.adapter.Adapter_Sanpham;
import com.example.android_member.api.API;
import com.example.android_member.api.RetrofitClient;
import com.example.android_member.model.BaseResponse;
import com.example.android_member.model.SanPham;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SanPhamActivity extends AppCompatActivity {
    String loaiId = "";
    RetrofitClient retrofit = new RetrofitClient();
    List<SanPham> sanPhamList = new ArrayList<>();
     RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanpham);
        Intent i = getIntent();
        if (i != null){
            loaiId = i.getStringExtra("Id");
        }

        recycler = findViewById(R.id.recyclerview_sp);
        recycler.setHasFixedSize(true);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
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
                    loadData();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<SanPham>>> call, Throwable t) {
                Log.d("bbb" , t.getMessage());
            }
        });
    }

    private void loadData() {
        Adapter_Sanpham adapter_sanpham = new Adapter_Sanpham(sanPhamList,SanPhamActivity.this);
        recycler.setAdapter(adapter_sanpham);
        adapter_sanpham.notifyDataSetChanged();
    }
}


