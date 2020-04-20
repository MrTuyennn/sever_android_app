package com.example.android_member.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.example.android_member.R;
import com.example.android_member.fragment.Fragment_Account;
import com.example.android_member.fragment.Fragment_Cart;
import com.example.android_member.fragment.Fragment_Store;
import com.example.android_member.model.SanPham;
import com.example.android_member.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home_Activity extends AppCompatActivity {
    BottomNavigationView bottom_nav;
    Intent intent;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_home_);
        intent = getIntent();
        user = (User) intent.getSerializableExtra("user");
        final String username = user.getUsername();
        final String email = user.getEmail();
        final int phone = user.getPhone();
        Log.d("alo alo tuyên",username + email + phone);
        bottom_nav = findViewById(R.id.botom_nav);

        // Cho Màn Hình mặc định khi vào app là store
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                    new Fragment_Store()).commit();
            bottom_nav.setSelectedItemId(R.id.store);
        }
//        bottom_nav.setItemIconTintList(null);

        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.store:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                                new Fragment_Store()).commit();
                        return true;
                    case R.id.cart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                                new Fragment_Cart()).commit();
                        return true;
                    case R.id.account:
                        Fragment fragment_account = new Fragment_Account();
                        Bundle bundle = new Bundle();
                        bundle.putString("myuser",username);
                        bundle.putString("myemail",email);
                        bundle.putInt("phone",phone);
                        fragment_account.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                                fragment_account).commit();


                        return true;
                }
                return false;
            }
        });
    }
}
