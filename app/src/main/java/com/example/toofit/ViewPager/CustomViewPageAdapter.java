package com.example.toofit.ViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.toofit.R;

public class CustomViewPageAdapter extends FragmentStateAdapter {

    public CustomViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                 return PicExamplesFragment.newInstance(R.drawable.ic_launcher_background);
            case 1:
                return PicExamplesFragment.newInstance(R.drawable.ic_baseline_settings_24);
            case 2:
                return PicExamplesFragment.newInstance(R.drawable.ic_launcher_background);
            case 3:
                return PicExamplesFragment.newInstance(R.drawable.ic_baseline_settings_24);
            default:
                return PicExamplesFragment.newInstance(R.drawable.ic_launcher_background);
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}