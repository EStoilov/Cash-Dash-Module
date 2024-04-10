package com.fib.cashdashmodule.services;

import com.fib.cashdashmodule.appconfig.Constants;
import com.fib.cashdashmodule.models.dtos.WithdrawalDTO;
import com.fib.cashdashmodule.models.file.FileContent;
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

    public WithdrawalDTO withdrawal(CashOperationRequest request) {
        FileContent fileContent = fileService.readFromFile(Constants.BANKNOTES_FILE_NAME);
        WithdrawalDTO withdrawalDTO = new WithdrawalDTO(fileContent.getAmountBGN(), fileContent.getAmountEUR());
        //TODO write in transaction file this operation
        return withdrawalDTO;
    }
}
