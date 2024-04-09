package com.fib.cashdashmodule.services;

import com.fib.cashdashmodule.appconfig.Constants;
import com.fib.cashdashmodule.models.io.in.CashOperationRequest;
import org.springframework.stereotype.Service;

@Service
public class CashOperationService {

    public String deposit(CashOperationRequest request) {

        return Constants.RESPONSE_MESSAGE_DEPOSIT;
    }

    public String withdrawal(CashOperationRequest request) {

        return Constants.RESPONSE_MESSAGE_WITHDRAW;
    }
}
