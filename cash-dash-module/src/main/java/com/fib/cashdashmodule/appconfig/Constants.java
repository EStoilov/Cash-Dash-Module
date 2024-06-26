package com.fib.cashdashmodule.appconfig;

public class Constants {
    public static final String BANKNOTES_FILE_INIT_CONTENT = "1000 BGN, denomination: 50x10, 10x50\n2000 EUR, denomination: 100x10, 20x50\n";
    public static final String TRANSACTIONS_FILE_INIT_CONTENT = "Transactions for day: %s\n";
    public static final String BANKNOTES_FILE_NAME = "./banknotes.txt";
    public static final String TRANSACTIONS_FILE_NAME = "./transactions.txt";
    public static final String TRANSACTIONS_INFORMATION_PATTERN = "Cashier %s performed a %s operation of %s %s per date %s\n";
    public static final String API_KEY_HEADER = "FIB-X-AUTH";
    public static final String RESPONSE_ERROR_MESSAGE_UNAUTHORIZED = "Unauthorized access";
    public static final String RESPONSE_ILLEGAL_OPERATION= "Illegal Operation!";
    public static final String RESPONSE_ERROR_MESSAGE_AMOUNT = "Not correct amount";
    public static final String RESPONSE_MESSAGE_DEPOSIT = "Successful deposit!";
    public static final String RESPONSE_MESSAGE_WITHDRAW = "Successful withdrawal!";
    public static final String OPERATION_WITHDRAWAL = "withdrawal";
    public static final String OPERATION_DEPOSIT = "deposit";
}