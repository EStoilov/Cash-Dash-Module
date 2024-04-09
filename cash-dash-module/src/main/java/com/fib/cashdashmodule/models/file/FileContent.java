package com.fib.cashdashmodule.models.file;

public class FileContent {

    private String amountBGN;
    private String amountEUR;
    private String tenBGNBanknoteCount;
    private String fiftyBGNBanknoteCount;
    private String tenEURBanknoteCount;
    private String fiftyEURBanknoteCount;

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

    public String getTenBGNBanknoteCount() {
        return tenBGNBanknoteCount;
    }

    public void setTenBGNBanknoteCount(String tenBGNBanknoteCount) {
        this.tenBGNBanknoteCount = tenBGNBanknoteCount;
    }

    public String getFiftyBGNBanknoteCount() {
        return fiftyBGNBanknoteCount;
    }

    public void setFiftyBGNBanknoteCount(String fiftyBGNBanknoteCount) {
        this.fiftyBGNBanknoteCount = fiftyBGNBanknoteCount;
    }

    public String getTenEURBanknoteCount() {
        return tenEURBanknoteCount;
    }

    public void setTenEURBanknoteCount(String tenEURBanknoteCount) {
        this.tenEURBanknoteCount = tenEURBanknoteCount;
    }

    public String getFiftyEURBanknoteCount() {
        return fiftyEURBanknoteCount;
    }

    public void setFiftyEURBanknoteCount(String fiftyEURBanknoteCount) {
        this.fiftyEURBanknoteCount = fiftyEURBanknoteCount;
    }

    @Override
    public String toString() {
        return "FileContent{" +
                "amountBGN='" + amountBGN + '\'' +
                ", amountEUR='" + amountEUR + '\'' +
                ", tenBGNBanknoteCount='" + tenBGNBanknoteCount + '\'' +
                ", fiftyBGNBanknoteCount='" + fiftyBGNBanknoteCount + '\'' +
                ", tenEURBanknoteCount='" + tenEURBanknoteCount + '\'' +
                ", fiftyEURBanknoteCount='" + fiftyEURBanknoteCount + '\'' +
                '}';
    }
}
