package com.example.android_member.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_member.R;

import com.example.android_member.activity.ActivitySanPham;
import com.example.android_member.model.SanPham;
import com.example.android_member.model.TenLoaiSP;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_LoaiSP extends RecyclerView.Adapter<Adapter_LoaiSP.ViewHolder> {
    private List<TenLoaiSP> loaiSanPhamList;
    private Context context;

    public Adapter_LoaiSP(List<TenLoaiSP> loaiSanPhamList, Context context){
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
        final TenLoaiSP loaiSanPham = loaiSanPhamList.get(position);
        try {
            Picasso.with(context)
                    .load("http://192.168.1.5:3000/" + loaiSanPham.getImage())
                    .into(holder.img_store);
        } catch (Exception e){

        }
        holder.txt_store.setText(loaiSanPham.getTenLoaiSP());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivitySanPham.class);
                intent.putExtra("Id",loaiSanPham.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return loaiSanPhamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_store;
        TextView txt_store;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            img_store = itemView.findViewById(R.id.img_store);
            txt_store = itemView.findViewById(R.id.txt_store);
            cardView = itemView.findViewById(R.id.id_cardview);
        }
    }
}
