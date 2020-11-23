package com.stingrey.mismascotas.menuOpciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.stingrey.mismascotas.R;

public class Activity_About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__about);

        androidx.appcompat.widget.Toolbar aboutBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.aboutBar);
        setSupportActionBar(aboutBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}