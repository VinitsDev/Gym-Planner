package com.example.gymplanner.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "GymPlanner.db";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE user (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "email TEXT UNIQUE," +
                "password TEXT)");

        db.execSQL("CREATE TABLE split (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "user_id INTEGER," +
                "name TEXT," +
                "description TEXT," +
                "FOREIGN KEY(user_id) REFERENCES user(id))");

        db.execSQL("CREATE TABLE split_exercise (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "split_id INTEGER," +
                "name TEXT," +
                "series INTEGER," +
                "repetitions INTEGER," +
                "FOREIGN KEY(split_id) REFERENCES split(id))");

        db.execSQL("CREATE TABLE training (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "user_id INTEGER," +
                "split_id INTEGER," +
                "date TEXT," +
                "duration INTEGER," +
                "FOREIGN KEY(user_id) REFERENCES user(id)," +
                "FOREIGN KEY(split_id) REFERENCES split(id))");

        db.execSQL("CREATE TABLE training_exercise (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "training_id INTEGER," +
                "name TEXT," +
                "series INTEGER," +
                "repetitions INTEGER," +
                "weight REAL," +
                "FOREIGN KEY(training_id) REFERENCES training(id))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS split");
        db.execSQL("DROP TABLE IF EXISTS split_exercise");
        db.execSQL("DROP TABLE IF EXISTS training");
        db.execSQL("DROP TABLE IF EXISTS training_exercise");
        onCreate(db);

    }
}
