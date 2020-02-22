package com.navin.digishop.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Basket.class}, version = 1)
public abstract class BasketDatabase extends RoomDatabase {
    private static BasketDatabase instance;

    public final static String DB_NAME = "DigiDb";


    public static synchronized BasketDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context, BasketDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }

        return instance;

    }


    public abstract BasketDao Dao();


}
