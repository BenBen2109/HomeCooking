package com.cntt.homecooking;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cntt.homecooking.activities.LichSuHoaDon;
import com.cntt.homecooking.activities.LoginActivity;
import com.cntt.homecooking.activities.UserInfo;
import com.cntt.homecooking.databinding.FragmentMeBinding;
import com.cntt.homecooking.model.KhachHang;


public class Me extends Fragment  {
    private static final String MY_SHARED_PREFERENCES = "MY_SHARED_PREFERENCES";
    private FragmentMeBinding binding;

    private LoginActivity loginActivity;

    private KhachHang kh;

    private ConstraintLayout user_info,logOut,lsDonHang;
    TextView txt1;

    private View mView;

    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMeBinding.inflate(inflater,container,false);


        user_info=binding.userInfo;
        logOut=binding.logOut;
        lsDonHang=binding.lsdonhang;

        lsDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), LichSuHoaDon.class);
                startActivity(in);
            }
        });




        user_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),UserInfo.class);
                startActivity(intent);
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });

//        user_name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent in = new Intent(getActivity(), LoginActivity.class);
//                startActivity(in);
//            }
//        });

//        txt1 = binding.txt1;
//        Bundle bundle = getActivity().getIntent().getExtras();
//        if(bundle != null){
//            KhachHang khachHang = (KhachHang) bundle.get("object_user");
//            if(khachHang != null){
//                txt1.setText(khachHang.getName());
//            }
//        }



        return binding.getRoot();
    }

    private void logoutUser() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(MY_SHARED_PREFERENCES,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        Intent intent = new Intent(getActivity(),LoginActivity.class);
        startActivity(intent);

        Toast.makeText(getActivity(), "Đã đăng xuất", Toast.LENGTH_SHORT).show();
    }
}




