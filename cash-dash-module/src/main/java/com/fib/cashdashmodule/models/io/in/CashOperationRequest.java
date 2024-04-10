package com.fib.cashdashmodule.models.io.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fib.cashdashmodule.appconfig.Constants;

import javax.validation.constraints.*;

public class CashOperationRequest {
    @NotNull
    @NotEmpty
    @JsonProperty("cashier")
    private String cashier;

    @NotNull
    @Pattern(regexp = "^\\d+$", message = Constants.RESPONSE_ERROR_MESSAGE_AMOUNT)
    @JsonProperty("amount")
    private String amount;

    @NotEmpty
    @JsonProperty("currency")
    private String currency;

    @NotNull
    @NotEmpty
    @JsonProperty("tenBanknoteCount")
    private String tenBanknoteCount;

    @NotNull
    @NotEmpty
    @JsonProperty("fiftyBanknoteCount")
    private String fiftyBanknoteCount;

    public CashOperationRequest(String cashier, String amount, String currency, String tenBanknoteCount, String fiftyBanknoteCount) {
        this.cashier = cashier;
        this.amount = amount;
        this.currency = currency;
        this.tenBanknoteCount = tenBanknoteCount;
        this.fiftyBanknoteCount = fiftyBanknoteCount;
    }

    public String getTenBanknoteCount() {
        return tenBanknoteCount;
    }

    public void setTenBanknoteCount(String tenBanknoteCount) {
        this.tenBanknoteCount = tenBanknoteCount;
    }

    public String getFiftyBanknoteCount() {
        return fiftyBanknoteCount;
    }

    public void setFiftyBanknoteCount(String fiftyBanknoteCount) {
        this.fiftyBanknoteCount = fiftyBanknoteCount;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
