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
import com.example.android_member.activity.InforSanPhamActivity;
import com.example.android_member.fragment.Fragment_Store;
import com.example.android_member.model.SanPham;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter_AllSanpham extends RecyclerView.Adapter<Adapter_AllSanpham.ViewHolder> {
    private List<SanPham> sanPhamList;
    private Context context;
    public Adapter_AllSanpham(List<SanPham> sanPhamList, Context context){
        this.sanPhamList = sanPhamList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_allsanpham,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final SanPham sanPham = sanPhamList.get(position);
        try {
            Picasso.with(context)
                    .load("http://192.168.1.5:3000/" + sanPham.getImageSP())
                    .into(holder.img_allsp);
        } catch (Exception e){

        }
        holder.txt_tensp.setText(sanPham.getTenSP());
        holder.txt_giasap.setText(String.valueOf(sanPham.getGiaSP()) + "");
        holder.txt_tenloaisp.setText(sanPham.getTenLoaiSP().getTenLoaiSP());
        holder.cardView_allsanpham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InforSanPhamActivity.class);
                intent.putExtra("sanpham",sanPham);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return sanPhamList.size();
    }
    public void  getFilterSp(ArrayList<SanPham> filterlist) {
        sanPhamList = filterlist;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_allsp;
        TextView txt_tensp,txt_giasap,txt_tenloaisp;
        CardView cardView_allsanpham;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_allsp = itemView.findViewById(R.id.img_allsp);
            txt_tensp = itemView.findViewById(R.id.txt_tenallsp);
            txt_giasap = itemView.findViewById(R.id.txt_giaallsp);
            txt_tenloaisp = itemView.findViewById(R.id.txt_tenloaisp);
            cardView_allsanpham = itemView.findViewById(R.id.cardview_allsanpham);
        }
    }
}
