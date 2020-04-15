package com.example.android_member.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_member.R;
import com.example.android_member.adapter.Adapter_LoaiSP;
import com.example.android_member.api.API;
import com.example.android_member.api.RetrofitClient;
import com.example.android_member.model.BaseResponse;

import com.example.android_member.model.TenLoaiSP;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Store extends Fragment {
    Toolbar toolbar;
    Adapter_LoaiSP adapter_loaiSP;
    public static List<TenLoaiSP> loaiSanPhamArrayList =new ArrayList<>();
    RecyclerView recyclerView;
    RetrofitClient retrofit = new RetrofitClient();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store,container,false);
        toolbar = view.findViewById(R.id.tool_bar123);
        setHasOptionsMenu(true);
        toolbar.inflateMenu(R.menu.menu_store);
        recyclerView = view.findViewById(R.id.recyclerview_store);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(gridLayoutManager);
        getData();
//        loaiSanPhamArrayList = new ArrayList<>();
//        loaiSanPhamArrayList.add(new LoaiSanPham(1,"Converse",R.drawable.converse));
//        loaiSanPhamArrayList.add(new LoaiSanPham(2,"nike",R.drawable.nike));
//        loaiSanPhamArrayList.add(new LoaiSanPham(3,"adidas",R.drawable.adidas));
//        loaiSanPhamArrayList.add(new LoaiSanPham(4,"balenciaga",R.drawable.balenciaga));
//        loaiSanPhamArrayList.add(new LoaiSanPham(5,"gucci",R.drawable.gucci));
//        loaiSanPhamArrayList.add(new LoaiSanPham(6,"mcqueen",R.drawable.mcquenn));
//        loaiSanPhamArrayList.add(new LoaiSanPham(7,"vans",R.drawable.vans));
//        loaiSanPhamArrayList.add(new LoaiSanPham(8,"fila",R.drawable.fila));
//        loaiSanPhamArrayList.add(new LoaiSanPham(9,"mbl",R.drawable.mlb));
//        adapter_loaiSP = new Adapter_LoaiSP(loaiSanPhamArrayList,getContext());
//        recyclerView.setAdapter(adapter_loaiSP);


        return view;
    }

    private void getData() {
        API api = retrofit.getClient().create(API.class);
        api.getAllloaisanpham().enqueue(new Callback<BaseResponse<List<TenLoaiSP>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<TenLoaiSP>>> call, Response<BaseResponse<List<TenLoaiSP>>> response) {
                //thanh cong// 200 -> 300
                if(response.isSuccessful()){
                    Log.d("fdfds", response.code() + "");
                   loaiSanPhamArrayList = response.body().getData();
                   loadData();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<TenLoaiSP>>> call, Throwable t) {
                Log.d("sfsd" , t.getMessage());
            }
        });
    }
    private void loadData(){
        Adapter_LoaiSP adapter_loaiSP = new Adapter_LoaiSP(loaiSanPhamArrayList,getContext());
        recyclerView.setAdapter(adapter_loaiSP);
        adapter_loaiSP.notifyDataSetChanged();
    }
}
