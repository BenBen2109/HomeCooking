package com.cntt.homecooking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cntt.homecooking.adapter.GioHangAdapter;
import com.cntt.homecooking.adapter.ThucPhamAdapter;
import com.cntt.homecooking.databinding.FragmentHomeBinding;
import com.cntt.homecooking.model.GioHang;
import com.cntt.homecooking.model.ThucPham;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link Cart#newInstance} factory method to
// * create an instance of this fragment.
// */
public class Cart extends Fragment {

    SwipeRefreshLayout swipeRefreshLayout;
    private View mView;
    private RecyclerView rcvGiohang;
    private RecyclerView.Adapter giohangAdapter;
    private static TextView txtTongtien;
    private Context mContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.fragment_cart, container, false);


        giohangAdapter=new GioHangAdapter(MainActivity.gioHangList,mContext);
        rcvGiohang = (RecyclerView) mView.findViewById(R.id.cart_rclview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcvGiohang.setLayoutManager(linearLayoutManager);
        rcvGiohang.setAdapter(giohangAdapter);


        initView();
        tinhtongtien();

        swipeRefreshLayout = mView.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                giohangAdapter=new GioHangAdapter(MainActivity.gioHangList,mContext);
                rcvGiohang = (RecyclerView) mView.findViewById(R.id.cart_rclview);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                rcvGiohang.setLayoutManager(linearLayoutManager);
                rcvGiohang.setAdapter(giohangAdapter);
                tinhtongtien();
                giohangAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        return mView;
    }

    private void initView() {
        txtTongtien=mView.findViewById(R.id.textPriceTongTien);
    }

    public static void tinhtongtien() {
        int tongtien=0;
        for (int i=0;i<MainActivity.gioHangList.size();i++){
            tongtien+=MainActivity.gioHangList.get(i).getPrice();
        }
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        txtTongtien.setText(decimalFormat.format(tongtien)+" đ");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext=null;
    }
}