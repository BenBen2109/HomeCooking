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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.cntt.homecooking.Cart;
import com.cntt.homecooking.R;
import com.cntt.homecooking.model.GioHang;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class ThanhToanAdapter extends RecyclerView.Adapter<ThanhToanAdapter.ThanhToanViewHolder>{
    private List<GioHang> gioHangList;
    private Context context;

    public ThanhToanAdapter(List<GioHang> gioHangList, Context context) {
        this.gioHangList = gioHangList;
        this.context = context;
    }

    @NonNull
    @Override
    public ThanhToanAdapter.ThanhToanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thanhtoan,parent,false);
        return new ThanhToanAdapter.ThanhToanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThanhToanAdapter.ThanhToanViewHolder holder, int position) {
        GioHang gioHang = gioHangList.get(position);
        holder.txttensanpham.setText(gioHang.getNameFood());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgiasanpham.setText((decimalFormat.format(gioHang.getPrice()) + " đ"));
        holder.txtsoluong.setText(String.valueOf(gioHang.getSoluong()));
        if (!gioHang.getLinkHinhAnh().isEmpty()) {
            Picasso.get()
                    .load(gioHang.getLinkHinhAnh())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .fit()
                    .into(holder.imghinhsanpham);
        }

    }

    @Override
    public int getItemCount() {
        if(gioHangList!=null){
            return gioHangList.size();
        }
        return 0;
    }

    public class ThanhToanViewHolder extends RecyclerView.ViewHolder{

        private TextView txttensanpham,txtgiasanpham,txtsoluong;
        private ImageView imghinhsanpham;

        public ThanhToanViewHolder(@NonNull View itemView) {
            super(itemView);
            txttensanpham=itemView.findViewById(R.id.ttName);
            txtgiasanpham=itemView.findViewById(R.id.ttPrice);
            txtsoluong=itemView.findViewById(R.id.ttSoLuong);
            imghinhsanpham=itemView.findViewById(R.id.ttPic);
        }
    }
}

