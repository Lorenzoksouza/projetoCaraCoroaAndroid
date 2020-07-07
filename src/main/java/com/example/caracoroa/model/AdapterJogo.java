package com.example.caracoroa.model;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.caracoroa.R;

import java.util.List;

public class AdapterJogo extends BaseAdapter {

    private List<Jogo> jogoList;
    private LayoutInflater inflater;

    public AdapterJogo(Context context, List<Jogo> jogoList) {
        this.jogoList = jogoList;
        inflater = LayoutInflater.from(context);
    }

    public void add(Jogo p){
        jogoList.add(p);
        notifyDataSetChanged();
    }

    public void remove(Jogo p){
        jogoList.remove(p);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return jogoList.size();
    }

    @Override
    public Object getItem(int position) {
        return jogoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Resgata o Jogo atual
        Jogo jogo = jogoList.get(position);

        //Chamar layout de um item do litView
        convertView = inflater.inflate(R.layout.item_listview_jogo, null);

        TextView txtResultado = convertView.findViewById(R.id.txtResultado);
        txtResultado.setText(jogo.getResultado());
        if(jogo.getResultado().toString().equals("Perdeu")){
                txtResultado.setTextColor(Color.RED);
        }else{
            txtResultado.setTextColor(Color.GREEN);
        }

        TextView txtOpcaoJogador = convertView.findViewById(R.id.txtOpcaoJogador);
        txtOpcaoJogador.setText(jogo.getOpcaoEscolhida());

        TextView txtCaiu = convertView.findViewById(R.id.txtCaiu);
        txtCaiu.setText(jogo.getLadoCaiu());

        return convertView;
    }
}
