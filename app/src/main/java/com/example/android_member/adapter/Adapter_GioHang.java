package com.example.android_member.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_member.R;
import com.example.android_member.db.GioHangDAO;
import com.example.android_member.model.GioHang;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_GioHang extends RecyclerView.Adapter<Adapter_GioHang.ViewHolder> {

    private List<GioHang> gioHangList;
    private Context context;
    private GioHangDAO gioHangDAO;

    public Adapter_GioHang(List<GioHang> gioHangList,Context context){
        this.context = context;
        this.gioHangList = gioHangList;
        gioHangDAO = new GioHangDAO(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_giohang,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final GioHang gioHang = gioHangList.get(position);
        holder.tensanpham_giohang.setText(gioHang.getTensanpham());
        holder.ngaymua.setText(gioHang.getNgayMua());
        holder.trangthai.setText(gioHang.getTrangthai());
        holder.giasanpham_giohang.setText(gioHang.getGiasanpham() + "");
        try {
            Picasso.with(context)
                    .load("http://192.168.1.5:3000/" + gioHang.getImage())
                    .into(holder.img_giohang);
        } catch (Exception e){

        }
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Xóa thành công",Toast.LENGTH_LONG).show();
                GioHang gioHang1 = gioHangList.get(position);
                gioHangDAO.delete(gioHang1);
                gioHangList.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return gioHangList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tensanpham_giohang,ngaymua,giasanpham_giohang,trangthai;
        ImageView img_giohang;
        Button btn_delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tensanpham_giohang = itemView.findViewById(R.id.tensanpham_giohang);
            ngaymua = itemView.findViewById(R.id.ngaymua);
            giasanpham_giohang = itemView.findViewById(R.id.giasanpham_giohang);
            trangthai = itemView.findViewById(R.id.trangthai);
            img_giohang = itemView.findViewById(R.id.img_giohang);
            btn_delete = itemView.findViewById(R.id.btn_delete);
        }
    }
}
