package com.example.caracoroa.dao;

import android.content.Context;

import com.example.caracoroa.helpers.DaoHelper;
import com.example.caracoroa.model.Jogo;
import com.example.caracoroa.model.dto.JogoDTO;

import java.sql.SQLException;
import java.util.List;

public class JogoDao extends DaoHelper<Jogo> {
    public JogoDao(Context c) {
        super(c, Jogo.class);
    }
}