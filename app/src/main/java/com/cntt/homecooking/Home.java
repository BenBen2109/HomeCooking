package com.cntt.homecooking;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cntt.homecooking.adapter.HomeCongThucNauAnAdapter;
import com.cntt.homecooking.adapter.HomeThucPhamAdapter;
import com.cntt.homecooking.api.ApiService;
import com.cntt.homecooking.db.DBManager;
import com.cntt.homecooking.db.DBManagerDAO;
import com.cntt.homecooking.model.CongThucNauAn;
import com.cntt.homecooking.model.ThucPham;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends Fragment  {
    private List<ThucPham> thucPhamList=new ArrayList<>();
    private RecyclerView rcvThucpham;
    private RecyclerView.Adapter thucphamAdapter;

    private List<CongThucNauAn> congthucnauanList=new ArrayList<>();
    private RecyclerView rcvCongthucnauan;
    private RecyclerView.Adapter congthucnauanAdapter;

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


    @Override
    public void onResume() {
        super.onResume();
    }

    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {




        mView = inflater.inflate(R.layout.fragment_home, container, false);



        // List Thực Phẩm


        thucphamAdapter = new HomeThucPhamAdapter(thucPhamList, mContext);
        rcvThucpham = (RecyclerView) mView.findViewById(R.id.proCate_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcvThucpham.setLayoutManager(linearLayoutManager);
        rcvThucpham.setAdapter(thucphamAdapter);

        // List Công thức nấu ăn

        congthucnauanAdapter = new HomeCongThucNauAnAdapter(congthucnauanList, mContext);
        rcvCongthucnauan = (RecyclerView) mView.findViewById(R.id.pop_view);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcvCongthucnauan.setLayoutManager(linearLayoutManager1);
        rcvCongthucnauan.setAdapter(congthucnauanAdapter);

        getListThucPham();
        getListCongThucNauAn();


        return mView;

    }
    // Lấy danh sách công thức nấu ăn hiển thị trên trang chủ
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
    // Lấy danh sách thực phẩm hiển thị trên trang chủ
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


    public void reloadData(){
        Toast.makeText(getActivity(), "reload data", Toast.LENGTH_SHORT).show();
    }

}