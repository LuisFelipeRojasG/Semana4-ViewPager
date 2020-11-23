package com.stingrey.mismascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.stingrey.mismascotas.adaptador.ViewPageAdapter;
import com.stingrey.mismascotas.fragments.PerfilFragment;
import com.stingrey.mismascotas.fragments.RecyclerViewFragments;
import com.stingrey.mismascotas.menuOpciones.Activity_About;
import com.stingrey.mismascotas.menuOpciones.Activity_Contacto;

public class MainActivity extends AppCompatActivity {


    private Menu menu;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar actionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.tbBarraPrincipal);
        setSupportActionBar(actionBar);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setViewPaper(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        //Se agregan los iconos al tablayout
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        ImageView estrella = (ImageView) findViewById(R.id.blackStar);

        estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                irSegundaActividad();

            }
        });

    }

    public void setViewPaper(ViewPager viewPaper) {
       ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
       viewPageAdapter.agregarFragment(new RecyclerViewFragments(), "Home");
       viewPageAdapter.agregarFragment(new PerfilFragment(), "Profile");
       viewPaper.setAdapter(viewPageAdapter);

    }

    //Crear el menú de opciones en la barra principal
    public boolean onCreateOptionsMenu (Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);

        return true;
    }

    //Evento clic en las opciones del Menu
    public boolean onOptionsItemSelected (MenuItem item) {

        switch (item.getItemId()) {

            case R.id.imContacto:
                Intent intento = new Intent(this, Activity_Contacto.class);
                startActivity(intento);
                break;

            case R.id.imAcercaDe:
                Intent intento1 = new Intent(this, Activity_About.class);
                startActivity(intento1);
            break;

        }

        return super.onOptionsItemSelected(item);
    }


    private void setSupportActionBar(Toolbar miActionBar) {
    }


    public void irSegundaActividad (){
        Intent intento = new Intent(this, MascotasFavoritas.class);
        startActivity(intento);

    }

}