package com.cntt.homecooking.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cntt.homecooking.DetailActivity;
import com.cntt.homecooking.DetailLikedActivity;
import com.cntt.homecooking.R;
import com.cntt.homecooking.db.DBManager;
import com.cntt.homecooking.model.LikedModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LikedAdapter extends RecyclerView.Adapter<LikedAdapter.viewholder>{

    ArrayList<LikedModel> list;
    Context context;

    public LikedAdapter(ArrayList<LikedModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.liked_item,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final LikedModel model = list.get(position);
//        if(!list.get(position).getHinhAnh().isEmpty()){
//            Picasso.get()
//                    .load(list.get(position).getHinhAnh())
//                    .placeholder(R.drawable.loading)
//                    .error(R.drawable.error)
//                    .into(holder.likedfoodPic);
//        }
        holder.likedfoodName.setText(list.get(position).getTenCongThuc());


        holder.deleteLiked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Xóa công thức ?")
                        .setMessage("Bạn muốn xóa món ăn khỏi danh sách ?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DBManager db = new DBManager(context);
                                if(db.deleteLiked(model.getSoLiked()) > 0){
                                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(context, "Lỗi", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView likedfoodPic;
        TextView likedfoodName,likedNumber;
        TextView deleteLiked,detaillikedfoodName;


        public viewholder(@NonNull View itemView) {
            super(itemView);
            likedfoodPic = itemView.findViewById(R.id.likedfoodPic);
            deleteLiked = itemView.findViewById(R.id.deleteLiked);
            likedfoodName = itemView.findViewById(R.id.likedName);
            detaillikedfoodName = itemView.findViewById(R.id.detaillikedfoodName);




            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {



            int position = getAdapterPosition();
            Intent intent = new Intent(context, DetailLikedActivity.class);
            intent.putExtra("tencongthuc",list.get(position).getTenCongThuc());
            intent.putExtra("CTCB",list.get(position).getCTCB());
            intent.putExtra("thanhphan",list.get(position).getThanhPhan());


            context.startActivity(intent);
        }
    }
}
