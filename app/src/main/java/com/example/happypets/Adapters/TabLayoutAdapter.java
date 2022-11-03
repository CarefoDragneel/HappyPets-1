package com.example.happypets.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.happypets.Fragments.InfoFragment;
import com.example.happypets.Fragments.PetsFragment;
import com.example.happypets.Fragments.SearchFragment;
import com.example.happypets.R;

public class TabLayoutAdapter extends FragmentPagerAdapter {

    private Context context;

    public TabLayoutAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return new PetsFragment();
            case 2:
                return new InfoFragment();
            default:
                return new SearchFragment();

        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 1:
                return context.getString(R.string.pets_tab);
            case 2:
                return context.getString(R.string.info_tab);
            default:
                return context.getString(R.string.search_tab);

        }
    }
}
