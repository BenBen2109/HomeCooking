package com.cntt.homecooking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cntt.homecooking.adapter.ThanhToanAdapter;
import com.cntt.homecooking.api.ApiService;
import com.cntt.homecooking.data_local.DataLocalManager;
import com.cntt.homecooking.model.ChiTietHoaDonKhachHang;
import com.cntt.homecooking.model.GioHang;
import com.cntt.homecooking.model.HoaDonKhachHang;
import com.cntt.homecooking.model.LoHang;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalService;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThanhToan extends AppCompatActivity {

    Button btnThanhToan_ThanhToan;
    TextView textPriceTongTien_ThanhToan;

    private RecyclerView rcvThanhToan;
    private ThanhToanAdapter thanhToanAdapter;
    private List<GioHang> gioHangList = new ArrayList<>();
    Context context;

    private int tongtien;
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

        initView();

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(ThanhToan.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.phuongthucthanhtoan));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        thanhToanAdapter = new ThanhToanAdapter(MainActivity.gioHangList,ThanhToan.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ThanhToan.this, LinearLayoutManager.VERTICAL, false);
        rcvThanhToan.setLayoutManager(linearLayoutManager);
        rcvThanhToan.setAdapter(thanhToanAdapter);


        Intent intent = getIntent();
        tongtien = intent.getIntExtra("tongtien",0);
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        textPriceTongTien_ThanhToan.setText(decimalFormat.format(tongtien)+" đ");

        btnThanhToan_ThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postHoadon();
            }
        });

        //Thanh Toán Paypal với dạng if else (chưa viết được)



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
    //POST Hóa đơn sau khi đã xác nhận thanh toán
    private void postHoadon() {
        HoaDonKhachHang hoaDonKhachHang=new HoaDonKhachHang(null, DataLocalManager.getUserId(),null,null,tongtien,"COD","Chờ xác nhận",null);
        ApiService.apiService.postHoaDon(hoaDonKhachHang).enqueue(new Callback<HoaDonKhachHang>() {
            @Override
            public void onResponse(Call<HoaDonKhachHang> call, Response<HoaDonKhachHang> response) {
                String idInvoice=response.body().getIdInvoice();
                postLohang(idInvoice);
            }

            @Override
            public void onFailure(Call<HoaDonKhachHang> call, Throwable t) {

            }
        });
    }

    // POST Lô hàng
    private void postLohang(String idInvoice) {
        for (GioHang gioHang: MainActivity.gioHangList){
            LoHang loHang=new LoHang(null,gioHang.getIdFood(), gioHang.getSoluong(), null,null,null);
            ApiService.apiService.postLohang(loHang).enqueue(new Callback<LoHang>() {
                @Override
                public void onResponse(Call<LoHang> call, Response<LoHang> response) {
                    String idLoHang=response.body().getIdLoHang();
                    String idInvoice1=idInvoice;
                    Integer soluongmua=new Integer(gioHang.getSoluongmua());
                    Integer giatien=new Integer(gioHang.getPrice());
                    postChiTietHoaDonKhachHang(idLoHang,idInvoice1,soluongmua,giatien);
                }

                @Override
                public void onFailure(Call<LoHang> call, Throwable t) {

                }
            });
        }
    }
    //POST Chi tiết hóa đơn khách hàng
    private void postChiTietHoaDonKhachHang(String idLoHang,String idInvoice1,Integer soluongmua,Integer giatien) {
        ChiTietHoaDonKhachHang chiTietHoaDonKhachHang=new ChiTietHoaDonKhachHang(idInvoice1,idLoHang,soluongmua,giatien);
        ApiService.apiService.postChiTietHoaDonKhachHang(chiTietHoaDonKhachHang).enqueue(new Callback<ChiTietHoaDonKhachHang>() {
            @Override
            public void onResponse(Call<ChiTietHoaDonKhachHang> call, Response<ChiTietHoaDonKhachHang> response) {
                MainActivity.gioHangList.clear();
                MainActivity.giohangAdapter.notifyDataSetChanged();
                Cart.tinhtongtien();
                Toast.makeText(getApplicationContext(), "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ChiTietHoaDonKhachHang> call, Throwable t) {

            }
        });
    }

    private void initView() {
        rcvThanhToan=findViewById(R.id.cart_rclview_ThanhToan);
        textPriceTongTien_ThanhToan=findViewById(R.id.textPriceTongTien_ThanhToan);
        btnThanhToan_ThanhToan = findViewById(R.id.btnThanhToan_ThanhToan);
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