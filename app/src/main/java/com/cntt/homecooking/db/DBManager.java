package com.cntt.homecooking.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cntt.homecooking.model.Category;
import com.cntt.homecooking.model.Formula;
import com.cntt.homecooking.model.LikedModel;
import com.cntt.homecooking.model.Popular;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class DBManager extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "HomeCooking.db";
    private static final int DATABASE_VERSION = 2;
    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static public SQLiteDatabase getReadableDatabase(Context context) {
        //Init database helper, and database content to communicate with sqlite database
        DBManager mDbHelper = new DBManager(context);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        return db;
    }

    static public SQLiteDatabase getWriteableDatabase(Context context) {
        //Init database helper, and database content to communicate with sqlite database
        DBManager mDbHelper = new DBManager(context);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        return db;
    }

    public void onCreate(SQLiteAssetHelper db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<Category> getAllCategory(){

        ArrayList<Category> categories = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Theloaimon",null);

        //Đến dòng đầu tiên để chắc chắn sổ hết dữ liệu
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int IdTheLoai = cursor.getInt(0);
            String Tentheloai = cursor.getString(1);
//            String images = cursor.getString(2);

            categories.add(new Category(IdTheLoai, Tentheloai,""));
            cursor.moveToNext();
        }
        cursor.close();

        return categories;
    }

    public  ArrayList<Popular> getAllPopular(){

        ArrayList<Popular> populars = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from CongThucNauAn", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int IdCongThuc = cursor.getInt(0);
            String TenCongThuc = cursor.getString(1);
            String ctcb = cursor.getString(2);
            String thanhphan = cursor.getString(6);
            String images = cursor.getString(4);

            populars.add(new Popular(IdCongThuc, TenCongThuc,images,ctcb,thanhphan));
            cursor.moveToNext();
        }
        cursor.close();

        return populars;
    }

    public  ArrayList<com.cntt.homecooking.model.Formula> getAllFormula(){

        ArrayList<Formula> formulas = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from CongThucNauAn", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int IdCongThuc = cursor.getInt(0);
            String TenCongThuc = cursor.getString(1);
            String ctcb = cursor.getString(2);
            String thanhphan = cursor.getString(6);
            String images = cursor.getString(4);

            formulas.add(new Formula(IdCongThuc, TenCongThuc,images,ctcb,thanhphan));
            cursor.moveToNext();
        }
        cursor.close();

        return formulas;
    }

    public  Category getCategoryByID(int IdTheLoai){
        Category categories = null;
        SQLiteDatabase db =getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Theloaimon where IdTheLoai = ?", new String[]{IdTheLoai + ""});

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            int iDTheLoai = cursor.getInt(0);
            String Tentheloai = cursor.getString(1);
//            String images = cursor.getString(2);

            categories = new Category(iDTheLoai, Tentheloai, "");
        }
        cursor.close();
        return categories;
    }


    public boolean insertLiked(String TenCongThuc, String HinhAnh, int IdCongThuc){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("tencongthuc",TenCongThuc);
        contentValues.put("hinhanh",HinhAnh);
        contentValues.put("idcongthuc",IdCongThuc);

        long id = db.insert("Liked",null,contentValues);
        if(id <= 0){
            return false;
        }else {
            return true;
        }
    }

    public ArrayList<LikedModel> getLiked(){
        ArrayList<LikedModel> likedModels = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select IdLiked,TenCongThuc,HinhAnh from Liked",null);

        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){

                LikedModel model = new LikedModel();
                model.setSoLiked(cursor.getInt(0)+"");
                model.setTenCongThuc(cursor.getString(1));
                model.setHinhAnh(cursor.getString(2));
                likedModels.add(model);
            }
        }
        cursor.close();
        db.close();
        return likedModels;
    }

//    public Cursor getLikedById(int id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("Select * from Liked where IdLiked = " + id,null);
//
//        if(cursor != null)
//            cursor.moveToFirst();
//
//        return cursor;
//    }

    public int deleteLiked(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.delete("Liked","IdLiked="+id,null);
    }
}
