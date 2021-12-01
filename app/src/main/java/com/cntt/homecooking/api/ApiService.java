package com.cntt.homecooking.api;

import com.cntt.homecooking.model.CongThucNauAn;
import com.cntt.homecooking.model.KhachHang;
import com.cntt.homecooking.model.KhoBepOnline;
import com.cntt.homecooking.model.RegisterRequest;
import com.cntt.homecooking.model.RegisterResponse;
import com.cntt.homecooking.model.ThucPham;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.cert.CertificateException;
import java.util.List;
import java.util.Queue;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    //Cấu hình
//    String url="https://192.168.0.107:45456/";

    String url="http://www.homecooking.somee.com"; // Của Duy

    Gson gson=new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ApiService apiService=new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);


    //Lấy dữ liệu(GET)

    @GET("/api/ThucPhams")
    Call<List<ThucPham>> getListThucPhams();

    @GET("/api/ThucPhams/{id}")
    Call<ThucPham> getThucPhams(@Path("id") String id);

    @GET("/api/CongThucNauAns")
    Call<List<CongThucNauAn>> getListCongThucNauAn();

    //Dang nhap
    @GET("/api/KhachHangs")
    Call<List<KhachHang>> dangNhapKhachHangs();

    //Dang ky
    @POST("/api/KhachHangs")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @GET("api/KhoBepOnlines")
    Call<List<KhoBepOnline>> getListKhoBep();

    @POST("api/KhoBepOnlines")
    Call<KhoBepOnline> postKhoBep(@Body KhoBepOnline khoBepOnline);

}
