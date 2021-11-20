package com.cntt.homecooking.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cntt.homecooking.R;
import com.cntt.homecooking.api.ApiService;
import com.cntt.homecooking.databinding.ActivityRegisterBinding;
import com.cntt.homecooking.model.RegisterRequest;
import com.cntt.homecooking.model.RegisterResponse;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;

    TextInputLayout edtName,edtEmail,edtPassword1,edtPassword2;
    TextView txtError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();

        // Click đăng ký
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterRequest registerRequest = new RegisterRequest();
                registerRequest.setName(edtName.getEditText().getText().toString());
                registerRequest.setEmail(edtEmail.getEditText().getText().toString());
                registerRequest.setPassword(edtPassword1.getEditText().getText().toString());
                clickRegister(registerRequest);
            }
        });

        // Xử lý EditText Họ tên
//        edtName.getEditText().addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                // Báo lỗi nếu số ký tự ở Mật khẩu ít hơn 6
//                if(charSequence.length()<6){
//                    txtError.setText("Họ tên phải có từ 6 kí tự trở lên");
//                    edtName.setBackground(getDrawable(R.drawable.rectangle_edt_1_error));
//                }
//                else{
//                    txtError.setText("");
//                    edtName.setBackground(getDrawable(R.drawable.rectangle_edt_1));
//                }
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                enableRegisterButton();
//            }
//        });

    }

    private void clickRegister(RegisterRequest registerRequest) {
        ApiService.apiService.register(registerRequest)
                .enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if (response.isSuccessful()){
                            String message = "Successfull";
                            Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                            finish();
                        }else {
                            String message = "An error occure";
                            Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        String message = t.getLocalizedMessage();
                        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void enableRegisterButton() {

    }

    private void initView() {
        edtName=binding.regName;
        edtEmail=binding.regEmail;
        edtPassword1=binding.regMk1;
        edtPassword2=binding.regMk2;
        txtError=binding.txtError;
    }

}