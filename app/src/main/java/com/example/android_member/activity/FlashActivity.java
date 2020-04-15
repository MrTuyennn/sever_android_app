package com.example.android_member.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_member.R;

public class FlashActivity extends AppCompatActivity {
    TextView tv_flash;
    ImageView img_flash;
    Animation anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_flash);
        tv_flash = findViewById(R.id.tv_flash);
        img_flash = findViewById(R.id.img_flash);
        anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_fade_in);
        tv_flash.startAnimation(anim);
        img_flash.startAnimation(anim);
        Thread bamgio=new Thread(){
            public void run()
            {
                try {
                    sleep(5000);
                } catch (Exception e) {

                }
                finally
                {
                    Intent itent = new Intent(FlashActivity.this,LoginActivity.class);
                    startActivity(itent);
                }
            }
        };
        bamgio.start();
    }
    //sau khi chuyển sang màn hình chính, kết thúc màn hình chào
    protected void onPause(){
        super.onPause();
        finish();
    }


    }

