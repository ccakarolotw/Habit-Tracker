package com.example.android.diettracking.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.diettracking.data.DietContract.DietEntry;

/**
 * Created by ftf-icn on 4/23/2017.
 */
public class DietDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "meal.db";

    public DietDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE " + DietEntry.TABLE_NAME + "("
                + DietEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + DietEntry.COLUMN_DATE + " INTEGER," + DietEntry.COLUMN_MEAL + " INTEGER," +
                DietEntry.COLUMN_DISH + " TEXT," + DietEntry.COLUMN_MEAT + " INTEGER," + DietEntry.COLUMN_WEIGHT + " INTEGER)";
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }
}
