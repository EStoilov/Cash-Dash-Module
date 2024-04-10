package com.fib.cashdashmodule.models.io.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CashBalanceRequest {
    @NotNull
    @NotEmpty
    @JsonProperty("cashier")
    private String cashier;

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }
}
