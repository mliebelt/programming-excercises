package com.goeckeler.excercises.festival.reader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

public class ExcelReader {
    public void read(final String excelFile, final String sheetName) throws FileNotFoundException {
        final DataFormatter cellFormat = new DataFormatter();
        try (InputStream excel = ClassLoader.getSystemResourceAsStream(excelFile)) {
            Workbook workbook = WorkbookFactory.create(excel);
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) return;

            for (Row row : sheet) {
                System.out.println();
                for (Cell cell : row) {
                    String text = cellFormat.formatCellValue(cell);
                    System.out.print("[" + text + "]");
                }
            }
            System.out.println();
            System.out.println();
        } catch (IOException | InvalidFormatException ex) {
            System.err.println(String.format("Cannot read from file '%s'.", excelFile));
        }
    }
}
