package com.cntt.homecooking;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cntt.homecooking.adapter.LikedAdapter;
import com.cntt.homecooking.db.DBManager;
import com.cntt.homecooking.model.LikedModel;

import java.util.ArrayList;


public class Product extends Fragment {


    private View mView;
    RecyclerView likedrecycleview;
    private RecyclerView rclLikedlist;
    private RecyclerView.Adapter likedAdapter;
    private ArrayList<LikedModel> alLiked;
    private Context mContext;
    SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_product, container, false);

        likedrecycleview= mView.findViewById(R.id.rcl_product);






        DBManager db = new DBManager(mView.getContext());
        ArrayList<LikedModel> list = db.getLiked();


        LikedAdapter adapter = new LikedAdapter(list,mContext);
        likedrecycleview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        likedrecycleview.setLayoutManager(layoutManager);

//        swipeRefreshLayout = mView.findViewById(R.id.swipeRefreshLayout);
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                ArrayList<LikedModel> list = db.getLiked();
//                LikedAdapter adapter = new LikedAdapter(list,mContext);
//                likedrecycleview.setAdapter(adapter);
//
//
//                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//                likedrecycleview.setLayoutManager(layoutManager);
//                adapter.notifyDataSetChanged();
//                swipeRefreshLayout.setRefreshing(false);
//            }
//        });


        return mView;
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