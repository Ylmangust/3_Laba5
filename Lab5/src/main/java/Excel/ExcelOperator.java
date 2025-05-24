/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excel;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Регина
 */
public class ExcelOperator {

    private static List<Result> results = new ArrayList<>();

    public static List<Result> readResults() {
        try {
            FileInputStream in = new FileInputStream(new File("Results.xlsx"));
            Workbook workbook = new XSSFWorkbook(in);
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                String name = sheet.getRow(i).getCell(1).getStringCellValue();
                int points = (int) sheet.getRow(i).getCell(2).getNumericCellValue();
                results.add(new Result(name, points));
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Файл не был найден!", null, JOptionPane.ERROR_MESSAGE);
            createBook();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    private static void createBook() {
        XSSFWorkbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Результаты ТОП 10");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("№");
        headerRow.createCell(1).setCellValue("Имя");
        headerRow.createCell(2).setCellValue("Количество баллов");

        try {
            FileOutputStream out = new FileOutputStream(new File("Results.xlsx"));
            book.write(out);
            book.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void writeResults() {
        XSSFWorkbook book = new XSSFWorkbook();
        Sheet sheet = book.getSheetAt(0);
        for (int i = 0; i < results.size(); i++) {
            if (i < 10) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(i + 1);
                row.createCell(1).setCellValue(results.get(i).getName());
                row.createCell(2).setCellValue(results.get(i).getPoints());
            }
        }try {
            FileOutputStream out = new FileOutputStream(new File("Results.xlsx"));
            book.write(out);
            book.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

}
