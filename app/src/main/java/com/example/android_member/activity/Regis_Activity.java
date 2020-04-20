package com.example.android_member.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_member.R;
import com.example.android_member.api.API;
import com.example.android_member.api.RetrofitClient;
import com.example.android_member.model.User;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Regis_Activity extends AppCompatActivity {
    EditText edt_username,edt_email,edt_phone,edt_password;
    Button btn_signup;
    RetrofitClient retrofit = new RetrofitClient();
    private API api = retrofit.getClient().create(API.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_regis);
        Control();
        Event();


    }

    private void Event() {
//        final String username = edt_username.getText().toString();
//        final String email = edt_email.getText().toString();
//        final String phone = edt_phone.getText().toString();
//        final String password = edt_password.getText().toString();

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_username.getText().toString().isEmpty() ||
                        edt_email.getText().toString().isEmpty() ||
                        edt_phone.getText().toString().isEmpty() ||
                        edt_password.getText().toString().isEmpty()
                ){
                    Toast.makeText(Regis_Activity.this, "Vui Lòng Nhập Đầy Đủ Thông Tin", Toast.LENGTH_SHORT).show();
                }else {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("username",edt_username.getText().toString());
                    map.put("email",edt_email.getText().toString());
                    map.put("phone",edt_phone.getText().toString());
                    map.put("password",edt_password.getText().toString());
                    Call<Void> call = api.signupUser(map);
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            if (response.code() == 200){
                                Toast.makeText(Regis_Activity.this, "Đăng Kí Thành Công", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Regis_Activity.this, LoginActivity.class);
                                startActivity(i);
                            }else if(response.code() == 400){
                                Toast.makeText(Regis_Activity.this, "Err" + response.message(), Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {

                        }
                    });
                }
                }
        });

    }

    private void Control() {
         edt_username =  findViewById(R.id.edt_username);
         edt_email =  findViewById(R.id.edt_email);
         edt_phone =  findViewById(R.id.edt_phone);
         edt_password = findViewById(R.id.edt_password);
         btn_signup = findViewById(R.id.btn_signup);
    }
}
