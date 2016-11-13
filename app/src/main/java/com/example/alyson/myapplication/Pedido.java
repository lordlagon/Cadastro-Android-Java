package com.example.alyson.myapplication;

/**
 * Created by Alyson on 13/11/2016.
 */

public class Pedido extends Produto {

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    private int idPedido;

    @Override
    public String toString() {
        return String.valueOf(idPedido + " - Cliente: "+ getNome() +"  Valor: R$ "+ getPreco()+",00");
    }
}
