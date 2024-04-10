package com.fib.cashdashmodule.controllers;

import com.fib.cashdashmodule.appconfig.Constants;
import com.fib.cashdashmodule.models.dtos.WithdrawalDTO;
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
    public ResponseEntity<String> depositCashOperation(@Validated @RequestBody CashOperationRequest request) {
        String message = cashOperationService.deposit(request);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CashOperationResponse> withdrawalCashOperation(@Validated @RequestBody CashOperationRequest request) {
        WithdrawalDTO withdrawalDTO = cashOperationService.withdrawal(request);
        CashOperationResponse response = new CashOperationResponse(Constants.RESPONSE_MESSAGE_WITHDRAW, withdrawalDTO.getAmountBGN(), withdrawalDTO.getAmountEUR());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
