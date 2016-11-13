package com.example.alyson.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Confirmacao extends AppCompatActivity {

    ListView listaPedidos;
    ArrayList<String> arrayListNomePedidos = new ArrayList<>();
    ArrayList<Integer> arrayListPrecoPedidos = new ArrayList<>();
    Button btnPagar;

    EditText txtTotal;
    public int total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);
        listaPedidos = (ListView) findViewById(R.id.listPedidos);
        txtTotal = (EditText) findViewById(R.id.txtTotal);
        btnPagar = (Button) findViewById(R.id.btnPagar);

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

        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPagar = new Intent(getApplicationContext(),Pagamento.class);
                intentPagar.putExtra("valorTotal", String.valueOf(total));
                startActivity(intentPagar);
            }
        });






        }}




