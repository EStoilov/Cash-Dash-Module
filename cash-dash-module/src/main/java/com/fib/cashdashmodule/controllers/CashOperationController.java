package com.fib.cashdashmodule.controllers;

import com.fib.cashdashmodule.models.io.in.CashOperationRequest;
import com.fib.cashdashmodule.models.io.out.CashOperationResponse;
import com.fib.cashdashmodule.services.CashOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cash-operation")
public class CashOperationController {
    private final CashOperationService cashOperationService;

    @Autowired
    public CashOperationController(CashOperationService cashOperationService) {
        this.cashOperationService = cashOperationService;
    }

    @PostMapping
    public ResponseEntity<CashOperationResponse> depositCashOperation(@Validated @RequestBody CashOperationRequest request) {
        String message = cashOperationService.deposit(request);
        CashOperationResponse response = new CashOperationResponse(message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CashOperationResponse> withdrawalCashOperation(@Validated @RequestBody CashOperationRequest request) {
        String message = cashOperationService.withdrawal(request);
        CashOperationResponse response = new CashOperationResponse(message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
