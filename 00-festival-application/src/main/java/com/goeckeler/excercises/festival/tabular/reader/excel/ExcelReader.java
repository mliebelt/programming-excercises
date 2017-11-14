package com.goeckeler.excercises.festival.tabular.reader.excel;

import com.goeckeler.excercises.festival.tabular.sheet.Table;
import com.goeckeler.excercises.festival.tabular.sheet.Row;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

public class ExcelReader {
    final private String excelFile;
    final DataFormatter cellFormat = new DataFormatter();

    public ExcelReader(final String excelFile) {
        assert StringUtils.isNotBlank(excelFile);
        this.excelFile = excelFile;
    }

    public Table read(final String sheetName) throws FileNotFoundException {
        Table data = new Table();

        try (InputStream excel = ClassLoader.getSystemResourceAsStream(excelFile)) {
            Workbook workbook = WorkbookFactory.create(excel);
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) return null;

            for (org.apache.poi.ss.usermodel.Row row : sheet) {
                Row tableRow = new Row();
                for (Cell cell : row) {
                    String text = cellFormat.formatCellValue(cell);
                    tableRow.addCell(text);
                }
                data.addRow(tableRow);
            }
        } catch (IOException | InvalidFormatException ex) {
            System.err.println(String.format("Cannot read from file '%s'.", excelFile));
        }

        return data;
    }
}
