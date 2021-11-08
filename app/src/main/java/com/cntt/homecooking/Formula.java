package com.cntt.homecooking;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import com.cntt.homecooking.adapter.FormulaAdapter;
import com.cntt.homecooking.adapter.PopularAdapter;
import com.cntt.homecooking.db.DBManager;
import com.cntt.homecooking.db.DBManagerDAO;
import com.cntt.homecooking.model.Category;
import com.cntt.homecooking.model.Popular;
import android.app.SearchManager;
import android.widget.SearchView.OnQueryTextListener;
import java.util.ArrayList;
import java.util.List;


public class Formula extends Fragment{
    private androidx.appcompat.widget.SearchView formula_search;
    private RecyclerView rclFormula;
    private FormulaAdapter formulaAdapter;
    private ArrayList<com.cntt.homecooking.model.Formula> alFormula;
    private RecyclerView rclPopularList;
    private Context mContext;
    public DBManagerDAO dbManagerDAO;
    public DBManager dbManager;

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
    }

    private View mView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_formula, container, false);

        formula_search= mView.findViewById(R.id.formula_search);

        formula_search.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                formulaAdapter.getFilter().filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                formulaAdapter.getFilter().filter(newText);
                return true;
            }
        });


        dbManager = new DBManager(mView.getContext());
        setHasOptionsMenu(true);
        alFormula = dbManager.getAllFormula();
        formulaAdapter = new FormulaAdapter(alFormula, mContext);
        rclFormula = (RecyclerView) mView.findViewById(R.id.rcl_formula);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rclFormula.setLayoutManager(linearLayoutManager1);
        rclFormula.setAdapter(formulaAdapter);


        return mView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext=context;
    }
}