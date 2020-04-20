package com.example.android_member.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_member.R;
import com.example.android_member.activity.LoginActivity;
import com.example.android_member.activity.SanPhamActivity;
import com.example.android_member.adapter.Adapter_Sanpham;
import com.example.android_member.adapter.Adapter_User;
import com.example.android_member.api.API;
import com.example.android_member.api.RetrofitClient;
import com.example.android_member.model.BaseResponse;
import com.example.android_member.model.SanPham;
import com.example.android_member.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Account extends Fragment {
    RecyclerView recyclerView_user;
    RetrofitClient retrofit = new RetrofitClient();
    Adapter_User adapter_user;
    List<User> userList = new ArrayList<>();
    TextView username , email,phone;
    Button btn_logout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account,container,false);
//        recyclerView_user = view.findViewById(R.id.recyclerView_user);
//        recyclerView_user.setHasFixedSize(true);
//        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView_user.setLayoutManager(linearLayoutManager);
//        recyclerView_user.setItemAnimator(new DefaultItemAnimator());
//        GetData();
        username = view.findViewById(R.id.username);
        email = view.findViewById(R.id.email);
        phone = view.findViewById(R.id.phone);
        btn_logout = view.findViewById(R.id.btn_logout);
        String myname = getArguments().getString("myuser");
        String myemail = getArguments().getString("myemail");
        int myphone = getArguments().getInt("phone");
        username.setText(myname);
        email.setText(myemail);
        phone.setText(myphone+"");
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), LoginActivity.class);
                startActivity(i);
            }
        });
        return view;
    }

//    private void GetData() {
//        API api = retrofit.getClient().create(API.class);
//        api.getUser().enqueue(new Callback<BaseResponse<List<User>>>() {
//            @Override
//            public void onResponse(Call<BaseResponse<List<User>>> call, Response<BaseResponse<List<User>>> response) {
//                Log.d("vvv" , response.code() + " " );
//                if (response.isSuccessful()){
//                    userList = response.body().getData();
//                    Log.d("alo",userList.get(0).getEmail());
//                    loadData();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BaseResponse<List<User>>> call, Throwable t) {
//                Log.d("bbb" , t.getMessage());
//            }
//        });
//    }
//
//    private void loadData() {
//        adapter_user = new Adapter_User(userList, getContext());
//        recyclerView_user.setAdapter(adapter_user);
//        adapter_user.notifyDataSetChanged();
//    }
}
