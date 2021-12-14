package com.cntt.homecooking.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cntt.homecooking.R;
import com.cntt.homecooking.activities.DetailProduct;
import com.cntt.homecooking.model.CongThucNauAn;
import com.cntt.homecooking.model.ThucPham;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ThucPhamAdapter extends RecyclerView.Adapter<ThucPhamAdapter.ThucPhamViewHolder> implements Filterable {
    private List<ThucPham> thucPhamList;
    private List<ThucPham> thucPhamListold;
    private Context context;

    public ThucPhamAdapter(List<ThucPham> thucPhamList, Context context) {
        this.thucPhamList = thucPhamList;
        thucPhamListold=thucPhamList;
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

        holder.txtTenthucpham.setText(thucPham.getNameFood()+" "+thucPham.getSoLuong()+" "+thucPham.getDonViTinh());
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

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strSearch=charSequence.toString();
                if(strSearch.isEmpty()){
                    thucPhamList=thucPhamListold;
                }
                else {
                    List<ThucPham> list=new ArrayList<>();
                    for(ThucPham thucPham: thucPhamListold){
                        if(thucPham.getNameFood().contains(strSearch.toLowerCase())){
                            list.add(thucPham);
                        }
                    }
                    thucPhamList=list;
                }
                FilterResults filterResults=new FilterResults();
                filterResults.values=thucPhamList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                thucPhamList= (List<ThucPham>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ThucPhamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtTenthucpham;
        private ImageView imgHinhthucpham;
        private RecyclerView recyclerViewProductCate;
        public ThucPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenthucpham=itemView.findViewById(R.id.ttName);
            imgHinhthucpham=itemView.findViewById(R.id.ttPic);
            recyclerViewProductCate=itemView.findViewById(R.id.rcl_product_cate);
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
            intent.putExtra("soLuong",thucPhamList.get(position).getSoLuong());

            context.startActivity(intent);
        }
    }
}
