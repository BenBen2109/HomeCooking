package com.cntt.homecooking.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cntt.homecooking.R;
import com.cntt.homecooking.data_local.DataLocalManager;

public class MyKitchen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_kitchen);

        String idKhoBep = DataLocalManager.getIdKhoBep();

    }
}