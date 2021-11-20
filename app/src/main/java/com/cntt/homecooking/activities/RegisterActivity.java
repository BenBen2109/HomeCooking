package com.cntt.homecooking.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.cntt.homecooking.R;
import com.cntt.homecooking.databinding.ActivityRegisterBinding;
import com.google.android.material.textfield.TextInputLayout;

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

        // Xử lý EditText Họ tên
        edtName.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Báo lỗi nếu số ký tự ở Mật khẩu ít hơn 6
                if(charSequence.length()<6){
                    txtError.setText("Họ tên phải có từ 6 kí tự trở lên");
                    edtName.setBackground(getDrawable(R.drawable.rectangle_edt_1_error));
                }
                else{
                    txtError.setText("");
                    edtName.setBackground(getDrawable(R.drawable.rectangle_edt_1));
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                enableRegisterButton();
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
    }

}