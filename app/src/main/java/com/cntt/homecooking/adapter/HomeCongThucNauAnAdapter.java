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
import com.cntt.homecooking.activities.DetailActivity;
import com.cntt.homecooking.activities.DetailFormulaActivity;
import com.cntt.homecooking.model.CongThucNauAn;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeCongThucNauAnAdapter extends RecyclerView.Adapter<HomeCongThucNauAnAdapter.CongThucNauAnViewHolder>{
    private List<CongThucNauAn> congThucNauAnList;
    private Context context;

    public HomeCongThucNauAnAdapter(List<CongThucNauAn> congThucNauAnList, Context context) {
        this.congThucNauAnList = congThucNauAnList;
        this.context = context;
    }

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

    // Giới hạn số lượng hiển thị
    private int limit=5;

    @Override
    public int getItemCount() {
        if (congThucNauAnList.size()>limit){
            return limit;
        }
        return congThucNauAnList.size();

//        if(congThucNauAnList!=null){
//            return congThucNauAnList.size();
//        }
//        return 0;
    }

    public class CongThucNauAnViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtTencongthucnauan;
        private ImageView imgHinhcongthucnauan;


        public CongThucNauAnViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTencongthucnauan=itemView.findViewById(R.id.popularName);
            imgHinhcongthucnauan=itemView.findViewById(R.id.ItemProductPic);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, DetailActivity.class);

            intent.putExtra("tenCongThuc",congThucNauAnList.get(position).getTenCongThuc());
            intent.putExtra("moTaMonAn",congThucNauAnList.get(position).getMoTaMonAn());
            intent.putExtra("linkVideo",congThucNauAnList.get(position).getLinkVideo());
            intent.putExtra("linkHinhAnh",congThucNauAnList.get(position).getLinkHinhAnh());
            context.startActivity(intent);
        }
    }
}
