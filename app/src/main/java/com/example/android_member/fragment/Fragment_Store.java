package com.example.android_member.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_member.Home_Activity;
import com.example.android_member.R;
import com.example.android_member.adapter.Adapter_LoaiSP;
import com.example.android_member.model.LoaiSanPham;

import java.util.ArrayList;

public class Fragment_Store extends Fragment {
    Toolbar toolbar;
    Adapter_LoaiSP adapter_loaiSP;
    ArrayList<LoaiSanPham> loaiSanPhamArrayList;
    RecyclerView recyclerView;
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
        loaiSanPhamArrayList = new ArrayList<>();
        loaiSanPhamArrayList.add(new LoaiSanPham(1,"converse","Converse",R.drawable.converse));
        loaiSanPhamArrayList.add(new LoaiSanPham(2,"nike","nike",R.drawable.nike));
        loaiSanPhamArrayList.add(new LoaiSanPham(3,"adidas","adidas",R.drawable.adidas));
        loaiSanPhamArrayList.add(new LoaiSanPham(4,"balenciaga","balenciaga",R.drawable.balenciaga));
        loaiSanPhamArrayList.add(new LoaiSanPham(5,"gucci","gucci",R.drawable.gucci));
        loaiSanPhamArrayList.add(new LoaiSanPham(6,"mcqueen","mcqueen",R.drawable.mcquenn));
        loaiSanPhamArrayList.add(new LoaiSanPham(7,"vans","vans",R.drawable.vans));
        loaiSanPhamArrayList.add(new LoaiSanPham(8,"fila","fila",R.drawable.fila));
        loaiSanPhamArrayList.add(new LoaiSanPham(9,"mlb","mbl",R.drawable.mlb));
        adapter_loaiSP = new Adapter_LoaiSP(loaiSanPhamArrayList,getContext());
        recyclerView.setAdapter(adapter_loaiSP);
//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                int id = item.getItemId();
//                switch (id) {
//                    case R.id.search:
//                        Toast.makeText(getContext(), "oke", Toast.LENGTH_SHORT).show();
//                        return true;
//                }
//                return false;
//            }
//        });

        return view;
    }
}
