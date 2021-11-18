package com.cntt.homecooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.cntt.homecooking.adapter.MyViewPagerAdapter;
import com.cntt.homecooking.model.Formula;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ViewPager2 mViewpager2;
    private BottomNavigationView mBottomNavigationView;
    private ArrayList<Formula> alFormula;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        mViewpager2 = findViewById(R.id.view_pager_2);
        mBottomNavigationView = findViewById(R.id.bottomNavigationView);

        mViewpager2.setUserInputEnabled(false);
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(this);
        mViewpager2.setAdapter(myViewPagerAdapter);
        mBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.action_home){
                    mViewpager2.setCurrentItem(0);
                }
                else if(id == R.id.action_product){
                    mViewpager2.setCurrentItem(1);
                }
                else if(id == R.id.action_formula){
                    mViewpager2.setCurrentItem(2);
                }
                else if(id == R.id.action_cart){
                    mViewpager2.setCurrentItem(3);
                }
                else if(id == R.id.action_me){
                    mViewpager2.setCurrentItem(4);
                }

                return true;
            }
        });
        mViewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        mBottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;

                    case 1:
                        mBottomNavigationView.getMenu().findItem(R.id.action_product).setChecked(true);
                        break;

                    case 2:
                        mBottomNavigationView.getMenu().findItem(R.id.action_formula).setChecked(true);
                        break;

                    case 3:
                        mBottomNavigationView.getMenu().findItem(R.id.action_cart).setChecked(true);
                        break;

                    case 4:
                        mBottomNavigationView.getMenu().findItem(R.id.action_me).setChecked(true);
                        break;
                }
            }
        });

    }


}