package com.cntt.homecooking.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cntt.homecooking.Me;
import com.cntt.homecooking.R;
import com.cntt.homecooking.api.ApiService;

import com.cntt.homecooking.databinding.ActivityLoginBinding;
import com.cntt.homecooking.model.KhachHang;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    private TextInputLayout edtUsername,edtPassword;
    private Button btnLogin;
    private TextView txtError;
    private KhachHang mKhachHang;

    private List<KhachHang> mListKhachHangs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initView();

//        Xử lý EditText Tên đăng nhập
        edtUsername.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Báo lỗi nếu số ký tự ở Tên đăng nhập ít hơn 6
                if(s.length()<6){
                    txtError.setText("Tên đăng nhập phải có từ 6 kí tự trở lên");
                    edtUsername.setBackground(getDrawable(R.drawable.rectangle_edt_1_error));
                }
                else{
                    txtError.setText("");
                    edtUsername.setBackground(getDrawable(R.drawable.rectangle_edt_1));
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                enableLoginButton();
            }
        });

//        Xử lý EditText Mật khẩu
        edtPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Báo lỗi nếu số ký tự ở Mật khẩu ít hơn 6
                if(s.length()<6){
                    txtError.setText("Mật khẩu phải có từ 6 kí tự trở lên");
                    edtPassword.setBackground(getDrawable(R.drawable.rectangle_edt_1_error));
                }
                else{
                    txtError.setText("");
                    edtPassword.setBackground(getDrawable(R.drawable.rectangle_edt_1));
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                enableLoginButton();
            }
        });
//        Xử lý nút đăng nhập bằng tài khoản
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            }
        });
//        Chuyển sang màn hình đăng ký tài khoản khi ấn đăng ký
        binding.txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });


        //
        mListKhachHangs = new ArrayList<>();
        getListUser();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLogin();
            }
        });
    }

    private void clickLogin() {
        String strUsername = edtUsername.getEditText().getText().toString().trim();
        String strPassword = edtPassword.getEditText().getText().toString().trim();


        if(mListKhachHangs == null || mListKhachHangs.isEmpty()){
            return;
        }

        boolean isHasUser = false;
        for(KhachHang khachHang : mListKhachHangs){
            if(strUsername.equals(khachHang.getEmail()) && strPassword.equals(khachHang.getPassword())){
                isHasUser = true;
                mKhachHang = khachHang;
                break;
            }
        }

        if(isHasUser){
            //ManActivity
            Intent in = new Intent(LoginActivity.this, Me.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("object_user", mKhachHang);
            in.putExtras(bundle);
            startActivity(in);
        }else{
            Toast.makeText(LoginActivity.this, "Username or password invalid", Toast.LENGTH_SHORT).show();
        }
    }

    private void getListUser() {
        ApiService.apiService.getListKhachHangs()
                .enqueue(new Callback<List<KhachHang>>() {
                    @Override
                    public void onResponse(Call<List<KhachHang>> call, Response<List<KhachHang>> response) {
                        mListKhachHangs = response.body();
//                        Log.e("List Users", mListKhachHangs.size() + "");
                    }

                    @Override
                    public void onFailure(Call<List<KhachHang>> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Call api Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    //    Nút đăng nhập sẽ sáng lên nếu Tên đăng nhập và mật khẩu đủ ký tự
    private void enableLoginButton() {
        if(edtUsername.getEditText().getText().length()<6||edtPassword.getEditText().getText().length()<6){
            btnLogin.setEnabled(false);
            btnLogin.setBackground(getDrawable(R.drawable.rectangle_btn_login_disable));
            btnLogin.setTextColor(Color.parseColor("#858585"));
        }
        else{
            btnLogin.setEnabled(true);
            btnLogin.setBackground(getDrawable(R.drawable.rectangle_btn_login));
            btnLogin.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }
//    Ánh xạ
    private void initView() {
        edtUsername=binding.edtUsername;
        edtPassword=binding.edtPassword;
        btnLogin=binding.btnLogin;
        txtError=binding.txtError;
    }
}