package com.cntt.homecooking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cntt.homecooking.R;
import com.cntt.homecooking.model.CongThucNauAn;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CongThucNauAnAdapter extends RecyclerView.Adapter<CongThucNauAnAdapter.CongThucNauAnViewHolder>{
    public CongThucNauAnAdapter(List<CongThucNauAn> congThucNauAnList, Context context) {
        this.congThucNauAnList = congThucNauAnList;
        this.context = context;
    }

    private List<CongThucNauAn> congThucNauAnList;
    private Context context;
    @NonNull
    @Override
    public CongThucNauAnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new CongThucNauAnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CongThucNauAnViewHolder holder, int position) {
        CongThucNauAn congThucNauAn=congThucNauAnList.get(position);
        if(congThucNauAn==null){
            return;
        }
        holder.txtTencongthucnauan.setText(congThucNauAn.getTenCongThuc());
        if(!congThucNauAn.getLinkHinhAnh().isEmpty()){
            Picasso.get()
                    .load(congThucNauAn.getLinkHinhAnh())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .fit()
                    .into(holder.imgHinhcongthucnauan);
        }
    }

    @Override
    public int getItemCount() {
        if(congThucNauAnList!=null){
            return congThucNauAnList.size();
        }
        return 0;
    }

    public class CongThucNauAnViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTencongthucnauan;
        private ImageView imgHinhcongthucnauan;

        public CongThucNauAnViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTencongthucnauan=itemView.findViewById(R.id.popularName);
            imgHinhcongthucnauan=itemView.findViewById(R.id.ItemProductPic);
        }
    }
}
