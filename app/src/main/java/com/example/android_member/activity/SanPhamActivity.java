package com.example.android_member.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.android_member.R;
import com.example.android_member.adapter.Adapter_Sanpham;
import com.example.android_member.api.API;
import com.example.android_member.api.RetrofitClient;
import com.example.android_member.fragment.Fragment_Store;
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
    Toolbar toolbar;
    Adapter_Sanpham adapter_sanpham;
    EditText edt_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_sanpham);
        toolbar = findViewById(R.id.tool_bar123);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // tìm kiếm sản phẩm
        edt_search = findViewById(R.id.edt_search);
        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
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

    private void filter(String toString) {
        ArrayList<SanPham> filterlist = new ArrayList<>();
        for (SanPham sanPham: sanPhamList){
            if (sanPham.getTenSP().toLowerCase().contains(toString.toLowerCase())){
                filterlist.add(sanPham);
            }
        }
        adapter_sanpham.getFilter(filterlist);
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
         adapter_sanpham = new Adapter_Sanpham(sanPhamList,SanPhamActivity.this);
        recycler.setAdapter(adapter_sanpham);
        adapter_sanpham.notifyDataSetChanged();
    }

}


