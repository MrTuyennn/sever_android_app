package com.example.android_member.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android_member.model.GioHang;

import java.util.ArrayList;
import java.util.List;

public class GioHangDAO {
    DataHelper helper;
    public static final String TABLE_NAME = "GioHang";
    public static final String TAG = "GiohangDAO";
    public static final String SQL_CART = "CREATE TABLE GioHang(ID integer primary key autoincrement" +
            ",Image text , Tensanpham text,Giasanpham integer, NgayMua text,Trangthai text)";
    public GioHangDAO(Context context){
        helper = new DataHelper(context);
    }

    public boolean insert(GioHang gioHang) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Image", gioHang.getImage());
        values.put("Tensanpham", gioHang.getTensanpham());
        values.put("Giasanpham", gioHang.getGiasanpham());
        values.put("NgayMua", gioHang.getNgayMua());
        values.put("Trangthai", gioHang.getTrangthai());
        long row = db.insert(TABLE_NAME, null, values);
        if (row > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<GioHang> getAll() {
        List<GioHang> listnd = new ArrayList<>();
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Cursor c = db.rawQuery(sql, null);

        if (c.moveToFirst()) {
            do {
                int id = c.getInt(0);
                String image = c.getString(1);
                String tensanpham = c.getString(2);
                int giasanpham = c.getInt(3);
                String ngaymua = c.getString(4);
                String trangthai = c.getString(5);
                GioHang gioHang = new GioHang(id,image, tensanpham, giasanpham, ngaymua,trangthai);
                listnd.add(gioHang);
            }while (c.moveToNext());
            c.close();
        }
        return listnd;
    }

    public int delete(GioHang gioHang){
        SQLiteDatabase db = helper.getWritableDatabase();
        int id = gioHang.getID();
        int result = db.delete(TABLE_NAME,"ID = ?",new String[]{String.valueOf(id)});
        if (result == 0)
            return -1;
        return 1;
    }
}
