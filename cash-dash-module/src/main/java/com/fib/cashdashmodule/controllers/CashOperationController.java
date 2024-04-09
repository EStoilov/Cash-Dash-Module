package com.fib.cashdashmodule.controllers;

import com.fib.cashdashmodule.models.io.in.CashOperationRequest;
import com.fib.cashdashmodule.models.io.out.CashOperationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cash-operation")
public class CashOperationController {

    @PostMapping
    public ResponseEntity<CashOperationResponse> depositCashOperation(@Validated @RequestBody CashOperationRequest request) {
        CashOperationResponse response = new CashOperationResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CashOperationResponse> withdrawalCashOperation(@Validated @RequestBody CashOperationRequest request) {
        CashOperationResponse response = new CashOperationResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
