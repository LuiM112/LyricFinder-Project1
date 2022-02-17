package com.daclink.drew.sp22.cst438_project01_starter.AppStorage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import SearchTask.Search;

@Database(entities = {Search.class}, version =2)
public abstract class SearchDatabase extends RoomDatabase {
    public static final String DB_Name = "SEARCH_DATABASE";
    public static final String SEARCH_TABLE = "SEARCH_TABLE";
    public static final String  STORE_DB = "STORE_DATABASE";
}
