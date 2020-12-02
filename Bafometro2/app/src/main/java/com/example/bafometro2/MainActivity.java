package com.example.bafometro2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Enviar(View v){

        EditText valorPeso = findViewById(R.id.EditPeso);
        EditText valorSexo = findViewById(R.id.EditSexo);
        EditText valorCopos = findViewById(R.id.EditCopos);
        EditText valorJejum = findViewById(R.id.EditJejum);

        Intent it = new Intent("ACAO_DESEJADA");

        it.putExtra("peso", valorPeso.getText().toString());
        it.putExtra("sexo",valorSexo.getText().toString());
        it.putExtra("copos",valorCopos.getText().toString());
        it.putExtra("jejum",valorJejum.getText().toString());

        startActivityForResult(it,10);
    }

    protected void onActivityResult(int codigoRequisicao, int codigoResultado, Intent it ) {
        super.onActivityResult(codigoRequisicao, codigoResultado, it);
        if(it == null){
            Toast.makeText(this, "NENHUM VALOR!", Toast.LENGTH_SHORT).show();
            return;
        } else if(codigoRequisicao == 10){
            String msg1 = it.getStringExtra("msg1");
            String msg2 = it.getStringExtra("msg2");
            if(codigoResultado == 1){
                Toast.makeText(this, msg1+ "\n" + msg2,Toast.LENGTH_SHORT).show();
            }
        }
    }
}