package com.example.android_member.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_member.R;
import com.example.android_member.api.RetrofitClient;
import com.example.android_member.db.GioHangDAO;
import com.example.android_member.model.GioHang;
import com.example.android_member.model.SanPham;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InforSanPhamActivity extends AppCompatActivity {
    Toolbar toolbar;
    SanPham sanPham;
    Intent intent;
    Date currentTime = Calendar.getInstance().getTime();
    ImageView img_sanpham;
    TextView txt_loaisanpham, txt_tensanpham, txt_giasanpham, txt_motasanpham;
    Button btn_addcard;
//    GioHangDAO gioHangDAO;
//    SimpleDateFormat dataformat = new SimpleDateFormat("dd-MM-yyyy");
//    String stringcurrenttime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_infor_san_pham);
        getControl();
        toolbar = findViewById(R.id.tool_bar_sp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        intent = getIntent();
        sanPham = (SanPham) intent.getSerializableExtra("sanpham");
        if (sanPham != null){
            Picasso.with(getApplicationContext()).load(RetrofitClient.ROOT_URL + sanPham.getImageSP()).into(img_sanpham);
           txt_loaisanpham.setText(String.valueOf(sanPham.getTenLoaiSP().getTenLoaiSP()));
           txt_tensanpham.setText(sanPham.getTenSP());
           txt_giasanpham.setText(sanPham.getGiaSP() + "");
           txt_motasanpham.setText(sanPham.getMotaSP());
        }

        btn_addcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InforSanPhamActivity.this, "Ok", Toast.LENGTH_SHORT).show();
            }
        });



        // thêm giỏ hàng
//        btn_addcard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String imageSP = sanPham.getImageSP();
//                String tensanpham = sanPham.getTenSP();
//                int giasanpham = sanPham.getGiaSP();
//                GioHang cart = new GioHang(imageSP, tensanpham,giasanpham, stringcurrenttime,  "Waiting");
//                if (gioHangDAO.insert(cart) == true) {
//                    Toast.makeText(getApplicationContext(), "Thêm Thành Công", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(getApplicationContext(), "Thêm Thất Bại" + imageSP, Toast.LENGTH_LONG).show();
//                }
//            }
//        });
    }

    private void getControl() {
        img_sanpham = findViewById(R.id.img_sanpham);
        txt_loaisanpham = findViewById(R.id.txt_loaisanpham);
        txt_tensanpham = findViewById(R.id.txt_tensanpham);
        txt_giasanpham = findViewById(R.id.txt_giasanpham);
        txt_motasanpham = findViewById(R.id.txt_motasanpham);
        btn_addcard = findViewById(R.id.btn_addcart);
//        gioHangDAO = new GioHangDAO(getApplicationContext());
//        stringcurrenttime = dataformat.format(currentTime);
    }
}
