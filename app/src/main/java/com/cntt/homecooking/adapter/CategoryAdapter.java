package com.cntt.homecooking.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.cntt.homecooking.R;
import com.cntt.homecooking.model.Category;
import com.cntt.homecooking.model.DetailCategory;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private ArrayList<Category> alCategory;
    private Context context;
    private ConstraintLayout layoutItemCat;


    public CategoryAdapter(ArrayList<Category> alCategory, Context context) {
        this.alCategory = alCategory;
        this.context = context;

    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        holder.categoryName.setText(String.valueOf(alCategory.get(position).getTenTheLoai()));
//        holder.categoryPic.setImageResource(Byte.valueOf(alCategory.get(position).getHinhAnhLoai()));

    }

    @Override
    public int getItemCount() {
        return alCategory.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView categoryName;
        public ImageView categoryPic;
        public ConstraintLayout layoutItemCat;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            layoutItemCat = itemView.findViewById(R.id.itemt_cat_layout);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context,DetailCategory.class);
            int position = getAdapterPosition();
            Toast.makeText(context, "name"+alCategory.get(position).getTenTheLoai(), Toast.LENGTH_LONG).show();
            context.startActivity(intent);
        }
    }
}
