package com.example.alyson.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alyson on 13/11/2016.
 */

public class BancoDeDados extends SQLiteOpenHelper {

    public BancoDeDados(Context context) {
        super(context, "DBXZ", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE `pedidos` (`id_cliente` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,`nome_cliente` TEXT NOT NULL, `valor_total` TEXT)";
        db.execSQL(sql);
    }

          public void gravar(Pedido pedido){

        ContentValues valores = new ContentValues();
        valores.put("nome_cliente", pedido.getNome());
        valores.put("valor_total", pedido.getPreco());


       //Carrega o banco SQLite;
        SQLiteDatabase db = getWritableDatabase();

        if (pedido.getIdProduto() > 0){
            String id = String.valueOf(pedido.getIdProduto());
            db.update("pedidos", valores, "id_cliente=?", new String[]{id});
        } else {
            db.insert("pedidos", null, valores);
        }
        db.close();
    }

    public List<Pedido> listar(){


        List<Pedido> listaDePedidos = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("pedidos", null, null, null, null,null, null);


        while (cursor.moveToNext()){

            int idx0 = cursor.getColumnIndex("id_cliente");
            int idx1 = cursor.getColumnIndex("nome_cliente");
            int idx2 = cursor.getColumnIndex("valor_total");

            Pedido p = new Pedido();
            p.setIdPedido(cursor.getInt(idx0));
            p.setNome(cursor.getString(idx1));
            p.setPreco(cursor.getInt(idx2));

            listaDePedidos.add(p);
        }
        db.close();
        return listaDePedidos;
    }

   /** public void excluir(Pedido pedido) {

        String id = String.valueOf(pedido.getIdPedido());
        SQLiteDatabase db = getWritableDatabase();
        db.delete("pedidos", "id=?", new String[]{id});
        db.close();

        String sql = "delete from pedidos where id = " + pedido.getIdPedido();
        db.execSQL(sql);
    }**/


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
