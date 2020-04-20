package com.example.android_member.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_member.R;
import com.example.android_member.model.User;

import java.util.List;

public class Adapter_User extends RecyclerView.Adapter<Adapter_User.ViewHolder> {
    private List<User> userList;
    private Context context;

    public Adapter_User(List<User> userList, Context context){
        this.context = context;
        this.userList = userList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_user,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = userList.get(position);
        holder.id_usernmae.setText(user.getUsername());
        holder.id_email.setText(user.getEmail());
        holder.id_phone.setText(String.valueOf(user.getPhone()));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id_usernmae, id_email, id_phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id_usernmae = itemView.findViewById(R.id.id_username);
            id_email = itemView.findViewById(R.id.id_email);
            id_phone = itemView.findViewById(R.id.id_phone);
        }
    }
}
