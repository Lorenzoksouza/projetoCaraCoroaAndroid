package com.example.caracoroa.controller;

import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.caracoroa.dao.JogoDao;
import com.example.caracoroa.model.AdapterJogo;
import com.example.caracoroa.model.Jogo;
import com.example.caracoroa.model.dto.JogoDTO;
import com.example.caracoroa.view.MainActivity;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainController {

    private MainActivity activity;

    private AdapterJogo adapterJogo;
    private List<Jogo> listJogo;

    private Jogo jogo;
    private JogoDao jogoDao;

    public MainController(MainActivity activity) {
        this.activity = activity;
        jogoDao = new JogoDao(this.activity);
        configListView();
    }

    private void configListView() {
        try {
            listJogo = jogoDao.getDao().queryForAll();
            Collections.reverse(Arrays.asList(listJogo));
            adapterJogo = new AdapterJogo(activity, listJogo);
            activity.getLvJogadas().setAdapter(adapterJogo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void jogar(){
        AsyncHttpClient client = new AsyncHttpClient();

        client.addHeader("x-rapidapi-host", "coin-flip1.p.rapidapi.com");
        client.addHeader("x-rapidapi-key", "b30d550bacmshc44269e3848cb35p193c37jsn29b2ab551016");
        client.get("https://coin-flip1.p.rapidapi.com/headstails", new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                activity.getCoinGif().setVisibility(View.VISIBLE);
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String s = new String(bytes);
                Gson gson = new Gson();

                (new Handler()).postDelayed(() ->{}, 3000);
                activity.getCoinGif().setVisibility(View.INVISIBLE);

                JogoDTO jogoDTO = gson.fromJson(s, JogoDTO.class);
                jogo = new Jogo();
                if(activity.getBtnCaraCoroa().isChecked()){
                    jogo.setOpcaoEscolhida("Coroa");
                }else{
                    jogo.setOpcaoEscolhida("Cara");
                }
                if (jogoDTO.getOutcome().equals("Heads")) {
                    jogo.setLadoCaiu("Cara");
                }else{
                    jogo.setLadoCaiu("Coroa");
                }
                if(jogo.getLadoCaiu().equals(jogo.getOpcaoEscolhida())){
                    jogo.setResultado("Ganhou");
                }else {
                    jogo.setResultado("Perdeu");
                }
                try {
                    jogoDao.getDao().create(jogo);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                adapterJogo.add(jogo);

            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(activity, "Não deu, Tenta de novo", Toast.LENGTH_SHORT).show();
                activity.getCoinGif().setVisibility(View.INVISIBLE);
            }
        });
    }
}