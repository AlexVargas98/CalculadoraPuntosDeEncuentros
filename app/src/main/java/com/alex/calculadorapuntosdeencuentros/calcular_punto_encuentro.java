package com.alex.calculadorapuntosdeencuentros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class calcular_punto_encuentro extends AppCompatActivity {
    private TextView resultado_tiempo_encuentro;
    private TextView resultado_distancia1;
    private TextView resultado_distancia2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_punto_encuentro);
        resultado_tiempo_encuentro = (TextView) findViewById(R.id.tv_tiempototal);
        resultado_distancia1 = (TextView) findViewById(R.id.tv_distancia1);
        resultado_distancia2 = (TextView) findViewById(R.id.tv_distancia2);


        //Calcular Círculo
        String tiempo_total = getIntent().getStringExtra("tiempo_punto_encuentro");
        resultado_tiempo_encuentro.setText(tiempo_total);
        String distancia1 = getIntent().getStringExtra("distancia_vehiculo_1");
        resultado_distancia1.setText(distancia1);
        String distancia2 = getIntent().getStringExtra("distancia_vehiculo_2");
        resultado_distancia2.setText(distancia2);

    }
}