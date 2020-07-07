package com.example.caracoroa.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ToggleButton;

import com.example.caracoroa.R;
import com.example.caracoroa.controller.MainController;
import com.example.caracoroa.dao.JogoDao;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ToggleButton btnCaraCoroa;
    private Button btnJogar;
    private ListView lvJogadas;
    private MainController controller;
    private ImageView coinGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        controller = new MainController(this);
    }

    private void initialize() {
        coinGif = findViewById(R.id.coinGif);
        btnCaraCoroa = findViewById(R.id.caraCoroa);
        btnJogar = findViewById(R.id.jogar);
        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.jogar();
            }
        });
        lvJogadas = findViewById(R.id.lvJogadas);
    }

    public ToggleButton getBtnCaraCoroa() {
        return btnCaraCoroa;
    }

    public void setBtnCaraCoroa(ToggleButton btnCaraCoroa) {
        this.btnCaraCoroa = btnCaraCoroa;
    }

    public Button getBtnJogar() {
        return btnJogar;
    }

    public void setBtnJogar(Button btnJogar) {
        this.btnJogar = btnJogar;
    }

    public ListView getLvJogadas() {
        return lvJogadas;
    }

    public void setLvJogadas(ListView lvJogadas) {
        this.lvJogadas = lvJogadas;
    }

    public ImageView getCoinGif() {
        return coinGif;
    }

    public void setCoinGif(ImageView coinGif) {
        this.coinGif = coinGif;
    }
}
