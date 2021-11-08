package com.cntt.homecooking.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.cntt.homecooking.Formula;
import com.cntt.homecooking.Home;
import com.cntt.homecooking.Liked;
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
                return new Formula();

            case 2:
                return new Liked();

            case 3:
                return  new Me();

            default:
                return new Home();

        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
