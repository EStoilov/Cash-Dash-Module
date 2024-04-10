package com.fib.cashdashmodule.services;

import com.fib.cashdashmodule.appconfig.Constants;
import com.fib.cashdashmodule.models.file.FileContent;
import com.fib.cashdashmodule.models.io.in.CashBalanceRequest;
import com.fib.cashdashmodule.models.io.out.CashBalanceResponse;
import com.fib.cashdashmodule.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashBalanceService {
    private final FileRepository fileRepository;

    @Autowired
    public CashBalanceService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public CashBalanceResponse getBalance(CashBalanceRequest request) {
        CashBalanceResponse response = new CashBalanceResponse();
        FileContent fileContent = fileRepository.readFromFile(Constants.BANKNOTES_FILE_NAME);
        response.setCashier(request.getCashier());
        response.setAmountBGN(fileContent.getAmountBGN());
        response.setAmountEUR(fileContent.getAmountEUR());
        String denominationBGN = String.format(
                "denomination: %sx10, %sx50",
                fileContent.getTenBGNBanknoteCount(), fileContent.getFiftyBGNBanknoteCount()
        );
        response.setDenominationBGN(denominationBGN);
        String denominationEUR = String.format(
                "denomination: %sx10, %sx50",
                fileContent.getTenEURBanknoteCount(), fileContent.getFiftyEURBanknoteCount()
        );
        response.setDenominationEUR(denominationEUR);

        return response;
    }
}
