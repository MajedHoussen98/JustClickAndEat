package ps.ns.just_click_and_eat.feature.menu.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import ps.ns.just_click_and_eat.feature.menu.Beverages;
import ps.ns.just_click_and_eat.feature.menu.GrilledMeat;
import ps.ns.just_click_and_eat.feature.menu.Salads;
import ps.ns.just_click_and_eat.feature.menu.Seafoof;
import ps.ns.just_click_and_eat.feature.menu.StartersMenu;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new StartersMenu();
                break;
            case 1:
                fragment = new Salads();
                break;
            case 2:

                fragment = new Seafoof();
                break;
            case 3:
                fragment = new GrilledMeat();
                break;
            case 4:
                fragment = new Beverages();
                break;
        }

        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Starters";
            case 1:
                return "Salads";
            case 2:
                return "Seafoof";
            case 3:
                return "Grilled Meat";
            case 4:
                return "Beverages";
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}