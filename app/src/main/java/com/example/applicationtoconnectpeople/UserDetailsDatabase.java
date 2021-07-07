package com.example.applicationtoconnectpeople;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserDetails.class}, version = 1)
public abstract class UserDetailsDatabase extends RoomDatabase {
    private static final String dbName = "userDetails";
    private static UserDetailsDatabase userDetailsDatabase;

    public static synchronized UserDetailsDatabase getUserDetailsDatabase(Context context){
        if(userDetailsDatabase == null){
            userDetailsDatabase = Room.databaseBuilder(context,UserDetailsDatabase.class,dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return userDetailsDatabase;
    }
    public abstract UserDetailsDao userDetailsDao();
}
