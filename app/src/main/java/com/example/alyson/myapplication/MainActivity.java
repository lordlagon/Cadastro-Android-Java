package com.example.alyson.myapplication;

import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;


    public class MainActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }


        public void cardapio(View v) {
            Intent vai = new Intent(this, Cardapio.class);
            startActivity(vai);
        }

        public void pedidos(View v) {
            Intent vai = new Intent(this, PedidosFeitos.class);
            startActivity(vai);
        }


    }




