package com.cntt.homecooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.cntt.homecooking.activities.LoginActivity;
import com.cntt.homecooking.activities.RegisterActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}