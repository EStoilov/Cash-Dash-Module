package com.fib.cashdashmodule.services;

import com.fib.cashdashmodule.appconfig.Constants;
import com.fib.cashdashmodule.models.io.in.CashOperationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashOperationService {

    private final FileService fileService;

    @Autowired
    public CashOperationService(FileService fileService) {
        this.fileService = fileService;
    }

    public String deposit(CashOperationRequest request) {

        return Constants.RESPONSE_MESSAGE_DEPOSIT;
    }

    public String withdrawal(CashOperationRequest request) {
        fileService.readFromFile(Constants.BANKNOTES_FILE_NAME);
        return Constants.RESPONSE_MESSAGE_WITHDRAW;
    }
}
