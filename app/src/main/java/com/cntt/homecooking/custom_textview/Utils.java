package com.cntt.homecooking.custom_textview;

import android.content.Context;
import android.graphics.Typeface;

public class Utils {

    private static Typeface bungeeRegularTypeface;
    private static Typeface bungeeColorRegularColrTypeface;

    public static Typeface getBungeeRegularTypeface(Context context) {
        if(bungeeRegularTypeface == null){
            bungeeRegularTypeface = Typeface.createFromAsset(context.getAssets(),"fonts/Bungee-Regular.ttf");
        }
        return bungeeRegularTypeface;
    }

    public static Typeface getBungeeColorRegularColrTypeface(Context context) {
        if(bungeeColorRegularColrTypeface == null){
            bungeeColorRegularColrTypeface = Typeface.createFromAsset(context.getAssets(),"fonts/BungeeColor-Regular_colr_Windows.ttf");
        }
        return bungeeColorRegularColrTypeface;
    }
}
