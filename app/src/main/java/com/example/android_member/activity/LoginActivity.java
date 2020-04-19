package com.example.android_member.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_member.R;
import com.example.android_member.api.API;
import com.example.android_member.api.RetrofitClient;
import com.example.android_member.fragment.Fragment_Store;
import com.example.android_member.model.User;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button btn_login;
    private TextView tv_resgitered;
    EditText txt_email,txt_password;
    RetrofitClient retrofit = new RetrofitClient();
    private API api = retrofit.getClient().create(API.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_login);
        //Ánh xạ
        control();
        //Xử lý sự kiện
        event();
    }

    private void event() {
//        final String email = txt_email.getText().toString();
//        final String password = txt_password.getText().toString();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    HashMap<String, String> map = new HashMap<>();
                    map.put("email",txt_email.getText().toString());
                    map.put("password",txt_password.getText().toString());
                    Call<User> call = api.logiuser(map);
                    call.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                                   if (response.code() == 200){
                                       Toast.makeText(LoginActivity.this, "Login thành Công", Toast.LENGTH_SHORT).show();
                                       Intent i = new Intent(LoginActivity.this, Home_Activity.class);
                                       startActivity(i);
                                   }else if(response.code() == 400){
                                       Toast.makeText(LoginActivity.this, "Err", Toast.LENGTH_SHORT).show();
                                   }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {

                        }
                    });

            }
        });
        tv_resgitered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,Regis_Activity.class);
                startActivity(i);
            }
        });
    }


    private void control() {
        btn_login = findViewById(R.id.btn_login);
        tv_resgitered = findViewById(R.id.tv_resgitered);
        txt_email = findViewById(R.id.txt_email);
        txt_password = findViewById(R.id.txt_password);
    }
}
