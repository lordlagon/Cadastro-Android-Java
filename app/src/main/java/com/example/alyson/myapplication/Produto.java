package com.example.alyson.myapplication;

import java.io.Serializable;

/**
 * Created by Alyson on 13/11/2016.
 */

public class Produto implements Serializable {



    private int idProduto;
    private int capas;
    private String nome;
    private Integer preco;


    public int getCapas() {
        return capas;
    }


    public void setCapas(int capas) {
        this.capas = capas;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public Integer getPreco() {
        return preco;
    }


    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

}
