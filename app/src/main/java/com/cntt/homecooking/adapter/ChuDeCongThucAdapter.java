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
import com.cntt.homecooking.model.ChuDeCongThuc;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChuDeCongThucAdapter extends RecyclerView.Adapter<ChuDeCongThucAdapter.ChuDeCongThucViewHolder>{
    private List<ChuDeCongThuc> chuDeCongThucList;
    private Context context;

    public ChuDeCongThucAdapter(List<ChuDeCongThuc> chuDeCongThucList, Context context) {
        this.chuDeCongThucList = chuDeCongThucList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChuDeCongThucViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.formula_cate_item,parent,false);
        return new ChuDeCongThucAdapter.ChuDeCongThucViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChuDeCongThucViewHolder holder, int position) {
        ChuDeCongThuc chuDeCongThuc=chuDeCongThucList.get(position);
        if (chuDeCongThuc==null){
            return;
        }
        holder.txtChuDeCongThuc.setText(chuDeCongThuc.getTenChuDe());
        if(!chuDeCongThuc.getLinkHinhAnh().isEmpty()){
            Picasso.get()
                    .load(chuDeCongThuc.getLinkHinhAnh())
                    .error(R.drawable.error)
                    .placeholder(R.drawable.loading)
                    .fit()
                    .into(holder.imgChuDeCongThuc);
        }
    }

    @Override
    public int getItemCount() {
        if(chuDeCongThucList!=null){
            return chuDeCongThucList.size();
        }
        return 0;
    }

    public class ChuDeCongThucViewHolder extends RecyclerView.ViewHolder{
        private TextView txtChuDeCongThuc;
        private ImageView imgChuDeCongThuc;

        public ChuDeCongThucViewHolder(@NonNull View itemView) {
            super(itemView);
            txtChuDeCongThuc=itemView.findViewById(R.id.categoryName);
            imgChuDeCongThuc=itemView.findViewById(R.id.categoryPic);
        }
    }
}
