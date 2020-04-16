package com.example.android_member.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_member.R;
import com.example.android_member.api.RetrofitClient;
import com.example.android_member.model.SanPham;
import com.squareup.picasso.Picasso;

public class InforSanPhamActivity extends AppCompatActivity {
    SanPham sanPham;
    Intent intent;
    ImageView img_sanpham;
    TextView txt_loaisanpham, txt_masanpham, txt_tensanpham, txt_giasanpham, txt_motasanpham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_san_pham);
        getControl();
        intent = getIntent();
        sanPham = (SanPham) intent.getSerializableExtra("sanpham");
        if (sanPham != null){
            //sao lai parse Int. vì cái img kiểu Strinf mà setimg thì nó cần kieu3 int, dau phai =))) m dang load anh dang url ma
            //http://loacalhost:3000/imag/abc.png. ê alo còn cái loại sản phẩm á
            //mo thu 1 anh san pham tren web xem là sao, mo web di
            Picasso.with(getApplicationContext()).load(RetrofitClient.ROOT_URL + sanPham.getImageSP()).into(img_sanpham);
           txt_loaisanpham.setText(String.valueOf(sanPham.getTenLoaiSP().getTenLoaiSP()));
           txt_masanpham.setText(sanPham.getMaSP());
           txt_tensanpham.setText(sanPham.getTenSP());
           txt_giasanpham.setText(sanPham.getGiaSP() + "");
           txt_motasanpham.setText(sanPham.getMotaSP());
        }
    }

    private void getControl() {
        img_sanpham = findViewById(R.id.img_sanpham);
        txt_loaisanpham = findViewById(R.id.txt_loaisanpham);
        txt_masanpham = findViewById(R.id.txt_masanpham);
        txt_tensanpham = findViewById(R.id.txt_tensanpham);
        txt_giasanpham = findViewById(R.id.txt_giasanpham);
        txt_motasanpham = findViewById(R.id.txt_motasanpham);
    }
}
