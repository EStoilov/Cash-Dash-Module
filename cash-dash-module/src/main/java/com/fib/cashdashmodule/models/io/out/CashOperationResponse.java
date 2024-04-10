package com.fib.cashdashmodule.models.io.out;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CashOperationResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("amountBGN")
    private String amountBGN;

    @JsonProperty("amountEUR")
    private String amountEUR;


    public CashOperationResponse(String message, String amountBGN, String amountEUR) {
        this.message = message;
        this.amountBGN = amountBGN;
        this.amountEUR = amountEUR;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
