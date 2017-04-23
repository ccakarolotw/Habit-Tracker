package com.example.android.diettracking;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.diettracking.data.DietContract.DietEntry;
import com.example.android.diettracking.data.DietDbHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void insertMeal() {
        DietDbHelper mDbHelper = new DietDbHelper(this);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        int date = 0;
        int meal = 0;
        String dish = "roasted chicken";
        int meat = 1;
        int weight = 100;

        ContentValues values = new ContentValues();
        values.put(DietEntry.COLUMN_DATE, date);
        values.put(DietEntry.COLUMN_MEAL, meal);
        values.put(DietEntry.COLUMN_DISH, dish);
        values.put(DietEntry.COLUMN_MEAT, meat);
        values.put(DietEntry.COLUMN_WEIGHT, weight);

        db.insert(DietEntry.TABLE_NAME, null, values);
    }

    private void read() {
        DietDbHelper mDbHelper = new DietDbHelper(this);

        TextView displayView = null;

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {DietEntry._ID, DietEntry.COLUMN_DATE, DietEntry.COLUMN_MEAL,
                DietEntry.COLUMN_DISH, DietEntry.COLUMN_MEAT, DietEntry.COLUMN_WEIGHT};

        Cursor cursor = db.query(DietEntry.TABLE_NAME, projection, null, null, null, null, null);

        displayView.setText("Number of logged meals: " + cursor.getCount() + ".\n\n");
        displayView.append(DietEntry._ID + " - " +
                DietEntry.COLUMN_DATE + " - " +
                DietEntry.COLUMN_MEAL + " - " +
                DietEntry.COLUMN_DISH + " - " +
                DietEntry.COLUMN_MEAT + " - " +
                DietEntry.COLUMN_WEIGHT + "\n");

        int idColumnIndex = cursor.getColumnIndex(DietEntry._ID);
        int dateColumnIndex = cursor.getColumnIndex(DietEntry.COLUMN_DATE);
        int mealColumnIndex = cursor.getColumnIndex(DietEntry.COLUMN_MEAL);
        int dishColumnIndex = cursor.getColumnIndex(DietEntry.COLUMN_DISH);
        int meatColumnIndex = cursor.getColumnIndex(DietEntry.COLUMN_MEAT);
        int weightColumnIndex = cursor.getColumnIndex(DietEntry.COLUMN_WEIGHT);

        while (cursor.moveToNext()) {
            int currentID = cursor.getInt(idColumnIndex);
            int currentDate = cursor.getInt(dateColumnIndex);
            int currentMeal = cursor.getInt(mealColumnIndex);
            String currentDish = cursor.getString(dishColumnIndex);
            int currentMeat = cursor.getInt(meatColumnIndex);
            int currentWeight = cursor.getInt(weightColumnIndex);

            displayView.append(("\n" + currentID + " - " +
                    currentDate + " - " +
                    currentMeal + " - " +
                    currentDish + " - " +
                    currentMeat + " - " +
                    currentWeight));
        }
    }
}
