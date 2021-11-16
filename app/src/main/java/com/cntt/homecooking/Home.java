package com.cntt.homecooking;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.cntt.homecooking.adapter.CategoryAdapter;
import com.cntt.homecooking.adapter.PopularAdapter;
import com.cntt.homecooking.adapter.ThucPhamAdapter;
import com.cntt.homecooking.api.ApiService;
import com.cntt.homecooking.databinding.FragmentHomeBinding;
import com.cntt.homecooking.db.DBManager;
import com.cntt.homecooking.db.DBManagerDAO;
import com.cntt.homecooking.model.Category;
import com.cntt.homecooking.model.Formula;
import com.cntt.homecooking.model.Popular;
import com.cntt.homecooking.model.ThucPham;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends Fragment  {
    private RecyclerView rcvThucPham;
    private RecyclerView.Adapter thucphamAdapter;
    private ArrayList<ThucPham> thucPhamArrayList;
    private List<ThucPham> thucPhamList=new ArrayList<>();
    private ArrayList<Category> alCategory;
    private RecyclerView rclPopularList;
    private ArrayList<Popular> alPopular;
    private RecyclerView.Adapter popularAdapter;
    private Context mContext;
    public DBManagerDAO dbManagerDAO;
    public DBManager dbManager;
    public TextView textAllF;

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public Home() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment Home.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static Home newInstance(String param1, String param2) {
//        Home fragment = new Home();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {




        //Truyền Data
//        alCategory = new ArrayList<>();
//        rclCategoryList.setHasFixedSize(true);
        mView = inflater.inflate(R.layout.fragment_home, container, false);
//        dbManager = new DBManager(mView.getContext());
//        SQLiteDatabase db = dbManager.getReadableDatabase()


        // List Thực Phẩm

//        alCategory = dbManager.getAllCategory();
        thucphamAdapter = new ThucPhamAdapter(thucPhamList, mContext);
        rcvThucPham = (RecyclerView) mView.findViewById(R.id.proCate_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcvThucPham.setLayoutManager(linearLayoutManager);
        rcvThucPham.setAdapter(thucphamAdapter);

        //POPULAR VIEW

//        alPopular = dbManager.getAllPopular();
//        Collections.shuffle(alPopular);
//        popularAdapter = new PopularAdapter(alPopular, mContext);
//        rclPopularList = (RecyclerView) mView.findViewById(R.id.pop_view);
//        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        rclPopularList.setLayoutManager(linearLayoutManager1);
//        rclPopularList.setAdapter(popularAdapter);

        getListThucPham();

        return mView;

    }

    private void getListThucPham() {
        ApiService.apiService.getThucPhams().enqueue(new Callback<List<ThucPham>>() {
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