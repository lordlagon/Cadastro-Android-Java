package com.example.alyson.myapplication;

    import android.content.Intent;
    import android.graphics.Color;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.MotionEvent;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.ListView;

    import java.util.ArrayList;


    public class Cardapio extends AppCompatActivity {



        ListView lstProdutos;

        ArrayList<String> arrayListNomePedidos = new ArrayList<>();
        ArrayList<Integer> arrayListPrecoPedidos = new ArrayList<>();
        ArrayList<Produto> listaDeProduto = new ArrayList<>();

        {
            Produto p1 = new Produto();
            p1.setNome("Burguer");
            p1.setPreco(5);
            p1.setCapas(R.drawable.hamburger);
            listaDeProduto.add(p1);

            Produto p2 = new Produto();
            p2.setNome("Bolo");
            p2.setPreco(7);
            p2.setCapas(R.drawable.bolo);
            listaDeProduto.add(p2);

            Produto p3 = new Produto();
            p3.setNome("Suco");
            p3.setPreco(8);
            p3.setCapas(R.drawable.sucos);
            listaDeProduto.add(p3);

    }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cardapio);


            lstProdutos = (ListView) findViewById(R.id.lstProdutos);
            CardapioAdapter adapter = new CardapioAdapter(this,listaDeProduto);
            lstProdutos.setAdapter(adapter);
            lstProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                   Produto produto = listaDeProduto.get(position);
                   view.setBackgroundColor((Color.DKGRAY));
                   arrayListNomePedidos.add(produto.getNome());
                   arrayListPrecoPedidos.add(produto.getPreco());
                }

                                               }


            );
        }






        public void onClickPedido(View v){


            Intent intent = new Intent(Cardapio.this,Confirmacao.class);
            intent.putExtra("listaNomePedidos",arrayListNomePedidos);
            intent.putExtra("listaPrecoPedidos",arrayListPrecoPedidos);

            startActivity(intent);


        }
        }


































