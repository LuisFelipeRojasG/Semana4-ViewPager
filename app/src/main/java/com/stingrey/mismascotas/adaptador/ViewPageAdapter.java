package com.stingrey.mismascotas.adaptador;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPageAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    ArrayList<String> fragmentTitulo = new ArrayList<>();

    public ViewPageAdapter(FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {

        return fragmentArrayList.size();
    }

    public void agregarFragment(Fragment fragment, String titulo){
        fragmentArrayList.add(fragment);
        fragmentTitulo.add(titulo);

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitulo.get(position);
    }
}
