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
import com.cntt.homecooking.model.ThucPham;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ThucPhamAdapter extends RecyclerView.Adapter<ThucPhamAdapter.ThucPhamViewHolder>{
    private List<ThucPham> thucPhamList;
    private Context context;

    public ThucPhamAdapter(List<ThucPham> thucPhamList, Context context) {
        this.thucPhamList = thucPhamList;
        this.context = context;
    }

    @NonNull
    @Override
    public ThucPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new ThucPhamAdapter.ThucPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThucPhamViewHolder holder, int position) {
        ThucPham thucPham=thucPhamList.get(position);
        if(thucPham==null){
            return;
        }
        holder.txtTenthucpham.setText(thucPham.getNameFood());
        if(!thucPham.getLinkHinhAnh().isEmpty()){
            Picasso.get()
                    .load(thucPham.getLinkHinhAnh())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .fit()
                    .into(holder.imgHinhthucpham);
        }
    }

    @Override
    public int getItemCount() {
        if(thucPhamList!=null){
            return thucPhamList.size();
        }
        return 0;
    }

    public class ThucPhamViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTenthucpham;
        private ImageView imgHinhthucpham;

        public ThucPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenthucpham=itemView.findViewById(R.id.popularName);
            imgHinhthucpham=itemView.findViewById(R.id.ItemProductPic);
        }
    }
}
