package com.cntt.homecooking;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import com.cntt.homecooking.adapter.CongThucNauAnAdapter;
import com.cntt.homecooking.adapter.FormulaAdapter;
import com.cntt.homecooking.adapter.HomeCongThucNauAnAdapter;
import com.cntt.homecooking.adapter.PopularAdapter;
import com.cntt.homecooking.api.ApiService;
import com.cntt.homecooking.db.DBManager;
import com.cntt.homecooking.db.DBManagerDAO;
import com.cntt.homecooking.model.Category;
import com.cntt.homecooking.model.CongThucNauAn;
import com.cntt.homecooking.model.Popular;
import android.app.SearchManager;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Formula extends Fragment{
    private androidx.appcompat.widget.SearchView formula_search;
    private List<CongThucNauAn> congthucnauanList=new ArrayList<>();
    private RecyclerView rcvCongthucnauan;
    private RecyclerView.Adapter congthucnauanAdapter;
    private Context mContext;

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
    }

    private View mView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_formula, container, false);

        formula_search= mView.findViewById(R.id.formula_search);

        formula_search.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                congthucnauanAdapter.getFilter().filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                congthucnauanAdapter.getFilter().filter(newText);
                return true;
            }
        });


        congthucnauanAdapter = new CongThucNauAnAdapter(congthucnauanList, mContext);
        rcvCongthucnauan = (RecyclerView) mView.findViewById(R.id.rcl_formula);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcvCongthucnauan.setLayoutManager(linearLayoutManager1);
        rcvCongthucnauan.setAdapter(congthucnauanAdapter);

        getListCongThucNauAn();


        return mView;
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