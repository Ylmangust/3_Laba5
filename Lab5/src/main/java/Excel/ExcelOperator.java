/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excel;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import javax.swing.JOptionPane;
import mephi.b22901.lab5.Lab5;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Регина
 */
public class ExcelOperator {

    private static List<Result> results = new ArrayList<>();
    private static String resultsFile;
    private static final String RESULTS_FILE_NAME = "results.xlsx";

    static {
        try {
            String path = new File(Lab5.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
            resultsFile = path + File.separator + RESULTS_FILE_NAME;
        } catch (Exception e) {
            resultsFile = RESULTS_FILE_NAME;
        }
    }

    public static List<Result> readResults() {
        results.clear();
        ensureResultsFileExists();
        try {
            FileInputStream in = new FileInputStream(resultsFile);
            Workbook workbook = new XSSFWorkbook(in);
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                String name = sheet.getRow(i).getCell(1).getStringCellValue();
                int points = (int) sheet.getRow(i).getCell(2).getNumericCellValue();
                results.add(new Result(name, points));
            }
            results.sort((r1, r2) -> Integer.compare(r2.getPoints(), r1.getPoints()));
        } catch (FileNotFoundException e) {
            createBook();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    private static void createBook() {
        try (XSSFWorkbook book = new XSSFWorkbook()) {
            Sheet sheet = book.createSheet("Результаты ТОП 10");
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("№");
            headerRow.createCell(1).setCellValue("Имя");
            headerRow.createCell(2).setCellValue("Количество баллов");
            FileOutputStream out = new FileOutputStream(resultsFile);
            book.write(out);
            book.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void ensureResultsFileExists() {
        File file = new File(resultsFile);
        if (!file.exists()) {
            try (InputStream in = ExcelOperator.class.getResourceAsStream("/Results.xlsx")) {
                if (in != null) {
                    Files.copy(in, file.toPath());
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            createBook();
        }
    }

    public static void writeResults(String name, int score) {
        readResults();
        results.add(new Result(name, score));
        results.sort((r1, r2) -> Integer.compare(r2.getPoints(), r1.getPoints()));
        JOptionPane.showMessageDialog(null, "Результат успешно записан!", null, JOptionPane.INFORMATION_MESSAGE);
        try (FileInputStream fis = new FileInputStream(resultsFile); XSSFWorkbook book = new XSSFWorkbook(fis)) {
            Sheet sheet = book.getSheetAt(0);
            for (int i = 0; i < results.size(); i++) {
                if (i < 10) {
                    Row row = sheet.createRow(i + 1);
                    row.createCell(0).setCellValue(i + 1);
                    row.createCell(1).setCellValue(results.get(i).getName());
                    row.createCell(2).setCellValue(results.get(i).getPoints());
                }
            }
            try (FileOutputStream out = new FileOutputStream(resultsFile)) {
                book.write(out);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
