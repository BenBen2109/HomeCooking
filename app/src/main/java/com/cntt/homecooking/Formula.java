package com.cntt.homecooking;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.cntt.homecooking.adapter.CongThucNauAnAdapter;

import com.cntt.homecooking.api.ApiService;

import com.cntt.homecooking.model.CongThucNauAn;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Formula extends Fragment{
    private SearchView searchView;
    private List<CongThucNauAn> congthucnauanList=new ArrayList<>();
    private RecyclerView rcvCongthucnauan;
    private CongThucNauAnAdapter congthucnauanAdapter;

    private Context mContext;
    private View mView;

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
    }



    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_formula, container, false);


        congthucnauanAdapter = new CongThucNauAnAdapter(congthucnauanList, mContext);
        rcvCongthucnauan = (RecyclerView) mView.findViewById(R.id.rcl_formula);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcvCongthucnauan.setLayoutManager(linearLayoutManager1);
        rcvCongthucnauan.setAdapter(congthucnauanAdapter);

        initView();
        getListCongThucNauAn();


        //Tìm kiếm
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.setIconified(false);
            }
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                congthucnauanAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                congthucnauanAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return mView;
    }

    private void initView() {
        searchView= mView.findViewById(R.id.formula_search);
    }

    private void getListCongThucNauAn() {
        ApiService.apiService.getListCongThucNauAn().enqueue(new Callback<List<CongThucNauAn>>() {
            @Override
            public void onResponse(Call<List<CongThucNauAn>> call, Response<List<CongThucNauAn>> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    congthucnauanList.addAll(response.body());
                    congthucnauanAdapter.notifyDataSetChanged();
//                    Log.e("thanhcong1",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<CongThucNauAn>> call, Throwable t) {
                Toast.makeText(getActivity(), "Có lỗi xảy ra khi lấy dữ liệu", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext=context;
    }
}