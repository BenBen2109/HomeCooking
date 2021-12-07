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
import com.cntt.homecooking.model.ChiTietCongThucNauAn;
import com.cntt.homecooking.model.ThucPham;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChiTietCongThucNauAnAdapter extends RecyclerView.Adapter<ChiTietCongThucNauAnAdapter.ChiTietCongThucNauAnViewHolder>{
    private List<ChiTietCongThucNauAn> chiTietCongThucNauAnList;
    private List<ThucPham> thucPhamList;
    private Context context;

    public ChiTietCongThucNauAnAdapter(List<ChiTietCongThucNauAn> chiTietCongThucNauAnList, List<ThucPham> thucPhamList, Context context) {
        this.chiTietCongThucNauAnList = chiTietCongThucNauAnList;
        this.thucPhamList = thucPhamList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChiTietCongThucNauAnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thanh_phan_mon_an,parent,false);
        return new ChiTietCongThucNauAnAdapter.ChiTietCongThucNauAnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChiTietCongThucNauAnViewHolder holder, int position) {
        ChiTietCongThucNauAn chiTietCongThucNauAn=chiTietCongThucNauAnList.get(position);
        if(chiTietCongThucNauAn==null){
            return;
        }
        for(ThucPham thucPham: thucPhamList){
            if (thucPham.getIdFood().equals(chiTietCongThucNauAn.getIdFood())){
                holder.txtTen.setText(thucPham.getNameFood());
                holder.txtSoluong.setText(chiTietCongThucNauAn.getSoLuong()+" "+thucPham.getDonViTinh());
                if(!thucPham.getLinkHinhAnh().isEmpty()){
                    Picasso.get()
                            .load(thucPham.getLinkHinhAnh())
                            .error(R.drawable.error)
                            .placeholder(R.drawable.loading)
                            .fit()
                            .into(holder.imgHinh);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        if(chiTietCongThucNauAnList!=null){
            return chiTietCongThucNauAnList.size();
        }
        return 0;
    }

    public class ChiTietCongThucNauAnViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTen,txtSoluong;
        private ImageView imgHinh;
        public ChiTietCongThucNauAnViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTen=itemView.findViewById(R.id.txt_product_name);
            txtSoluong=itemView.findViewById(R.id.txt_product_qty);
            imgHinh=itemView.findViewById(R.id.img_product);
        }
    }
}
