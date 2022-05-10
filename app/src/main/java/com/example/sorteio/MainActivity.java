package com.example.sorteio;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void sortearNumeros (View view){

        //VARIAVEIS DE CONTROLE
        int min = 1; //Valor minimo sorteado
        int max = 60; //Valor maximo sorteado
        int n = 6; //Qtd de numeros sorteados

        //DECLARAÇÕES
        List v = new ArrayList(); //Declaração e alocação de espaço da lista "v"
        String vstring[] = new String[n]; //Declaração e alocação do vetor "vstring"
        int i; //indice

        //PROCESSANDO OS N ELEMENTOS DO VETOR
        while (v.size() < n) {
            //GERANDO NUMERO RANDOMICO DENTRO DO RANGE MAX E MIN
            int  numero = new Random().nextInt(((max - min)+1))+ min;
            //EVITANDO NUMEROS REPETIDOS
            if (!v.contains(numero)){
                v.add(numero);
            }
        }

        //ORDENANDO OS NUMEROS
        Collections.sort(v);


        //TRANSFORMANDO LIST EM STRING
        TextView texto = findViewById(R.id.listText);
        StringBuilder str = new StringBuilder();
        for (Object vstr : v) {
            str.append(vstr);
            str.append("  ");
        }

        //ATRIBUINDO AO CAMPO DE TEXTVIEW
        texto.setText(str);

    }
}