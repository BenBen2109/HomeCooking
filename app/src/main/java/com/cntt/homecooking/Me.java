package com.cntt.homecooking;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cntt.homecooking.activities.LoginActivity;
import com.cntt.homecooking.databinding.FragmentMeBinding;
import com.cntt.homecooking.model.KhachHang;


public class Me extends Fragment  {
    private FragmentMeBinding binding;

    TextView user_name,txt1;

    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMeBinding.inflate(inflater,container,false);

        user_name=binding.userName;

        user_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), LoginActivity.class);
                startActivity(in);
            }
        });

        txt1 = binding.txt1;
        Bundle bundle = getActivity().getIntent().getExtras();
        if(bundle != null){
            KhachHang khachHang = (KhachHang) bundle.get("object_user");
            if(khachHang != null){
                txt1.setText(khachHang.getName());
            }
        }

        return binding.getRoot();
    }
}




