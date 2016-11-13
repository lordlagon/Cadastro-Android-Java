package com.example.alyson.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Pagamento extends AppCompatActivity {

    ListView listaPedidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        listaPedidos = (ListView) findViewById(R.id.listPedido);
        ListAdapter adapter = (ListAdapter) findViewById()
    }


}
