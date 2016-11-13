package com.example.alyson.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alyson on 13/11/2016.
 */

public class BancoDeDados extends SQLiteOpenHelper {

    public BancoDeDados(Context context) {
        super(context, "DBXZ", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE `produtos` (`id_produto`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,`nome_produto` TEXT NOT NULL, `preco` TEXT,`imagem`  TEXT)";
        db.execSQL(sql);
    }

          public void gravar(Produto produto){

        ContentValues valores = new ContentValues();
        valores.put("nome_produto", produto.getNome());
        valores.put("preco", produto.getPreco());


       //Carrega o banco SQLite;
        SQLiteDatabase db = getWritableDatabase();

        if (produto.getIdProduto() > 0){
            String id = String.valueOf(produto.getIdProduto());
            db.update("produtos", valores, "id_produto=?", new String[]{id});
        } else {
            db.insert("produtos", null, valores);
        }
        db.close();
    }
//
//    public void excluir(Pessoa pessoa){
//
//        String id = String.valueOf(pessoa.getId());
//        SQLiteDatabase db = getWritableDatabase();
//        db.delete("pessoas", "id=?", new String[]{id});
//        db.close();
//
//        //String sql = "delete from pessoas where id = " +  pessoa.getId();
//        //db.execSQL(sql);
//
//    }
    //}

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
