package com.example.tela2;

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

    public void Voltar(View v){
        Intent it = getIntent();
        Double taxa;

        Double valorPeso = Double.parseDouble(it.getStringExtra("peso"));
        Double valorCopos = Double.parseDouble(it.getStringExtra("copos"));

        if(it.getStringExtra("jejum").equals("s")){
            if(it.getStringExtra("sexo") == "f") {
                taxa = (valorCopos * 4.8) / (valorPeso * 0.6);
            }else{
                taxa = (valorCopos * 4.8) / (valorPeso * 0.7);
            }
        } else {
            taxa = (valorCopos * 4.8) / (valorPeso * 1.1);
        }

        Intent it2 = new Intent();
        if(taxa > 0.0) {
            it2.putExtra("msg1", "Taxa de Alcoolemia:" + String.valueOf(taxa));
            it2.putExtra("msg2","Classificação: Pessoa Alcoolizada");
        }
        else {
            it2.putExtra("msg1", "Taxa de Alcoolemia:" + String.valueOf(taxa));
            it2.putExtra("msg2","Classificação: Pessoa NÃO Alcoolizada");
        }

        setResult(1,it2);

        finish();
    }
}