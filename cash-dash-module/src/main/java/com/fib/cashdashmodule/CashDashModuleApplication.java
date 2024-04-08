package com.fib.cashdashmodule;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
public class CashDashModuleApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(CashDashModuleApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		createBanknotesFile();
	}

	private void createBanknotesFile() {
		File file = new File("./banknotes.txt");
		try (FileWriter writer = new FileWriter(file)) {
			writer.write("Starting Amounts:\n");
			writer.write("1000 BGN, denomination: 50x10, 10x50\n");
			writer.write("2000 EUR, denomination: 100x10, 20x50\n");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
