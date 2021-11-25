package com.cntt.homecooking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cntt.homecooking.R;
import com.cntt.homecooking.model.GioHang;
import com.squareup.picasso.Picasso;


import java.util.List;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.GioHangViewHolder>{
    private List<GioHang> gioHangList;
    private Context context;

    public GioHangAdapter(List<GioHang> gioHangList, Context context) {
        this.gioHangList = gioHangList;
        this.context = context;
    }

    @NonNull
    @Override
    public GioHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart,parent,false);
        return new GioHangAdapter.GioHangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GioHangViewHolder holder, int position) {
        GioHang gioHang=gioHangList.get(position);
        if(gioHang==null){
            return;
        }
        holder.txttensanpham.setText(gioHang.getNameFood());
        holder.txtgiasanpham.setText(""+gioHang.getPrice());
        holder.edtsoluong.setText(""+gioHang.getSoluong());
        if(!gioHang.getLinkHinhAnh().isEmpty()){
            Picasso.get()
                    .load(gioHang.getLinkHinhAnh())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .fit()
                    .into(holder.imghinhsanpham);
        }
    }

    @Override
    public int getItemCount() {
        if(gioHangList!=null){
            return gioHangList.size();
        }
        return 0;
    }

    public class GioHangViewHolder extends RecyclerView.ViewHolder{
        private TextView txttensanpham,txtgiasanpham;
        private EditText edtsoluong;
        private ImageView imghinhsanpham;

        public GioHangViewHolder(@NonNull View itemView) {
            super(itemView);
            txttensanpham=itemView.findViewById(R.id.popularName);
            txtgiasanpham=itemView.findViewById(R.id.popularGia);
            edtsoluong=itemView.findViewById(R.id.popularSoLuong);
            imghinhsanpham=itemView.findViewById(R.id.ItemProductPic);

        }
    }
}
