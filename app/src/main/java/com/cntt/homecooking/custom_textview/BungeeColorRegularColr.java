package com.cntt.homecooking.custom_textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class BungeeColorRegularColr extends AppCompatTextView {
    public BungeeColorRegularColr(@NonNull Context context) {
        super(context);
        setFontTextView();
    }

    public BungeeColorRegularColr(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontTextView();
    }

    public BungeeColorRegularColr(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontTextView();
    }
    private void setFontTextView(){
        Typeface typeface = Utils.getBungeeColorRegularColrTypeface(getContext());
        setTypeface(typeface);
    }
}
