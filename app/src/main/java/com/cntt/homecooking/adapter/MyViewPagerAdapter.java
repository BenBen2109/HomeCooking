package com.cntt.homecooking.adapter;

import static androidx.viewpager.widget.PagerAdapter.POSITION_NONE;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.cntt.homecooking.Cart;
import com.cntt.homecooking.Formula;
import com.cntt.homecooking.Home;
import com.cntt.homecooking.Product;
import com.cntt.homecooking.Me;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Home();

            case 1:
                return new Product();

            case 2:
                return new Formula();

            case 3:
                return new Cart();

            case 4:
                return  new Me();

            default:
                return new Home();

        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

}
