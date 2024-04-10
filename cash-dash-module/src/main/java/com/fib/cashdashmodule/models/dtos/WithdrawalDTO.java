package com.fib.cashdashmodule.models.dtos;

public class WithdrawalDTO {
    private String amountBGN;
    private String amountEUR;

    public WithdrawalDTO(String amountBGN, String amountEUR) {
        this.amountBGN = amountBGN;
        this.amountEUR = amountEUR;
    }

    public String getAmountBGN() {
        return amountBGN;
    }

    public String getAmountEUR() {
        return amountEUR;
    }
}
