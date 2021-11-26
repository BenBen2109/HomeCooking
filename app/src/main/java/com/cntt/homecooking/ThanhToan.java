package com.cntt.homecooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ThanhToan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(ThanhToan.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.phuongthucthanhtoan));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

    }
}