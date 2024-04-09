package com.fib.cashdashmodule.models.io.out;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CashOperationResponse {
    @JsonProperty("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CashOperationResponse(String message) {
        this.message = message;
    }
}
