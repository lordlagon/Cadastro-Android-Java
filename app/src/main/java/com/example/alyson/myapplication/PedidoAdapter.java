package com.example.alyson.myapplication;


import android.app.Activity;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.renderscript.Sampler.Value.valueOf;

public class PedidoAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> nomePedido;
    private final ArrayList<Integer> precoPedido;

    public PedidoAdapter(Activity context, ArrayList<String> nomePedido, ArrayList<Integer> precoPedido){

        super(context, R.layout.item_pedido,nomePedido);

        this.context = context;
        this.nomePedido = nomePedido;
        this.precoPedido = precoPedido;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView  = inflater.inflate(R.layout.item_pedido, null, true);

        TextView txtNomePedido = (TextView) rowView.findViewById(R.id.txtPedidoNome);
        TextView txtPrecoPedido = (TextView) rowView.findViewById(R.id.txtPedidoPreco);

        txtNomePedido.setText(nomePedido.get(position));
        txtPrecoPedido.setText("R$ "+String.valueOf(precoPedido.get(position))+",00");
        return rowView;

    }
}