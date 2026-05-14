package com.example.gymplanner.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gymplanner.model.User;

public class UserDAO {

    private SQLiteDatabase db;

    public UserDAO(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
    }

    //criar o usuário
    public boolean insert(User user){
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());

        long result = db.insert("user", null, values);
        return result != -1;
    }

    //fazer o login
    public User login(String email, String password) {
        Cursor cursor = db.rawQuery(
                "SELECT * FROM user WHERE email=? AND password=?",
                new String[]{email, password}
        );

        if (cursor.moveToFirst()) {
            User user = new User();
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setEmail(cursor.getString(2));
            user.setPassword(cursor.getString(3));

            cursor.close();
            return user;
        }

        cursor.close();
        return null;
    }

    //conferir o Email
    public boolean checkEmail(String email) {
        Cursor cursor = db.rawQuery(
                "SELECT id FROM user WHERE email=?",
                new String[]{email}
        );

        boolean existe = cursor.moveToFirst();
        cursor.close();
        return existe;
    }




}
