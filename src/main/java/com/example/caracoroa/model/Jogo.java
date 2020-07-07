package com.example.caracoroa.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "jogo")
public class Jogo {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Integer idJogo;
    @DatabaseField(canBeNull = false)
    private String opcaoEscolhida;
    @DatabaseField(canBeNull = false)
    private String ladoCaiu;
    @DatabaseField(canBeNull = false)
    private String resultado;

    public Jogo(String opcaoEscolhida, String ladoCaiu, String resultado) {
        this.opcaoEscolhida = opcaoEscolhida;
        this.ladoCaiu = ladoCaiu;
        this.resultado = resultado;
    }

    public Jogo() {

    }

    public String getOpcaoEscolhida() {
        return opcaoEscolhida;
    }

    public void setOpcaoEscolhida(String opcaoEscolhida) {
        this.opcaoEscolhida = opcaoEscolhida;
    }

    public String getLadoCaiu() {
        return ladoCaiu;
    }

    public void setLadoCaiu(String ladoCaiu) {
        this.ladoCaiu = ladoCaiu;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Escolhido = " + opcaoEscolhida + " | Caiu = " + ladoCaiu + " | " + resultado;
    }
}
