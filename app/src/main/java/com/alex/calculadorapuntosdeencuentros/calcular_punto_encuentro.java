package com.alex.calculadorapuntosdeencuentros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class calcular_punto_encuentro extends AppCompatActivity {
    private TextView resultado_tiempo_encuentro;
    private TextView resultado_distancia1;
    private TextView resultado_distancia2;
    private TextView vehiculo1;
    private TextView vehiculo2;
    private TextView tiempo_vehiculo1, tiempo_vehiculo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_punto_encuentro);
        resultado_tiempo_encuentro = (TextView) findViewById(R.id.tv_tiempototal);
        resultado_distancia1 = (TextView) findViewById(R.id.tv_distancia1);
        resultado_distancia2 = (TextView) findViewById(R.id.tv_distancia2);
        vehiculo1 = (TextView) findViewById(R.id.tv_vehiculo1);
        vehiculo2 = (TextView) findViewById(R.id.tv_vehiculo2);
        tiempo_vehiculo1 = (TextView) findViewById(R.id.tv_tiempo1);
        tiempo_vehiculo2 = (TextView) findViewById(R.id.tv_tiempo2);


        //Calcular Círculo
        String tiempo_total = getIntent().getStringExtra("tiempo_punto_encuentro");
        resultado_tiempo_encuentro.setText("Tiempo de punto de encuentro: " + tiempo_total + " Horas");

        String distancia1 = getIntent().getStringExtra("distancia_vehiculo_1");
        resultado_distancia1.setText(distancia1 + " Km/h");
        String distancia2 = getIntent().getStringExtra("distancia_vehiculo_2");
        resultado_distancia2.setText(distancia2 + " Km/h");

        String nombre1 = getIntent().getStringExtra("nombre_vehiculo1");
        vehiculo1.setText("Distancia de " + nombre1);
        String nombre2 = getIntent().getStringExtra("nombre_vehiculo2");
        vehiculo2.setText("Distancia de " + nombre2);

        String tiempo1 = getIntent().getStringExtra("tiempo_vehiculo_1");
        tiempo_vehiculo1.setText("Tiempo de viaje para el encuentro: " + tiempo1 + "Horas");
        String tiempo2 = getIntent().getStringExtra("tiempo_vehiculo_2");
        tiempo_vehiculo2.setText("Tiempo de viaje para el encuentro: " + tiempo2 + "Horas");

    }
}