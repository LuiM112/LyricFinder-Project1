package com.daclink.drew.sp22.cst438_project01_starter.AppStorage;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.daclink.drew.sp22.cst438_project01_starter.User;
@Database(entities = {User.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "USER_DATABASE";
    public static final String USER_TABLE = "USER_TABLE";
    public static final String STORE_DB = "STORE_DATABASE";

    public abstract UserDAO getUserDAO();
}