package com.fib.cashdashmodule.controllers;

import com.fib.cashdashmodule.models.io.in.CashBalanceRequest;
import com.fib.cashdashmodule.models.io.in.CashOperationRequest;
import com.fib.cashdashmodule.models.io.out.CashBalanceResponse;
import com.fib.cashdashmodule.services.CashBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cash-balance")
public class CashBalanceController {

    private final CashBalanceService cashBalanceService;

    @Autowired
    public CashBalanceController(CashBalanceService cashBalanceService) {
        this.cashBalanceService = cashBalanceService;
    }

    @GetMapping
    public ResponseEntity<CashBalanceResponse> getCashBalance(@RequestBody CashBalanceRequest cashBalanceRequest) {
        CashBalanceResponse response = cashBalanceService.getBalance(cashBalanceRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
