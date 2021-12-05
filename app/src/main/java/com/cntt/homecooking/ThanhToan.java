package com.cntt.homecooking;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cntt.homecooking.adapter.ThanhToanAdapter;
import com.cntt.homecooking.model.GioHang;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ThanhToan extends AppCompatActivity {

    Button btnThanhToan_ThanhToan;
    TextView textPriceTongTien_ThanhToan;

    private RecyclerView rcvThanhToan;
    private ThanhToanAdapter thanhToanAdapter;
    private List<GioHang> gioHangList = new ArrayList<>();
    Context context;

    private int PAYPAL_REQ_CODE = 12;
    private PayPalConfiguration payPalConfiguration = new PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX).clientId(PayPalClientIDConfig.PAYPAL_CLIENT_ID);
//    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
//                @Override
//                public void onActivityResult(ActivityResult result) {
//                    if (result.getResultCode() == RESULT_OK && result != null) {
//                        Intent intent = result.getData();
//
//                    } else {
//
//                    }
//                }
//            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(ThanhToan.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.phuongthucthanhtoan));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);



        thanhToanAdapter = new ThanhToanAdapter(MainActivity.gioHangList,ThanhToan.this);
        rcvThanhToan=findViewById(R.id.cart_rclview_ThanhToan);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ThanhToan.this, LinearLayoutManager.VERTICAL, false);
        rcvThanhToan.setLayoutManager(linearLayoutManager);
        rcvThanhToan.setAdapter(thanhToanAdapter);



        textPriceTongTien_ThanhToan=findViewById(R.id.textPriceTongTien_ThanhToan);
        Intent intent = getIntent();
        int tongtien = intent.getIntExtra("tongtien",0);
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        textPriceTongTien_ThanhToan.setText(decimalFormat.format(tongtien)+" đ");

        //Thanh Toán Paypal với dạng if else (chưa viết được)

        btnThanhToan_ThanhToan = findViewById(R.id.btnThanhToan_ThanhToan);

//        Intent intent = new Intent(this, PayPalService.class);
//        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfiguration);
//        startService(intent);
//        if(chỗ chọn thanh toán = PayPal){
//            PaypalPaymentMenthod();
//        }else Không hiện gì cả thực hiện thanh toán bình thường

//        btnThanhToan_ThanhToan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PaypalPaymentMenthod();
//            }
//        });
    }

//    private void PaypalPaymentMenthod(){
//
//        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(100), "VND", "HomeCooking", PayPalPayment.PAYMENT_INTENT_SALE);
//        Intent intent = new Intent(this, PaymentActivity.class);
//        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfiguration);
//        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payPalPayment);
//        startActivityForResult(intent, PAYPAL_REQ_CODE);
////        activityResultLauncher.launch(intent);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode == PAYPAL_REQ_CODE){
//
//            if(requestCode == Activity.RESULT_OK){
//                Toast.makeText(this, "Thành Công", Toast.LENGTH_LONG).show();
//            }else{
//                Toast.makeText(this, "Thất Bại", Toast.LENGTH_LONG).show();
//            }
//        }
//    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }
}