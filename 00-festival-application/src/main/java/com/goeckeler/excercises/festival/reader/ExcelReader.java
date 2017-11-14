package com.goeckeler.excercises.festival.reader;

import com.goeckeler.excercises.festival.model.data.TabularRow;
import com.goeckeler.excercises.festival.model.data.TabularSheet;
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

    public TabularSheet read(final String sheetName) throws FileNotFoundException {
        TabularSheet data = new TabularSheet();

        try (InputStream excel = ClassLoader.getSystemResourceAsStream(excelFile)) {
            Workbook workbook = WorkbookFactory.create(excel);
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) return null;

            for (Row row : sheet) {
                TabularRow tabularRow = new TabularRow();
                for (Cell cell : row) {
                    String text = cellFormat.formatCellValue(cell);
                    tabularRow.addCell(text);
                }
                data.addRow(tabularRow);
            }
        } catch (IOException | InvalidFormatException ex) {
            System.err.println(String.format("Cannot read from file '%s'.", excelFile));
        }

        return data;
    }
}
