package com.alex.calculadorapuntosdeencuentros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText velocidad1;
    private EditText distancia_total;
    private EditText velocidad2;
    private TextView tiempo_encuentro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        velocidad1 = (EditText) findViewById(R.id.edtvelocidad3);
        velocidad2 = (EditText) findViewById(R.id.edtvelocidad4);
        distancia_total = (EditText) findViewById(R.id.edtdistancia);
        tiempo_encuentro = (TextView) findViewById(R.id.tv_tiempototal);
    }
    public void calcularDistancia(View view) {
        String valor1 = velocidad1.getText().toString();
        String valor2 = velocidad2.getText().toString();
        String valor3 = distancia_total.getText().toString();

        int velocidad1 = Integer.parseInt(valor1);
        int velocidad2 = Integer.parseInt(valor2);
        int distancia = Integer.parseInt(valor3);

        //Calcular TiempoEncuentro
        int calculartiempo = distancia / (velocidad1 + velocidad2);
        String resutiempo = String.valueOf(calculartiempo);
        //Calcular Distancia1
        int calculardistancia1 = velocidad1 * calculartiempo;
        String resudistanc1 = String.valueOf(calculardistancia1);
        //Calculadr Distancia2
        int calculardistancia2 = velocidad2 * calculartiempo;
        String resudistanc2 = String.valueOf(calculardistancia2);


        //Enviar datos a otro activity
        Intent i = new Intent(MainActivity.this, calcular_punto_encuentro.class);
        i.putExtra("tiempo_punto_encuentro", resutiempo);
        i.putExtra("distancia_vehiculo_1", resudistanc1);
        i.putExtra("distancia_vehiculo_2", resudistanc2);

        startActivity(i);
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