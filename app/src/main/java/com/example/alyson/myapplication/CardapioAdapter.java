package com.example.alyson.myapplication;




        import android.content.Context;
        import android.renderscript.Sampler;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;


        import java.util.ArrayList;




public class CardapioAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Produto> lista;


    public CardapioAdapter (Context context, ArrayList<Produto> lista){


        this.context = context;
        this.lista = lista;


    }




    @Override
    public int getCount() { return lista.size();}


    @Override
    public Object getItem(int i) { return lista.get(i); }


    @Override
    public long getItemId(int i) { return i;}


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        LayoutInflater inflater = LayoutInflater.from(context);
        View xml = inflater.inflate(R.layout.item_cardapio,viewGroup,false);
        ImageView capa = (ImageView) xml.findViewById (R.id.capinha);
        TextView nomeProduto = (TextView) xml.findViewById(R.id.txtProduto);
        TextView nomePreco = (TextView) xml.findViewById(R.id.txtPreco);
        Produto produto = lista.get(i);




        capa.setImageResource(produto.getCapas());
        nomeProduto.setText(produto.getNome());
        nomePreco.setText("R$ "+toString().valueOf(produto.getPreco())+",00");


        return xml;




    }
}


