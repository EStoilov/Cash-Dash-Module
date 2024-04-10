package com.fib.cashdashmodule.repository;

import com.fib.cashdashmodule.models.file.FileContent;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class FileRepository {
    public FileContent readFromFile(String fileName) {
        FileContent fileContent = new FileContent();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                Pattern pattern = Pattern.compile("(\\d+)\\s+(\\w+),\\s+denomination:\\s+(\\d+)x(\\d+),\\s+(\\d+)x(\\d+)");
                Matcher matcher = pattern.matcher(line);

                if (matcher.matches()) {
                    String amount = matcher.group(1);
                    String currency = matcher.group(2);
                    String denominationTen = matcher.group(3);
                    String denominationTenValue = matcher.group(4);
                    String denominationFifty = matcher.group(5);
                    String denominationFiftyValue = matcher.group(6);

                    if (currency.equals("BGN")) {
                        fileContent.setAmountBGN(amount);
                        fileContent.setTenBGNBanknoteCount(denominationTen);
                        fileContent.setFiftyBGNBanknoteCount(denominationFifty);
                    } else {
                        fileContent.setAmountEUR(amount);
                        fileContent.setTenEURBanknoteCount(denominationTen);
                        fileContent.setFiftyEURBanknoteCount(denominationFifty);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent;
    }

    public void writeToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void insetFileContent(String fileName, String newLine) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(newLine + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
