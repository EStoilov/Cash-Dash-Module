package com.fib.cashdashmodule.models.io.out;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CashOperationResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("amountBGN")
    private String amountBGN;

    @JsonProperty("amountEUR")
    private String amountEUR;


    public CashOperationResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAmountBGN() {
        return amountBGN;
    }

    public void setAmountBGN(String amountBGN) {
        this.amountBGN = amountBGN;
    }

    public String getAmountEUR() {
        return amountEUR;
    }

    public void setAmountEUR(String amountEUR) {
        this.amountEUR = amountEUR;
    }
}
