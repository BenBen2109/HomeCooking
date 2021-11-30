package com.cntt.homecooking.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.cntt.homecooking.R;
import com.cntt.homecooking.data_local.DataLocalManager;

public class UserInfo extends AppCompatActivity {


    private TextView user_Name,user_Email,user_Phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        user_Name = findViewById(R.id.userName);
        user_Email = findViewById(R.id.userEmail);
        user_Phone = findViewById(R.id.userPhone);

        String userName = DataLocalManager.getUserName();
        user_Name.setText(userName.toString());

        String userEmail = DataLocalManager.getUserEmail();
        user_Email.setText(userEmail.toString());

        String userPhone = DataLocalManager.getUserPhone();
        user_Phone.setText(userPhone.toString());
    }
}