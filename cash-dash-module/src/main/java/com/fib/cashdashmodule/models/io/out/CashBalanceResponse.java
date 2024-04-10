package com.fib.cashdashmodule.models.io.out;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CashBalanceResponse {
    @JsonProperty("cashier")
    private String cashier;

    @JsonProperty("amountBGN")
    private String amountBGN;

    @JsonProperty("denominationBGN")
    private String denominationBGN;

    @JsonProperty("amountEUN")
    private String amountEUR;

    @JsonProperty("denominationEUR")
    private String denominationEUR;

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getAmountBGN() {
        return amountBGN;
    }

    public void setAmountBGN(String amountBGN) {
        this.amountBGN = amountBGN;
    }

    public String getDenominationBGN() {
        return denominationBGN;
    }

    public void setDenominationBGN(String denominationBGN) {
        this.denominationBGN = denominationBGN;
    }

    public String getAmountEUR() {
        return amountEUR;
    }

    public void setAmountEUR(String amountEUR) {
        this.amountEUR = amountEUR;
    }

    public String getDenominationEUR() {
        return denominationEUR;
    }

    public void setDenominationEUR(String denominationEUR) {
        this.denominationEUR = denominationEUR;
    }
}
