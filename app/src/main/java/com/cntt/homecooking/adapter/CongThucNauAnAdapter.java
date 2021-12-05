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
import androidx.recyclerview.widget.RecyclerView;

import com.cntt.homecooking.R;
import com.cntt.homecooking.activities.DetailActivity;
import com.cntt.homecooking.model.CongThucNauAn;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CongThucNauAnAdapter extends RecyclerView.Adapter<CongThucNauAnAdapter.CongThucNauAnViewHolder> implements Filterable {

    private List<CongThucNauAn> congThucNauAnList;
    private List<CongThucNauAn> congThucNauAnListold;
    private Context context;

    public CongThucNauAnAdapter(List<CongThucNauAn> congThucNauAnList, Context context) {
        this.congThucNauAnList = congThucNauAnList;
        this.congThucNauAnListold = congThucNauAnList;
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

    @Override
    public int getItemCount() {
        if(congThucNauAnList!=null){
            return congThucNauAnList.size();
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
                    congThucNauAnList=congThucNauAnListold;
                }
                else {
                    List<CongThucNauAn> list=new ArrayList<>();
                    for(CongThucNauAn congThucNauAn: congThucNauAnListold){
                        if(congThucNauAn.getTenCongThuc().contains(strSearch.toLowerCase())){
                            list.add(congThucNauAn);
                        }
                    }
                    congThucNauAnList=list;
                }
                FilterResults filterResults=new FilterResults();
                filterResults.values=congThucNauAnList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                congThucNauAnList=(List<CongThucNauAn>) filterResults.values;
                notifyDataSetChanged();
            }
        };
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

            intent.putExtra("idCongThuc",congThucNauAnList.get(position).getIdCongThuc());
            intent.putExtra("tenCongThuc",congThucNauAnList.get(position).getTenCongThuc());
            intent.putExtra("moTaMonAn",congThucNauAnList.get(position).getMoTaMonAn());
            intent.putExtra("linkVideo",congThucNauAnList.get(position).getLinkVideo());
            intent.putExtra("linkHinhAnh",congThucNauAnList.get(position).getLinkHinhAnh());
            context.startActivity(intent);
        }
    }
}
