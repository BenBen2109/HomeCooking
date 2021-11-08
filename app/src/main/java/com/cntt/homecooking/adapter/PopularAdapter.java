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

import com.cntt.homecooking.activities.DetailActivity;
import com.cntt.homecooking.R;
import com.cntt.homecooking.model.Popular;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder>{

    private ArrayList<Popular> alPopular;
    private Context context;

    public PopularAdapter(ArrayList<Popular> alPopular, Context context) {
        this.alPopular = alPopular;
        this.context = context;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.popular_item, parent, false);

        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {
            holder.popularName.setText(String.valueOf(alPopular.get(position).getTenCongThuc()));
//            holder.popularPic.setImageResource(byte.valueOf(alPopular.get(position).getHinhAnh()));
        if(!alPopular.get(position).getHinhAnh().isEmpty()){
            Picasso.get()
                    .load(alPopular.get(position).getHinhAnh())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(holder.popularPic);
        }
    }

    private final int limit = 30;


    @Override
    public int getItemCount() {
        if(alPopular.size() > limit){
            return limit;
        }
        else
        {
            return alPopular.size();
        }
    }

    public class PopularViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView popularName;
        public ImageView popularPic;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);

            popularName = itemView.findViewById(R.id.popularName);
            popularPic = itemView.findViewById(R.id.popularPic);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
//            Toast.makeText(context, "name"+alPopular.get(position).getTenCongThuc(), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("idcongthuc",alPopular.get(position).getIdCongThuc());
            intent.putExtra("tencongthuc",alPopular.get(position).getTenCongThuc());
            intent.putExtra("CTCB",alPopular.get(position).getCTCB());
            intent.putExtra("hinhanh",alPopular.get(position).getHinhAnh());
            intent.putExtra("thanhphan",alPopular.get(position).getThanhPhan());
            intent.putExtra("type",1);
            context.startActivity(intent);
        }
    }
}
