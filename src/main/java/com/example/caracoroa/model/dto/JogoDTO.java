package com.example.caracoroa.model.dto;

public class JogoDTO {

    private String outcome;

    public JogoDTO(String outcome) {
        this.outcome = outcome;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
}
