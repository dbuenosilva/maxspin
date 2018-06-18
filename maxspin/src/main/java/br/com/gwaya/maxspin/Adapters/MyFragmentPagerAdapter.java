package br.com.gwaya.maxspin.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.gwaya.maxspin.Fragments.ConfiguracoesFragment;
import br.com.gwaya.maxspin.Fragments.RotacoesFragment;

/**
 * Created by Diego on 10/06/2018.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabTitulos;

    public MyFragmentPagerAdapter(FragmentManager fragmentManager, String[] mTabTitulos) {
        super(fragmentManager);
        this.mTabTitulos = mTabTitulos;
    }

    // Define qual sera a Fragment de cada aba conforme a posição da aba
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new RotacoesFragment();
            case 1:
                return new ConfiguracoesFragment();
            default:
                return null;
        }

    }

    // Retorna quantos titulos/abas tem
    @Override
    public int getCount() {
        return(this.mTabTitulos.length);
    }

    // Obtem o nome da página e seta na Aba
    @Override
    public CharSequence getPageTitle(int position) {
        return(this.mTabTitulos[position]);
    }

}
