package com.fib.cashdashmodule;

import com.fib.cashdashmodule.appconfig.Constants;
import com.fib.cashdashmodule.repository.FileRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CashDashModuleApplication implements ApplicationRunner {

	private final FileRepository fileRepository;

	public CashDashModuleApplication(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CashDashModuleApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		fileRepository.writeToFile(Constants.BANKNOTES_FILE_NAME, Constants.BANKNOTES_FILE_INIT_CONTENT);
	}
}
