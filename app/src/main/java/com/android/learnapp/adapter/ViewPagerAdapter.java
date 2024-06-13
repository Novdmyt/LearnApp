package com.android.learnapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.android.learnapp.fragment.AddFragment;
import com.android.learnapp.fragment.CreateFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new CreateFragment();
            case 1:
                return new AddFragment();
            case 2:
              //  return new LearnWordsFragment();
            case 3:
              //  return new DictionaryFragment();
            default:
                return new CreateFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4; // кількість вкладок
    }
}
