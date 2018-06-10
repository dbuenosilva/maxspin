package br.com.gwaya.maxspin.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Diego on 10/06/2018.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabTitulos;

    public MyFragmentPagerAdapter(FragmentManager fragmentManager, String[] mTabTitulos) {
        super(fragmentManager);
        this.mTabTitulos = mTabTitulos;
    }

    @Override
    public Fragment getItem(int position) {
/*
        switch (position) {
            case 0:
                //return new FragmentA();
            case 1:
             //   return new FragmentB();
            default:
                return null;
        }

*/
        return null;
    }

    @Override
    public int getCount() {
        return(this.mTabTitulos.length);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return(this.mTabTitulos[position]);
    }

}
