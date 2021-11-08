package com.cntt.homecooking.custom_textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class BungeeRegularTextView extends AppCompatTextView {

    public BungeeRegularTextView(Context context) {
        super(context);
        setFontTextView();
    }

    public BungeeRegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFontTextView();
    }

    public BungeeRegularTextView( Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontTextView();
    }
    private void setFontTextView(){
        Typeface typeface = Utils.getBungeeRegularTypeface(getContext());
        setTypeface(typeface);
    }
}
