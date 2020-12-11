package com.alex.calculadorapuntosdeencuentros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText velocidad1;
    private EditText distancia_total;
    private EditText velocidad2;
    private TextView tiempo_encuentro;
    private EditText edt1,edt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1= (EditText) findViewById(R.id.edt1);
        edt2= (EditText) findViewById(R.id.edt2);
        velocidad1 = (EditText) findViewById(R.id.edtvelocidad3);
        velocidad2 = (EditText) findViewById(R.id.edtvelocidad4);
        distancia_total = (EditText) findViewById(R.id.edtdistancia);
        tiempo_encuentro = (TextView) findViewById(R.id.tv_tiempototal);
    }
    public void calcularDistancia(View view) {

        if(validar()){

            String valor1 = velocidad1.getText().toString();
            String valor2 = velocidad2.getText().toString();
            String valor3 = distancia_total.getText().toString();

            int velocidad1 = Integer.parseInt(valor1);
            int velocidad2 = Integer.parseInt(valor2);
            int distancia = Integer.parseInt(valor3);

            if(velocidad1 >=0 && velocidad1 <=250 && velocidad2 >=0 && velocidad2 <=250 && distancia >=0 && distancia <=1000 ){

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
                i.putExtra("nombre_vehiculo1", edt1.getText().toString());
                i.putExtra("nombre_vehiculo2", edt2.getText().toString());
                startActivity(i);

            }else
            {
                Toast.makeText(this, "velocidad o distancia no valido, rango de velocidad entre 0 a 250, rando de distancia entre 0 a 1000 ",Toast.LENGTH_LONG).show();
            }

        }
    }

    public void lista(View v) {
        Intent i = new Intent(this, lista_puntoencuentro.class);
        startActivity(i);
    }
    public void formulas(View v) {
        Intent i = new Intent(this, Formulas.class);
        startActivity(i);
    }

    public void calcular(View v) {
        Intent i = new Intent(this, calcular_punto_encuentro.class);
        startActivity(i);
    }


    public boolean validar (){
        boolean retorno=true;
        String nombre1=edt1.getText().toString();
        String nombre2=edt2.getText().toString();
        String velo1=velocidad1.getText().toString();
        String velo2=velocidad2.getText().toString();
        String dist= distancia_total.getText().toString();

        if(nombre1.isEmpty()){
            edt1.setError("campo vacio");
            retorno=false;
        }
        if(nombre2.isEmpty()){
            edt2.setError("campo vacio");
            retorno=false;
        }
        if(velo1.isEmpty()){
            velocidad1.setError("campo vacio");
            retorno=false;
        }
        if(velo2.isEmpty()){
            velocidad2.setError("campo vacio");
            retorno=false;
        }
        if(dist.isEmpty()){
            distancia_total.setError("campo vacio");
            retorno=false;
        }

        return retorno;
    }

}