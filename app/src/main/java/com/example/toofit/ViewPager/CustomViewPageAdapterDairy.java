package com.example.toofit.ViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.toofit.R;

public class CustomViewPageAdapterDairy extends FragmentStateAdapter {

    public CustomViewPageAdapterDairy(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return PicExamplesFragment.newInstance(R.drawable.cheese);
            case 1:
                return PicExamplesFragment.newInstance(R.drawable.yogurt);
            case 2:
                return PicExamplesFragment.newInstance(R.drawable.milk);
            default:
                return PicExamplesFragment.newInstance(R.drawable.ic_baseline_error_24);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}