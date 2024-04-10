package com.fib.cashdashmodule.services;

import com.fib.cashdashmodule.appconfig.Constants;
import com.fib.cashdashmodule.models.file.FileContent;
import com.fib.cashdashmodule.models.io.in.CashOperationRequest;
import com.fib.cashdashmodule.models.io.out.CashOperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public CashOperationResponse withdrawal(CashOperationRequest request) {
        FileContent fileContent = fileService.readFromFile(Constants.BANKNOTES_FILE_NAME);
        CashOperationResponse cashOperationResponse = new CashOperationResponse();
        checkForBalance(request, fileContent, cashOperationResponse);
        //TODO write in transaction file this operation
        return cashOperationResponse;
    }

    private void checkForBalance(CashOperationRequest request, FileContent fileContent, CashOperationResponse cashOperationResponse) {
        Integer withdrawalSum = Integer.parseInt(request.getAmount());
        Integer withdrawalTenBanknotesCount = Integer.parseInt(request.getTenBanknoteCount());
        Integer withdrawalFiftyBanknotesCount = Integer.parseInt(request.getFiftyBanknoteCount());
        Integer currentSum;
        Integer currentTenBanknotesCount;
        Integer currentFiftyBanknotesCount;
        switch (request.getCurrency()) {
            case "BGN" :
                currentSum = Integer.parseInt(fileContent.getAmountBGN());
                currentTenBanknotesCount = Integer.parseInt(fileContent.getTenBGNBanknoteCount());
                currentFiftyBanknotesCount = Integer.parseInt(fileContent.getFiftyBGNBanknoteCount());
                if (withdrawalSum > currentSum || withdrawalTenBanknotesCount > currentTenBanknotesCount || withdrawalFiftyBanknotesCount > currentFiftyBanknotesCount) {
                    cashOperationResponse.setMessage(Constants.RESPONSE_ILLEGAL_OPERATION);
            } else {
                    cashOperationResponse.setMessage(Constants.RESPONSE_MESSAGE_WITHDRAW);
                    Integer newSum = currentSum - withdrawalSum;
                    Integer newTenBanknotesCount = currentTenBanknotesCount - withdrawalTenBanknotesCount;
                    Integer newFiftyBanknotesCount = currentFiftyBanknotesCount - withdrawalFiftyBanknotesCount;
                    cashOperationResponse.setAmountBGN(String.valueOf(newSum));
                    String newContent = String.format("%d %s, denomination: %dx10, %dx50\n%s EUR, denomination: %sx10, %sx50\n",
                            newSum, request.getCurrency(), newTenBanknotesCount, newFiftyBanknotesCount, fileContent.getAmountEUR(),fileContent.getTenEURBanknoteCount(), fileContent.getFiftyEURBanknoteCount());

                    fileService.writeToFile(Constants.BANKNOTES_FILE_NAME, newContent);
                }
            case "EUR" :
        }
    }
}
