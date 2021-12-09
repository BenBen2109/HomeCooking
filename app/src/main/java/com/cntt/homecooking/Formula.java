package com.cntt.homecooking;

import android.annotation.SuppressLint;
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


import com.cntt.homecooking.adapter.ChuDeCongThucAdapter;
import com.cntt.homecooking.adapter.CongThucNauAnAdapter;

import com.cntt.homecooking.api.ApiService;

import com.cntt.homecooking.model.ChiTietChuDeCongThuc;
import com.cntt.homecooking.model.ChiTietCongThucNauAn;
import com.cntt.homecooking.model.ChuDeCongThuc;
import com.cntt.homecooking.model.CongThucNauAn;
import com.cntt.homecooking.model.LoaiThucPham;
import com.cntt.homecooking.model.ThucPham;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Formula extends Fragment{
    private SearchView searchView;
    private static List<CongThucNauAn> congthucnauanList=new ArrayList<>();
    private static List<CongThucNauAn> congthucnauanListold=new ArrayList<>();
    private List<ChuDeCongThuc> chuDeCongThucList=new ArrayList<>();
    private static List<ChiTietChuDeCongThuc> chiTietChuDeCongThucList=new ArrayList<>();
    private RecyclerView rcvCongthucnauan,rcvChudecongthuc;
    private ChuDeCongThucAdapter chuDeCongThucAdapter;
    @SuppressLint("StaticFieldLeak")
    private static CongThucNauAnAdapter congthucnauanAdapter;

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
        initView();

        congthucnauanAdapter = new CongThucNauAnAdapter(congthucnauanList, mContext);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcvCongthucnauan.setLayoutManager(linearLayoutManager1);
        rcvCongthucnauan.setAdapter(congthucnauanAdapter);

        chuDeCongThucAdapter = new ChuDeCongThucAdapter(chuDeCongThucList, mContext);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvChudecongthuc.setLayoutManager(linearLayoutManager);
        rcvChudecongthuc.setAdapter(chuDeCongThucAdapter);


        getListCongThucNauAn();
        getListChuDeCongThuc();
        getListChiTietChuDeCongThucList();


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


    public static void clickChuDeCongThuc(String idChuDe){
        congthucnauanList.clear();
        if(!idChuDe.isEmpty()){
            for(ChiTietChuDeCongThuc chiTietChuDeCongThuc: chiTietChuDeCongThucList){
                if(chiTietChuDeCongThuc.getIdChuDe().equals(idChuDe)){
                    for (CongThucNauAn congThucNauAn: congthucnauanListold){
                        if (congThucNauAn.getIdCongThuc().equals(chiTietChuDeCongThuc.getIdCongThuc())){
                            congthucnauanList.add(congThucNauAn);
                        }
                    }
                }
            }
        }
        else {
            congthucnauanList.addAll(congthucnauanListold);
        }
        congthucnauanAdapter.notifyDataSetChanged();
    }


    // GET API List Chi tiết chủ để công thức
    private void getListChiTietChuDeCongThucList() {
        ApiService.apiService.getListChiTietChuDeCongThuc().enqueue(new Callback<List<ChiTietChuDeCongThuc>>() {
            @Override
            public void onResponse(Call<List<ChiTietChuDeCongThuc>> call, Response<List<ChiTietChuDeCongThuc>> response) {
                chiTietChuDeCongThucList.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<ChiTietChuDeCongThuc>> call, Throwable t) {

            }
        });
    }

    // GET API List Chủ đề công thức
    private void getListChuDeCongThuc() {
        chuDeCongThucList.add(new ChuDeCongThuc("","Tất cả","",""));
        ApiService.apiService.getListChuDeCongThuc().enqueue(new Callback<List<ChuDeCongThuc>>() {
            @Override
            public void onResponse(Call<List<ChuDeCongThuc>> call, Response<List<ChuDeCongThuc>> response) {
                chuDeCongThucList.addAll(response.body());
                chuDeCongThucAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ChuDeCongThuc>> call, Throwable t) {

            }
        });
    }

    // GET API List Công thức nấu ăn
    private void getListCongThucNauAn() {
        ApiService.apiService.getListCongThucNauAn().enqueue(new Callback<List<CongThucNauAn>>() {
            @Override
            public void onResponse(Call<List<CongThucNauAn>> call, Response<List<CongThucNauAn>> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    congthucnauanListold.addAll(response.body());
                    congthucnauanList.addAll(congthucnauanListold);
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

    private void initView() {
        searchView= mView.findViewById(R.id.formula_search);
        rcvCongthucnauan = mView.findViewById(R.id.rcl_formula);
        rcvChudecongthuc=mView.findViewById(R.id.rcl_formula_cate);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext=context;
    }
}