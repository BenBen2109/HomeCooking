package com.cntt.homecooking.data_local;

import android.content.Context;

public class DataLocalManager {
    private static final String PREF_FIRST_INSTALL = "PREF_FIRST_INSTALL";
    private static final String PREF_USER_NAME = "PREF_USER_NAME";
    private static final String PREF_USER_EMAIL = "PREF_USER_EMAIL";
    private static final String PREF_USER_PHONE = "PREF_USER_PHONE";
    private static DataLocalManager instance;
    private MySharedPreferences mySharedPreferences;

    public static void init(Context context){
        instance = new DataLocalManager();
        instance.mySharedPreferences = new MySharedPreferences(context);
    }

    public static DataLocalManager getInstance(){
        if(instance == null){
            instance = new DataLocalManager();
        }
        return instance;
    }

    public static void setPrefFirstInstall(boolean isFirst){
        DataLocalManager.getInstance().mySharedPreferences.putBooleanValue(PREF_FIRST_INSTALL,isFirst);
    }

    public static boolean getPrefFirstInstall(){
        return DataLocalManager.getInstance().mySharedPreferences.getBooleanValue(PREF_FIRST_INSTALL);
    }

    public static void setUserName(String userName){
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_USER_NAME,userName);
    }
    public static String getUserName(){
        return DataLocalManager.getInstance().mySharedPreferences.getStringValue(PREF_USER_NAME);
    }

    public static void setUserEmail(String userEmail){
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_USER_EMAIL,userEmail);
    }
    public static String getUserEmail(){
        return DataLocalManager.getInstance().mySharedPreferences.getStringValue(PREF_USER_EMAIL);
    }

    public static void setUserPhone(String userEmail){
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_USER_PHONE,userEmail);
    }
    public static String getUserPhone(){
        return DataLocalManager.getInstance().mySharedPreferences.getStringValue(PREF_USER_PHONE);
    }
}