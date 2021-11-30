package com.cntt.homecooking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cntt.homecooking.activities.LoginActivity;
import com.cntt.homecooking.activities.UserInfo;
import com.cntt.homecooking.data_local.MySharedPreferences;
import com.cntt.homecooking.databinding.FragmentMeBinding;
import com.cntt.homecooking.model.KhachHang;


public class Me extends Fragment  {
    private FragmentMeBinding binding;

    private LoginActivity loginActivity;

    private KhachHang kh;

    private TextView user_info,logOut;
    TextView txt1;

    private View mView;

    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMeBinding.inflate(inflater,container,false);


        user_info=binding.userInfo;
        logOut=binding.logOut;


        user_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),UserInfo.class);
                startActivity(intent);
            }
        });

//        logOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                logoutUser();
//            }
//        });

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
        MySharedPreferences sharedPreferences = new MySharedPreferences(mContext.getApplicationContext());
        sharedPreferences.logout();
        Intent intent = new Intent(getActivity(),LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        Toast.makeText(mContext, "Đã đăng xuất", Toast.LENGTH_SHORT).show();
    }
}




