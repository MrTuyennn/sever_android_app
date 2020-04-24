package com.example.android_member.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_member.R;
import com.example.android_member.activity.SanPhamActivity;
import com.example.android_member.adapter.Adapter_AllSanpham;
import com.example.android_member.adapter.Adapter_LoaiSP;
import com.example.android_member.adapter.Adapter_Sanpham;
import com.example.android_member.api.API;
import com.example.android_member.api.RetrofitClient;
import com.example.android_member.model.BaseResponse;

import com.example.android_member.model.SanPham;
import com.example.android_member.model.TenLoaiSP;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Store extends Fragment {

    public static List<TenLoaiSP> loaiSanPhamArrayList =new ArrayList<>();
     List<SanPham> sanPhamList = new ArrayList<>();
    RecyclerView recyclerView , recyclerView_allsp;
    RetrofitClient retrofit = new RetrofitClient();
    API api = retrofit.getClient().create(API.class);
    EditText edt_searchsp;
    Adapter_AllSanpham adapter_sanpham;
    Spinner spinner;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store,container,false);

        // Lấy dữ liệu của loại sản phẩm
        recyclerView = view.findViewById(R.id.recyclerview_store);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);
        getDataLoaisanpham();

        // Lấy dữ liệu của sản phẩm
        recyclerView_allsp = view.findViewById(R.id.recyclerView_allsp);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView_allsp.setItemAnimator(new DefaultItemAnimator());
        recyclerView_allsp.setLayoutManager(gridLayoutManager);


        // search sản phẩm
        edt_searchsp = view.findViewById(R.id.edt_searchsp);
        edt_searchsp.addTextChangedListener(new TextWatcher() {
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

        // Spiner
        spinner = view.findViewById(R.id.id_spiner);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Tất cả sản phẩm");
        arrayList.add("Sản phẩm trên 5.000.000");
        arrayList.add("Sản phẩm dưới 5.000.000");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    // Lấy Toàn bộ sản phẩm (API)
                    api.getAll().enqueue(new Callback<BaseResponse<List<SanPham>>>() {
                        @Override
                        public void onResponse(Call<BaseResponse<List<SanPham>>> call, Response<BaseResponse<List<SanPham>>> response) {
                            sanPhamList = response.body().getData();
                            loadAlldata();
                        }

                        @Override
                        public void onFailure(Call<BaseResponse<List<SanPham>>> call, Throwable t) {

                        }
                    });
                }else if(position == 1){
                    // lấy Sản Phẩm theo giá trên 5.000.000
                    api.Getpricegte().enqueue(new Callback<BaseResponse<List<SanPham>>>() {
                        @Override
                        public void onResponse(Call<BaseResponse<List<SanPham>>> call, Response<BaseResponse<List<SanPham>>> response) {
                            sanPhamList = response.body().getData();
                            loadAlldata();
                        }

                        @Override
                        public void onFailure(Call<BaseResponse<List<SanPham>>> call, Throwable t) {

                        }
                    });
                }else if (position == 2){
                    // lấy sản phẩm theo giá dưới 5.000.000
                    api.Getpricelte().enqueue(new Callback<BaseResponse<List<SanPham>>>() {
                        @Override
                        public void onResponse(Call<BaseResponse<List<SanPham>>> call, Response<BaseResponse<List<SanPham>>> response) {
                            sanPhamList = response.body().getData();
                            loadAlldata();
                        }

                        @Override
                        public void onFailure(Call<BaseResponse<List<SanPham>>> call, Throwable t) {

                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
        return view;
    }
    private void filter(String toString) {
        ArrayList<SanPham> filterlist = new ArrayList<>();
        for (SanPham sanPham: sanPhamList){
            if (sanPham.getTenSP().toLowerCase().contains(toString.toLowerCase())){
                filterlist.add(sanPham);
            }
        }
        adapter_sanpham.getFilterSp(filterlist);
    }


    // Lấy toàn bộ laoi5 sản phẩm (API)
    private void getDataLoaisanpham() {
        api.getAllloaisanpham().enqueue(new Callback<BaseResponse<List<TenLoaiSP>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<TenLoaiSP>>> call, Response<BaseResponse<List<TenLoaiSP>>> response) {
                //thanh cong// 200 -> 300
                if(response.isSuccessful()){
                   loaiSanPhamArrayList = response.body().getData();
                   loadData();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<TenLoaiSP>>> call, Throwable t) {
                Log.d("err" , t.getMessage());
            }
        });
    }

    private void loadAlldata() {
          adapter_sanpham = new Adapter_AllSanpham(sanPhamList,getContext());
         recyclerView_allsp.setAdapter(adapter_sanpham);
         adapter_sanpham.notifyDataSetChanged();
    }

    private void loadData(){
        Adapter_LoaiSP adapter_loaiSP = new Adapter_LoaiSP(loaiSanPhamArrayList,getContext());
        recyclerView.setAdapter(adapter_loaiSP);
        adapter_loaiSP.notifyDataSetChanged();
    }
}
