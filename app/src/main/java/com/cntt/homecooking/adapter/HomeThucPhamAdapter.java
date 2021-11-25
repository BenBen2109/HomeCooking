package com.cntt.homecooking.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cntt.homecooking.R;
import com.cntt.homecooking.activities.DetailFormulaActivity;
import com.cntt.homecooking.activities.DetailProduct;
import com.cntt.homecooking.model.ThucPham;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeThucPhamAdapter extends RecyclerView.Adapter<HomeThucPhamAdapter.ThucPhamViewHolder>{
    private List<ThucPham> thucPhamList;
    private Context context;



    public HomeThucPhamAdapter(List<ThucPham> thucPhamList, Context context) {
        this.thucPhamList = thucPhamList;
        this.context = context;
    }

    @NonNull
    @Override
    public ThucPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new ThucPhamViewHolder(view);
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
    // Giới hạn số lượng hiển thị
    private int limit=5;

    @Override
    public int getItemCount() {
        if (thucPhamList.size()>limit){
            return limit;
        }
        return thucPhamList.size();
//        if(thucPhamList!=null){
//            return thucPhamList.size();
//        }
//        return 0;
    }

    //View Holder
    public class ThucPhamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtTenthucpham;
        private ImageView imgHinhthucpham;

        public ThucPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenthucpham=itemView.findViewById(R.id.popularName);
            imgHinhthucpham=itemView.findViewById(R.id.ItemProductPic);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, DetailProduct.class);
            intent.putExtra("idFood",thucPhamList.get(position).getIdFood());
            intent.putExtra("nameFood",thucPhamList.get(position).getNameFood());
            intent.putExtra("price",thucPhamList.get(position).getPrice());
            intent.putExtra("linkHinhAnh",thucPhamList.get(position).getLinkHinhAnh());
            intent.putExtra("donViTinh",thucPhamList.get(position).getDonViTinh());

            context.startActivity(intent);
        }
    }
}
