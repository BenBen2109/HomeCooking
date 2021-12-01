package com.cntt.homecooking.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cntt.homecooking.MainActivity;
import com.cntt.homecooking.R;
import com.cntt.homecooking.api.ApiService;

import com.cntt.homecooking.data_local.DataLocalManager;
import com.cntt.homecooking.databinding.ActivityLoginBinding;
import com.cntt.homecooking.model.KhachHang;
import com.cntt.homecooking.model.RegisterRequest;
import com.cntt.homecooking.model.RegisterResponse;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.Login;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private CallbackManager callbackManager;
    private LoginButton loginButton;

    private TextInputLayout edtUsername,edtPassword;
    private Button btnLogin;
    private TextView txtError;
    private KhachHang mKhachHang;

    private String strUsername,strPassword,strName;

    private List<KhachHang> mListKhachHangs;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        if(!DataLocalManager.getPrefFirstInstall()){
//            Toast.makeText(this, "Lan dau tai app", Toast.LENGTH_SHORT).show();
//            DataLocalManager.setPrefFirstInstall(true);
//        }


        initView();

        // Đăng nhập Facebook
        callbackManager = CallbackManager.Factory.create();

        binding.btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_fb) {
                    loginButton.performClick();
                }
            }
        });

        loginButton.setPermissions(Arrays.asList("public_profile","email"));
        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                facebookresult();
                Toast.makeText(LoginActivity.this, "Đăng nhập bằng Facebook thành công", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                // App code
                Toast.makeText(LoginActivity.this, "Hủy đăng nhập Facebook", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                Toast.makeText(LoginActivity.this, "Có lỗi khi đăng nhập bằng Facebook", Toast.LENGTH_SHORT).show();
            }
        });

        // Xử lý EditText Email
        edtUsername.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Kiểm tra định dạng email
                if(!Patterns.EMAIL_ADDRESS.matcher(s).matches()){
                    txtError.setText("Không đúng định dạng email");
                    edtUsername.setBackground(getDrawable(R.drawable.rectangle_edt_1_error));
                }
                else{
                    txtError.setText("");
                    edtUsername.setBackground(getDrawable(R.drawable.rectangle_edt_1));
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Kiểm tra định dạng email
                if(!Patterns.EMAIL_ADDRESS.matcher(s).matches()){
                    txtError.setText("Không đúng định dạng email");
                    edtUsername.setBackground(getDrawable(R.drawable.rectangle_edt_1_error));
                }
                else{
                    txtError.setText("");
                    edtUsername.setBackground(getDrawable(R.drawable.rectangle_edt_1));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Kiểm tra định dạng email
                if(!Patterns.EMAIL_ADDRESS.matcher(s).matches()){
                    txtError.setText("Không đúng định dạng email");
                    edtUsername.setBackground(getDrawable(R.drawable.rectangle_edt_1_error));
                }
                else{
                    txtError.setText("");
                    edtUsername.setBackground(getDrawable(R.drawable.rectangle_edt_1));
                };
                enableLoginButton();
            }
        });

        // Xử lý EditText Mật khẩu
        edtPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Báo lỗi nếu số ký tự ở Mật khẩu ít hơn 6
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
                // Báo lỗi nếu số ký tự ở Mật khẩu ít hơn 6
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
            public void afterTextChanged(Editable s) {
                if(s.length()<6){
                    // Báo lỗi nếu số ký tự ở Mật khẩu ít hơn 6
                    txtError.setText("Mật khẩu phải có từ 6 kí tự trở lên");
                    edtPassword.setBackground(getDrawable(R.drawable.rectangle_edt_1_error));
                }
                else{
                    txtError.setText("");
                    edtPassword.setBackground(getDrawable(R.drawable.rectangle_edt_1));
                };
                enableLoginButton();
            }
        });


        // Xử lý nút đăng nhập bằng tài khoản
        mListKhachHangs = new ArrayList<>();
        getListUser();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLogin();
            }
        });



        // Chuyển sang màn hình đăng ký tài khoản khi ấn đăng ký
        binding.txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    private void facebookresult() {
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Insert your code here
                        Log.d("test", object.toString());
                        try {
                            strUsername=object.getString("email");
                            strPassword=object.getString("id");
                            strName=object.getString("name");
                            loginFacebook(strUsername,strPassword);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email");
        request.setParameters(parameters);
        request.executeAsync();
    }

    private void loginFacebook(String strUsername, String strPassword) {
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
            String userName = mKhachHang.getName();
            DataLocalManager.setUserName(userName);

            String userEmail = mKhachHang.getEmail();
            DataLocalManager.setUserEmail(userEmail);

            String userPhone = mKhachHang.getSdt();
            DataLocalManager.setUserPhone(userPhone);

            Intent in = new Intent(LoginActivity.this, MainActivity.class);

//            Me me = new Me();
//            FragmentTransaction faFragmentTransaction = getSupportFragmentManager().beginTransaction();
//
//            Bundle data = new Bundle();
//            data.putString("data",strUsername);
//
//            me.setArguments(data);

//            Bundle bundle = new Bundle();
//            bundle.putSerializable("object_user", mKhachHang);
//            in.putExtras(bundle);
            startActivity(in);
            Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        }else{
            RegisterRequest registerRequest=new RegisterRequest();
            registerRequest.setEmail(strUsername);
            registerRequest.setName(strName);
            registerRequest.setPassword(strPassword);
            Register(registerRequest);
        }
    }


    private void Register(RegisterRequest registerRequest) {
        ApiService.apiService.register(registerRequest)
                .enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if (response.isSuccessful()){
                            String message = "Đăng ký tài khoản mới thành công";
                            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            finish();
                        }else {
                            String message = "Có lỗi xảy ra";
                            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        String message = t.getLocalizedMessage();
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void clickLogin() {
        strUsername = edtUsername.getEditText().getText().toString().trim();
        strPassword = edtPassword.getEditText().getText().toString().trim();

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
            String userName = mKhachHang.getName();
            DataLocalManager.setUserName(userName);

            String userEmail = mKhachHang.getEmail();
            DataLocalManager.setUserEmail(userEmail);

            String userPhone = mKhachHang.getSdt();
            DataLocalManager.setUserPhone(userPhone);

            Intent in = new Intent(LoginActivity.this, MainActivity.class);

//            Me me = new Me();
//            FragmentTransaction faFragmentTransaction = getSupportFragmentManager().beginTransaction();
//
//            Bundle data = new Bundle();
//            data.putString("data",strUsername);
//
//            me.setArguments(data);

//            Bundle bundle = new Bundle();
//            bundle.putSerializable("object_user", mKhachHang);
//            in.putExtras(bundle);

            in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(in);
            Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(LoginActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
        }
    }


    private void getListUser() {
        ApiService.apiService.dangNhapKhachHangs()
                .enqueue(new Callback<List<KhachHang>>() {
                    @Override
                    public void onResponse(Call<List<KhachHang>> call, Response<List<KhachHang>> response) {
                        mListKhachHangs = response.body();
                    }

                    @Override
                    public void onFailure(Call<List<KhachHang>> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Có lỗi xảy ra", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // Nút đăng nhập sẽ sáng lên nếu đủ điều kiện
    private void enableLoginButton() {
        if(edtPassword.getEditText().getText().length()<6 || !Patterns.EMAIL_ADDRESS.matcher(edtUsername.getEditText().getText().toString().trim()).matches()){
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
        loginButton =binding.loginButton;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        LoginManager.getInstance().logOut();
        super.onStart();
    }
}