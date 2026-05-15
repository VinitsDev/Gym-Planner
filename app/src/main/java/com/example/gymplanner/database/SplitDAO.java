package com.example.gymplanner.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gymplanner.model.Split;

import java.util.ArrayList;
import java.util.List;

public class SplitDAO {

    private SQLiteDatabase db;

    public SplitDAO(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
    }

    //criar o split
    public boolean insert(Split split){

        ContentValues values = new ContentValues();
        values.put("user_id", split.getUserId());
        values.put("name", split.getName());
        values.put("description", split.getDescricption());

        long result = db.insert("split", null, values);
        return result != -1;
    }

    //listar os splits
    public List<Split> listSplit(int userId) {

        List<Split> list = new ArrayList<>();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM split WHERE user_id=?",
                new String[]{String.valueOf(userId)}
        );

        if (cursor.moveToFirst()) {
            do {
                Split split = new Split();

                split.setId(cursor.getInt(0));
                split.setUserId(cursor.getInt(1));
                split.setName(cursor.getString(2));
                split.setDescricption(cursor.getString(3));

                list.add(split);

            } while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }









}
