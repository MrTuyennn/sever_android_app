package com.example.android_member.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_member.R;
import com.example.android_member.activity.SanPhamActivity;
import com.example.android_member.adapter.Adapter_GioHang;
import com.example.android_member.adapter.Adapter_Sanpham;
import com.example.android_member.db.GioHangDAO;
import com.example.android_member.model.GioHang;
import com.example.android_member.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Cart extends Fragment {
    Adapter_GioHang adapter_gioHang;
    List<GioHang> gioHangList = new ArrayList<>();
    RecyclerView recyclerView_giohang;
    GioHangDAO gioHangDAO;
    TextView edt_search_giohang;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart,container,false);
        recyclerView_giohang = view.findViewById(R.id.recyclerView_giohang);
        recyclerView_giohang.setHasFixedSize(true);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        gioHangDAO = new GioHangDAO(getContext());
        gioHangList = gioHangDAO.getAll();
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_giohang.setLayoutManager(linearLayoutManager);
        recyclerView_giohang.setItemAnimator(new DefaultItemAnimator());
        adapter_gioHang = new Adapter_GioHang(gioHangList,getContext());
        recyclerView_giohang.setAdapter(adapter_gioHang);
        adapter_gioHang.notifyDataSetChanged();
        edt_search_giohang = view.findViewById(R.id.edt_search_giohang);

        // search tìm kiếm sản phẩm trong giỏ hàng
        edt_search_giohang.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                    text_search(s.toString());
            }

            private void text_search(String toString) {
                ArrayList<GioHang> filterlist = new ArrayList<>();
                for (GioHang gioHang: gioHangList){
                    if (gioHang.getTensanpham().toLowerCase().contains(toString.toLowerCase())){
                        filterlist.add(gioHang);
                    }
                }
                adapter_gioHang.getFilter_giohang(filterlist);
            }
        });
        return view;
    }
}
