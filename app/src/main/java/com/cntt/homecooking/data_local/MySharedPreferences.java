package com.cntt.homecooking.data_local;

import android.content.Context;
import android.content.SharedPreferences;

import com.cntt.homecooking.R;

import java.util.HashSet;
import java.util.Set;

public class MySharedPreferences {

    private static final String MY_SHARED_PREFERENCES = "MY_SHARED_PREFERENCES";
    private Context mcontext;
    private SharedPreferences sharedPreferences;

    public MySharedPreferences(Context mcontext) {
        this.mcontext = mcontext;
        sharedPreferences = mcontext.getSharedPreferences(mcontext.getResources().getString(R.string.login_status_shared_preference),Context.MODE_PRIVATE);
    }

    public void putBooleanValue(String key, Boolean value){
        sharedPreferences =mcontext.getSharedPreferences(MY_SHARED_PREFERENCES,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }

    public boolean getBooleanValue (String key){
         sharedPreferences =mcontext.getSharedPreferences(MY_SHARED_PREFERENCES,
                Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key,false);
    }

    public void putStringValue(String key, String value){
        sharedPreferences =mcontext.getSharedPreferences(MY_SHARED_PREFERENCES,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString(key,value);
        editor.apply();
    }
    public String getStringValue (String key){
        sharedPreferences =mcontext.getSharedPreferences(MY_SHARED_PREFERENCES,
                Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }

    public void login_status (boolean status){
        sharedPreferences =mcontext.getSharedPreferences(MY_SHARED_PREFERENCES,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(mcontext.getResources().getString(R.string.login_status_shared_preference),status);
        editor.commit();
    }
    public boolean read_login_status(){
        sharedPreferences =mcontext.getSharedPreferences(MY_SHARED_PREFERENCES,
                Context.MODE_PRIVATE);
        boolean status = false;
        status = sharedPreferences.getBoolean(mcontext.getResources().getString(R.string.login_status_shared_preference),false);
        return status;
    }


//    public void logout(){
//        sharedPreferences = mcontext.getSharedPreferences(MY_SHARED_PREFERENCES,
//                Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor =sharedPreferences.edit();
//        editor.clear();
//        editor.apply();
//    }
}
