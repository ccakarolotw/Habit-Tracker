package com.example.android.diettracking.data;

import android.provider.BaseColumns;

/**
 * Created by ftf-icn on 4/23/2017.
 */
public final class DietContract {

    private DietContract() {
    }

    public static final class DietEntry implements BaseColumns {
        public static final String TABLE_NAME = "diets";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_MEAL = "meal";
        public static final String COLUMN_DISH = "dish";
        public static final String COLUMN_MEAT = "meatType";
        public static final String COLUMN_WEIGHT = "weight";

        public static final int MEAT_OTHER = 0;
        public static final int MEAT_CHICKEN = 1;
        public static final int MEAT_PORK = 2;
        public static final int MEAT_BEEF = 3;
        public static final int MEAT_FISH = 4;
        public static final int MEAT_LAMB = 5;
        public static final int MEAT_SEAFOOD = 6;

        public static final int MEAL_OTHER = 0;
        public static final int MEAL_BREAKFAST = 1;
        public static final int MEAL_LUNCH = 2;
        public static final int MEAL_DINNER = 3;
    }


}
