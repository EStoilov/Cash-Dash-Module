package com.fib.cashdashmodule.services;

import com.fib.cashdashmodule.appconfig.Constants;
import com.fib.cashdashmodule.models.file.FileContent;
import com.fib.cashdashmodule.models.io.in.CashOperationRequest;
import com.fib.cashdashmodule.models.io.out.CashOperationResponse;
import com.fib.cashdashmodule.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class CashOperationService {

    private final FileRepository fileRepository;

    @Autowired
    public CashOperationService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Transactional
    public CashOperationResponse deposit(CashOperationRequest request) {

        FileContent fileContent = fileRepository.readFromFile(Constants.BANKNOTES_FILE_NAME);
        CashOperationResponse cashOperationResponse = new CashOperationResponse();
        Integer depositSum = Integer.parseInt(request.getAmount());
        Integer depositTenBanknotesCount = Integer.parseInt(request.getTenBanknoteCount());
        Integer depositFiftyBanknotesCount = Integer.parseInt(request.getFiftyBanknoteCount());
        Integer currentSum;
        Integer currentTenBanknotesCount;
        Integer currentFiftyBanknotesCount;
        switch (request.getCurrency()) {

            case "BGN":
                currentSum = Integer.parseInt(fileContent.getAmountBGN());
                currentTenBanknotesCount = Integer.parseInt(fileContent.getTenBGNBanknoteCount());
                currentFiftyBanknotesCount = Integer.parseInt(fileContent.getFiftyBGNBanknoteCount());
                cashOperationResponse.setMessage(Constants.RESPONSE_MESSAGE_DEPOSIT);
                Integer newSumBGN = currentSum + depositSum;
                cashOperationResponse.setAmountBGN(String.valueOf(newSumBGN));
                Integer newTenBanknotesCountBGN = currentTenBanknotesCount - depositTenBanknotesCount;
                Integer newFiftyBanknotesCountBGN = currentFiftyBanknotesCount + depositFiftyBanknotesCount;
                updateFileBalance(request, fileContent, depositTenBanknotesCount, depositFiftyBanknotesCount,
                        currentTenBanknotesCount, currentFiftyBanknotesCount, newSumBGN, Constants.OPERATION_DEPOSIT,
                        newTenBanknotesCountBGN, newFiftyBanknotesCountBGN, Constants.BANKNOTES_FILE_NAME);
            break;
            case "EUR":
                currentSum = Integer.parseInt(fileContent.getAmountEUR());
                currentTenBanknotesCount = Integer.parseInt(fileContent.getTenEURBanknoteCount());
                currentFiftyBanknotesCount = Integer.parseInt(fileContent.getTenEURBanknoteCount());
                cashOperationResponse.setMessage(Constants.RESPONSE_MESSAGE_DEPOSIT);
                Integer newSumEUR = currentSum + depositSum;
                cashOperationResponse.setAmountEUR(String.valueOf(newSumEUR));
                Integer newTenBanknotesCountEUR = currentTenBanknotesCount + depositTenBanknotesCount;
                Integer newFiftyBanknotesCountEUR = currentFiftyBanknotesCount - depositFiftyBanknotesCount;
                updateFileBalance(request, fileContent, depositTenBanknotesCount, depositFiftyBanknotesCount,
                        currentTenBanknotesCount, currentFiftyBanknotesCount, newSumEUR, Constants.OPERATION_DEPOSIT,
                        newTenBanknotesCountEUR, newFiftyBanknotesCountEUR, Constants.BANKNOTES_FILE_NAME);
                break;
        }

        //Cashier %s performed a %s operation of %s %s per date %s
        String transactionInfo = String.format(Constants.TRANSACTIONS_INFORMATION_PATTERN,
                request.getCashier(), Constants.OPERATION_DEPOSIT, request.getCurrency(), request.getAmount(),
                LocalDate.now().toString());
        fileRepository.insetFileContent(Constants.TRANSACTIONS_FILE_NAME, transactionInfo);
        return cashOperationResponse;
    }

    @Transactional
    public CashOperationResponse withdrawal(CashOperationRequest request) {
        FileContent fileContent = fileRepository.readFromFile(Constants.BANKNOTES_FILE_NAME);
        CashOperationResponse cashOperationResponse = new CashOperationResponse();
        reduceBalance(request, fileContent, cashOperationResponse);
        //TODO write in transaction file this operation
        return cashOperationResponse;
    }

    private void reduceBalance(CashOperationRequest request, FileContent fileContent, CashOperationResponse cashOperationResponse) {
        Integer withdrawalSum = Integer.parseInt(request.getAmount());
        Integer withdrawalTenBanknotesCount = Integer.parseInt(request.getTenBanknoteCount());
        Integer withdrawalFiftyBanknotesCount = Integer.parseInt(request.getFiftyBanknoteCount());
        Integer currentSum;
        Integer currentTenBanknotesCount;
        Integer currentFiftyBanknotesCount;
        switch (request.getCurrency()) {

            case "BGN":
                currentSum = Integer.parseInt(fileContent.getAmountBGN());
                currentTenBanknotesCount = Integer.parseInt(fileContent.getTenBGNBanknoteCount());
                currentFiftyBanknotesCount = Integer.parseInt(fileContent.getFiftyBGNBanknoteCount());
                if (withdrawalSum > currentSum || withdrawalTenBanknotesCount > currentTenBanknotesCount || withdrawalFiftyBanknotesCount > currentFiftyBanknotesCount) {
                    cashOperationResponse.setMessage(Constants.RESPONSE_ILLEGAL_OPERATION);
                } else {
                    cashOperationResponse.setMessage(Constants.RESPONSE_MESSAGE_WITHDRAW);
                    Integer newSum = currentSum - withdrawalSum;
                    cashOperationResponse.setAmountBGN(String.valueOf(newSum));
                    Integer newTenBanknotesCount = currentTenBanknotesCount - withdrawalTenBanknotesCount;
                    Integer newFiftyBanknotesCount = currentFiftyBanknotesCount - withdrawalFiftyBanknotesCount;
                    updateFileBalance(request, fileContent, withdrawalTenBanknotesCount, withdrawalFiftyBanknotesCount,
                            currentTenBanknotesCount, currentFiftyBanknotesCount, newSum, Constants.OPERATION_WITHDRAWAL,
                            newTenBanknotesCount, newFiftyBanknotesCount, Constants.BANKNOTES_FILE_NAME);
                }
                break;
            case "EUR":
                currentSum = Integer.parseInt(fileContent.getAmountEUR());
                currentTenBanknotesCount = Integer.parseInt(fileContent.getTenEURBanknoteCount());
                currentFiftyBanknotesCount = Integer.parseInt(fileContent.getTenEURBanknoteCount());
                if (withdrawalSum > currentSum || withdrawalTenBanknotesCount > currentTenBanknotesCount || withdrawalFiftyBanknotesCount > currentFiftyBanknotesCount) {
                    cashOperationResponse.setMessage(Constants.RESPONSE_ILLEGAL_OPERATION);
                } else {
                    cashOperationResponse.setMessage(Constants.RESPONSE_MESSAGE_WITHDRAW);
                    Integer newSum = currentSum - withdrawalSum;
                    cashOperationResponse.setAmountEUR(String.valueOf(newSum));
                    Integer newTenBanknotesCount = currentTenBanknotesCount - withdrawalTenBanknotesCount;
                    Integer newFiftyBanknotesCount = currentFiftyBanknotesCount - withdrawalFiftyBanknotesCount;
                    updateFileBalance(request, fileContent, withdrawalTenBanknotesCount, withdrawalFiftyBanknotesCount,
                            currentTenBanknotesCount, currentFiftyBanknotesCount, newSum, Constants.OPERATION_WITHDRAWAL,
                            newTenBanknotesCount, newFiftyBanknotesCount, Constants.BANKNOTES_FILE_NAME);
                }
                break;
        }
    }

    private void updateFileBalance(CashOperationRequest request, FileContent fileContent, Integer withdrawalTenBanknotesCount,
                                   Integer withdrawalFiftyBanknotesCount, Integer currentTenBanknotesCount,
                                   Integer currentFiftyBanknotesCount, Integer newSum, String operation,
                                   Integer newTenBanknotesCount, Integer newFiftyBanknotesCount, String fileName) {

        String newContent = null;
        if (request.getCurrency().equals("BGN")) {

            newContent = String.format("%d BGN, denomination: %dx10, %dx50\n%s EUR, denomination: %sx10, %sx50\n",
                    newSum, newTenBanknotesCount, newFiftyBanknotesCount,
                    fileContent.getAmountEUR(), fileContent.getTenEURBanknoteCount(), fileContent.getFiftyEURBanknoteCount());
        } else {

            newContent = String.format("%s BGN, denomination: %sx10, %sx50\n%d EUR, denomination: %dx10, %dx50\n",
                    fileContent.getAmountBGN(), fileContent.getTenBGNBanknoteCount(),
                    fileContent.getFiftyBGNBanknoteCount(), newSum, newTenBanknotesCount, newFiftyBanknotesCount);
        }
        fileRepository.writeToFile(fileName, newContent);
    }
}
