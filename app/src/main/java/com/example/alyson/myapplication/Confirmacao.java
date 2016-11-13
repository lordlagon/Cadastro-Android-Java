package com.example.alyson.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Confirmacao extends AppCompatActivity {

    ListView listaPedidos;
    ArrayList<String> arrayListNomePedidos = new ArrayList<>();
    ArrayList<Integer> arrayListPrecoPedidos = new ArrayList<>();

    EditText txtTotal;
    public int total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);
        listaPedidos = (ListView) findViewById(R.id.listPedidos);
        txtTotal = (EditText) findViewById(R.id.txtTotal);

        arrayListPrecoPedidos = getIntent().getIntegerArrayListExtra("listaPrecoPedidos");
        arrayListNomePedidos = getIntent().getStringArrayListExtra("listaNomePedidos");

        final PedidoAdapter adapter = new PedidoAdapter(this, arrayListNomePedidos,arrayListPrecoPedidos);
        listaPedidos.setAdapter(adapter);

        for (int i=0; i<arrayListPrecoPedidos.size();i++){
        total=total+(arrayListPrecoPedidos.get(i));
                }
        txtTotal.setText("R$ "+ String.valueOf(total)+",00");

        listaPedidos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                total = total - arrayListPrecoPedidos.get(position);

                txtTotal.setText("R$ "+ String.valueOf(total)+",00");

                arrayListNomePedidos.remove(position);
                arrayListPrecoPedidos.remove(position);

                adapter.notifyDataSetChanged();
            }
        });





        }}




