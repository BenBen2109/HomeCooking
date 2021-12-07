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
import com.cntt.homecooking.model.LoaiThucPham;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LoaiThucPhamAdapter extends RecyclerView.Adapter<LoaiThucPhamAdapter.LoaiThucPhamViewHolder>{
    private List<LoaiThucPham> loaiThucPhamList;
    private Context context;

    public LoaiThucPhamAdapter(List<LoaiThucPham> loaiThucPhamList, Context context) {
        this.loaiThucPhamList = loaiThucPhamList;
        this.context = context;
    }

    @NonNull
    @Override
    public LoaiThucPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_cate,parent,false);
        return new LoaiThucPhamAdapter.LoaiThucPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiThucPhamViewHolder holder, int position) {
        LoaiThucPham loaiThucPham= loaiThucPhamList.get(position);
        if(loaiThucPham==null){
            return;
        }
        holder.txtLoaithucpham.setText(loaiThucPham.getTenLoai());
        if(!loaiThucPham.getLinkHinhAnh().isEmpty()){
            Picasso.get()
                    .load(loaiThucPham.getLinkHinhAnh())
                    .error(R.drawable.error)
                    .placeholder(R.drawable.loading)
                    .fit()
                    .into(holder.imgLoaithupham);
        }
    }

    @Override
    public int getItemCount() {
        if(loaiThucPhamList!=null){
            return loaiThucPhamList.size();
        }
        return 0;
    }

    public class LoaiThucPhamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtLoaithucpham;
        private ImageView imgLoaithupham;

        public LoaiThucPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            txtLoaithucpham=itemView.findViewById(R.id.categoryName);
            imgLoaithupham=itemView.findViewById(R.id.categoryPic);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
