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

import com.cntt.homecooking.activities.DetailFormulaActivity;
import com.cntt.homecooking.R;
import com.cntt.homecooking.model.Formula;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FormulaAdapter extends RecyclerView.Adapter<FormulaAdapter.FormulaViewHolder> implements Filterable {

    private List<com.cntt.homecooking.model.Formula> mListFormula;
    private List<com.cntt.homecooking.model.Formula> alFormula;

    private Context context;

    public FormulaAdapter(ArrayList<Formula> alFormula, Context context) {
        this.alFormula = alFormula;
        this.mListFormula = alFormula;
        this.context = context;
    }

    @NonNull
    @Override
    public FormulaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.formula_item, parent, false);

        return new FormulaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FormulaViewHolder holder, int position) {
        holder.formulaName.setText(String.valueOf(alFormula.get(position).getTenCongThuc()));
//        holder.formulaPic.setImageResource(Integer.valueOf(alFormula.get(position).getHinhAnh()));

        if(!alFormula.get(position).getHinhAnh().isEmpty()){
            Picasso.get()
                    .load(alFormula.get(position).getHinhAnh())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(holder.formulaPic);
        }
    }

    @Override
    public int getItemCount() {
        if(alFormula!=null){
            return alFormula.size();
        }
        return 0;
    }



    public class FormulaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView formulaName;
        public ImageView formulaPic;

        public FormulaViewHolder(@NonNull View itemView) {
            super(itemView);

            formulaName = itemView.findViewById(R.id.formulaName);
            formulaPic = itemView.findViewById(R.id.formulaPic);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
//            Toast.makeText(context, "position"+position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, DetailFormulaActivity.class);
            intent.putExtra("name",alFormula.get(position).getTenCongThuc());
            intent.putExtra("CTCB",alFormula.get(position).getCTCB());
            intent.putExtra("thanhphan",alFormula.get(position).getThanhPhan());
            intent.putExtra("hinhanh",alFormula.get(position).getHinhAnh());

            context.startActivity(intent);
        }
    }

    //Thanh Search Công Thức

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                List<Formula> list = new ArrayList<>();
                if(strSearch.isEmpty()){
                    list.addAll(mListFormula);
                }  else{

                    for (Formula formula : mListFormula){
                        if(formula.getTenCongThuc().toLowerCase().contains(strSearch.toString().toLowerCase().trim())){
                            list.add(formula);
                        }
                    }
                    alFormula = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = alFormula;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                alFormula = (List<Formula>) results.values;
                notifyDataSetChanged();
            }
        };
    }

}
