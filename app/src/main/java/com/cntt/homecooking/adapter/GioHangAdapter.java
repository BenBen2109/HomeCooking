package com.cntt.homecooking.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.cntt.homecooking.Cart;
import com.cntt.homecooking.R;
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
        holder.txtgiasanpham.setText((decimalFormat.format(gioHang.getPrice())+" đ"));
        holder.txtsoluong.setText(String.valueOf(gioHang.getSoluongmua()));
        if(!gioHang.getLinkHinhAnh().isEmpty()){
            Picasso.get()
                    .load(gioHang.getLinkHinhAnh())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .fit()
                    .into(holder.imghinhsanpham);
        }



        //Xóa sản phẩm
        holder.layoutDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               xoasanpham(holder);
            }
        });
        holder.txtsoluong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogSuasoluong(gioHang.getIdFood(), gioHang.getSoluongmua());
            }

            private void dialogSuasoluong(String idFood,int soluongmua) {
                Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.dialog_soluong);

                EditText edtSoluongmoi=(EditText) dialog.findViewById(R.id.edt_soluongmoi);
                Button btnDongy=(Button) dialog.findViewById(R.id.btn_dongy);
                Button btnHuy=(Button) dialog.findViewById(R.id.btn_huy);

                edtSoluongmoi.setText(String.valueOf(soluongmua));

                btnDongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (edtSoluongmoi.getText().toString().trim().equals("")){
                            Toast.makeText(context, "Vui lòng nhập số lượng", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            int soluongmuamoi=Integer.parseInt(edtSoluongmoi.getText().toString().trim());
                            if(soluongmuamoi==0){
                                xoasanpham(holder);
                                dialog.dismiss();
                            }
                            else {
                                int soluongmuahientai=gioHang.getSoluongmua();
                                int soluonghientai=gioHang.getSoluong();
                                int giahientai=gioHang.getPrice();
                                int soluong=soluonghientai/soluongmuahientai;
                                int dongia=giahientai/soluongmuahientai;
                                int giamoi=dongia*soluongmuamoi;
                                int soluongmoi=soluong*soluongmuamoi;
                                gioHang.setSoluongmua(soluongmuamoi);
                                gioHang.setPrice(giamoi);
                                gioHang.setSoluong(soluongmoi);
                                notifyDataSetChanged();
                                Cart.tinhtongtien();
                                dialog.dismiss();
                            }
                        }

                    }
                });

                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    private void xoasanpham(GioHangViewHolder holder) {
        AlertDialog.Builder alertdialog=new AlertDialog.Builder(context,R.style.AlertDialogStyle);
        alertdialog.setTitle("Xóa sản phẩm");
        alertdialog.setMessage("Bạn có chắc muốn xóa sản phẩm này trong giỏ hàng không?");
        alertdialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                gioHangList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                Cart.tinhtongtien();
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



    public class GioHangViewHolder extends RecyclerView.ViewHolder{
        private TextView txttensanpham,txtgiasanpham,txtsoluong;
        private ImageView imghinhsanpham;
        private SwipeRevealLayout swipeRevealLayout;
        private LinearLayout layoutDelete;

        public GioHangViewHolder(@NonNull View itemView) {
            super(itemView);
            txttensanpham=itemView.findViewById(R.id.cartName);
            txtgiasanpham=itemView.findViewById(R.id.cartPrice);
            txtsoluong=itemView.findViewById(R.id.cartSoLuong);
            imghinhsanpham=itemView.findViewById(R.id.cartPic);
            swipeRevealLayout=itemView.findViewById(R.id.swipeRevealLayout);
            layoutDelete=itemView.findViewById(R.id.layoutDelete);

        }
    }
}
