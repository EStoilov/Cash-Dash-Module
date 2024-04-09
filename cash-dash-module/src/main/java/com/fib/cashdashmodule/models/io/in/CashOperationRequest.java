package com.fib.cashdashmodule.models.io.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;

public class CashOperationRequest {
    @NotNull
    @NotEmpty
    @JsonProperty("cashier")
    private String cashier;

    @NotEmpty
    @JsonProperty("amount")
    private Integer amount;

    @NotEmpty
    @JsonProperty("currency")
    private String currency;


    public CashOperationRequest(String cashier, Integer amount, String currency) {
        this.cashier = cashier;
        this.amount = amount;
        this.currency = currency;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
