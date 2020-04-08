package com.example.android_member.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_member.R;
import com.example.android_member.model.LoaiSanPham;

import java.util.List;

public class Adapter_LoaiSP extends RecyclerView.Adapter<Adapter_LoaiSP.ViewHolder> {
    private List<LoaiSanPham> loaiSanPhamList;
    private Context context;

    public Adapter_LoaiSP(List<LoaiSanPham> loaiSanPhamList,Context context){
        this.context = context;
        this.loaiSanPhamList = loaiSanPhamList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_store,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LoaiSanPham loaiSanPham = loaiSanPhamList.get(position);
        holder.txt_store.setText(loaiSanPham.getTenLoaiSP());
        holder.img_store.setImageResource(loaiSanPham.getImgLoaiSP());
    }

    @Override
    public int getItemCount() {
        return loaiSanPhamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_store;
        TextView txt_store;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            img_store = itemView.findViewById(R.id.img_store);
            txt_store = itemView.findViewById(R.id.txt_store);
        }
    }
}
