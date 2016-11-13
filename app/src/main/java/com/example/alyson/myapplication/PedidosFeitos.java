package com.example.alyson.myapplication;



import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class PedidosFeitos extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<Pedido> adapter;
    List<Pedido> lista;
    BancoDeDados banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos_feitos);

        listView = (ListView) findViewById(R.id.lstPedidosFeitos);
        banco = new BancoDeDados(this);
        lista = banco.listar();

        int layout = android.R.layout.simple_list_item_1;
        adapter = new ArrayAdapter<>(this, layout, lista);
        listView.setAdapter(adapter);





    }




    public void onClickVoltar(View v) {
        finish();
    }
}
