package com.fib.cashdashmodule;

import com.fib.cashdashmodule.appconfig.Constants;
import com.fib.cashdashmodule.services.FileService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
public class CashDashModuleApplication implements ApplicationRunner {

	private final FileService fileService;

	public CashDashModuleApplication(FileService fileService) {
		this.fileService = fileService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CashDashModuleApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		fileService.writeToFile(Constants.BANKNOTES_FILE_NAME, Constants.BANKNOTES_FILE_INIT_CONTENT);
	}
}
