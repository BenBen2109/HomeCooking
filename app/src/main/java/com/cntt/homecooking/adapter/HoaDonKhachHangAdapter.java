package com.cntt.homecooking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cntt.homecooking.R;
import com.cntt.homecooking.model.HoaDonKhachHang;

import java.util.List;

public class HoaDonKhachHangAdapter extends RecyclerView.Adapter<HoaDonKhachHangAdapter.LichSuHoaDonViewHolder> {

    private List<HoaDonKhachHang> mHoaDonKhachHangs;
    private Context mcContext;

    public HoaDonKhachHangAdapter(List<HoaDonKhachHang> mHoaDonKhachHangs, Context mcContext) {
        this.mHoaDonKhachHangs = mHoaDonKhachHangs;
        this.mcContext = mcContext;
    }

    @NonNull
    @Override
    public HoaDonKhachHangAdapter.LichSuHoaDonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lichsuhoadon,parent,false);
        return new LichSuHoaDonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LichSuHoaDonViewHolder holder, int position) {

        HoaDonKhachHang hoaDonKhachHang = mHoaDonKhachHangs.get(position);
        if(mHoaDonKhachHangs == null){
            return;
        }
        holder.id_HoaDon.setText(hoaDonKhachHang.getIdInvoice());
        holder.pttt.setText(hoaDonKhachHang.getPhuongThucThanhToan());
        holder.status.setText(hoaDonKhachHang.getStatus());
        holder.tongtien.setText(hoaDonKhachHang.getTongTien()+" đ");

    }

    @Override
    public int getItemCount() {
        if(mHoaDonKhachHangs!=null){
            return mHoaDonKhachHangs.size();
        }
        return 0;
    }

    public class LichSuHoaDonViewHolder extends RecyclerView.ViewHolder{

        private TextView id_HoaDon,tongtien,pttt,status;

        public LichSuHoaDonViewHolder(@NonNull View itemView) {
            super(itemView);

            id_HoaDon=itemView.findViewById(R.id.id_HoaDon);
            tongtien=itemView.findViewById(R.id.tongtien);
            pttt=itemView.findViewById(R.id.pttt);
            status=itemView.findViewById(R.id.status);
        }
    }
}
