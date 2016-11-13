package com.example.alyson.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pagamento extends AppCompatActivity {

    String valorTotal;
    EditText txtvalor;
    EditText txtNome;




    Button btnPagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        valorTotal = getIntent().getStringExtra("valorTotal");
        txtvalor = (EditText) findViewById(R.id.txtValorTotal);
        txtvalor.setText("R$ "+valorTotal+",00");

        btnPagar = (Button) findViewById(R.id.btnPagar);
        txtNome = (EditText) findViewById(R.id.txtNomeCliente);
        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Pedido pedido = new Pedido();
                pedido.setNome(txtNome.getText().toString());
                pedido.setPreco(Integer.valueOf(valorTotal));
                BancoDeDados banco = new BancoDeDados(getApplicationContext());
                banco.gravar(pedido);
                Toast.makeText(getApplicationContext(), "Pedido Gravado", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),Cardapio.class);
                startActivity(intent);
                finish();



            }
        });


    }


}
