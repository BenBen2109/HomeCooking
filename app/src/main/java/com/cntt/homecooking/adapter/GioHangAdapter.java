package com.cntt.homecooking.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.cntt.homecooking.Cart;
import com.cntt.homecooking.R;
import com.cntt.homecooking.activities.DetailProduct;
import com.cntt.homecooking.model.GioHang;
import com.squareup.picasso.Picasso;


import java.text.DecimalFormat;
import java.util.List;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.GioHangViewHolder>{
    private List<GioHang> gioHangList;
    private ViewBinderHelper viewBinderHelper=new ViewBinderHelper();
    private Context context;

    public GioHangAdapter(List<GioHang> gioHangList, Context context) {
        this.gioHangList = gioHangList;
        this.context = context;
    }

    @NonNull
    @Override
    public GioHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart,parent,false);
        return new GioHangAdapter.GioHangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GioHangViewHolder holder, int position) {
        GioHang gioHang=gioHangList.get(position);
        if(gioHang==null){
            return;
        }
        viewBinderHelper.bind(holder.swipeRevealLayout, gioHang.getIdFood());


        holder.txttensanpham.setText(gioHang.getNameFood());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        holder.txtgiasanpham.setText(gioHang.getPrice()+" đ");
        holder.txtsoluong.setText(""+gioHang.getSoluong());
        if(!gioHang.getLinkHinhAnh().isEmpty()){
            Picasso.get()
                    .load(gioHang.getLinkHinhAnh())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .fit()
                    .into(holder.imghinhsanpham);
        }
        holder.layoutDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               xoasanpham(holder);
            }
        });
    }

    private void xoasanpham(GioHangViewHolder holder) {
        AlertDialog.Builder alertdialog=new AlertDialog.Builder(context);
        alertdialog.setTitle("Xóa sản phẩm");
        alertdialog.setMessage("Bạn có chắc muốn xóa sản phẩm này trong giỏ hàng không?");
        alertdialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                gioHangList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });

        alertdialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertdialog.show();
    }

    @Override
    public int getItemCount() {
        if(gioHangList!=null){
            return gioHangList.size();
        }
        return 0;
    }

    public class GioHangViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txttensanpham,txtgiasanpham;
        private TextView txtsoluong;
        private ImageView imghinhsanpham;
        private SwipeRevealLayout swipeRevealLayout;
        private LinearLayout layoutDelete;

        public GioHangViewHolder(@NonNull View itemView) {
            super(itemView);
            txttensanpham=itemView.findViewById(R.id.popularName);
            txtgiasanpham=itemView.findViewById(R.id.popularGia);
            txtsoluong=itemView.findViewById(R.id.popularSoLuong);
            imghinhsanpham=itemView.findViewById(R.id.ItemProductPic);
            swipeRevealLayout=itemView.findViewById(R.id.swipeRevealLayout);
            layoutDelete=itemView.findViewById(R.id.layoutDelete);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, DetailProduct.class);
            intent.putExtra("idFood",gioHangList.get(position).getIdFood());
            intent.putExtra("nameFood",gioHangList.get(position).getNameFood());
            intent.putExtra("price",gioHangList.get(position).getPrice());
            intent.putExtra("linkHinhAnh",gioHangList.get(position).getLinkHinhAnh());
            intent.putExtra("donViTinh",gioHangList.get(position).getDonViTinh());

            context.startActivity(intent);
        }
    }
}
