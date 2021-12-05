package com.cntt.homecooking;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cntt.homecooking.adapter.HomeThucPhamAdapter;
import com.cntt.homecooking.adapter.LikedAdapter;
import com.cntt.homecooking.adapter.ThucPhamAdapter;
import com.cntt.homecooking.api.ApiService;
import com.cntt.homecooking.db.DBManager;
import com.cntt.homecooking.model.LikedModel;
import com.cntt.homecooking.model.ThucPham;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Product extends Fragment {

    private SearchView searchView;
    private List<ThucPham> thucPhamList=new ArrayList<>();
    private RecyclerView rcvThucpham;
    private ThucPhamAdapter thucphamAdapter;
    private Context mContext;
    private View mView;

    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_product, container, false);
        initView();

        thucphamAdapter = new ThucPhamAdapter(thucPhamList, mContext);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcvThucpham.setLayoutManager(linearLayoutManager);
        rcvThucpham.setAdapter(thucphamAdapter);

        getListThucPham();

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
                thucphamAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                thucphamAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return mView;
    }

    private void initView() {
        searchView=mView.findViewById(R.id.product_search);
        rcvThucpham = mView.findViewById(R.id.rcl_product);
    }

    private void getListThucPham() {
        ApiService.apiService.getListThucPhams().enqueue(new Callback<List<ThucPham>>() {
            @Override
            public void onResponse(Call<List<ThucPham>> call, Response<List<ThucPham>> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    thucPhamList.addAll(response.body());
                    thucphamAdapter.notifyDataSetChanged();
//                    Log.e("thanhcong",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<ThucPham>> call, Throwable t) {
                Toast.makeText(getActivity(), "Có lỗi xảy ra khi lấy dữ liệu", Toast.LENGTH_SHORT).show();

            }
        });
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