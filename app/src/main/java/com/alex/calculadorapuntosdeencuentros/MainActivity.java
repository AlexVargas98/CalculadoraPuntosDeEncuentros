package com.alex.calculadorapuntosdeencuentros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lista(View v) {
        Intent i = new Intent(this, lista_puntoencuentro.class);
        startActivity(i);
    }

    public void calcular(View v) {
        Intent i = new Intent(this, calcular_punto_encuentro.class);
        startActivity(i);
    }

}