package com.cntt.homecooking.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBManagerDAO {
    private SQLiteDatabase db;

    public DBManagerDAO(Context context, boolean writeable) {
        if (writeable) {
            db = DBManager.getWriteableDatabase(context);
        } else {
            db = DBManager.getReadableDatabase(context);
        }
    }
}
