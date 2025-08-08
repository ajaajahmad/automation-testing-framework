package com.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Excel reader utility for data-driven testing
public class ExcelReader {
    private static final Logger logger = LogManager.getLogger(ExcelReader.class);
    private Workbook workbook;
    private Sheet sheet;

    public ExcelReader(String filePath, String sheetName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(sheetName);
            logger.info("Excel file loaded: " + filePath + ", Sheet: " + sheetName);
        } catch (IOException e) {
            logger.error("Failed to load Excel file: " + filePath, e);
            throw new RuntimeException("Excel file not found or cannot be read: " + filePath);
        }
    }

    // Get data from Excel as Object[][]
    public Object[][] getData() {
        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();
        
        Object[][] data = new Object[rowCount][columnCount];
        
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.getCell(j);
                data[i-1][j] = getCellValue(cell);
            }
        }
        
        logger.info("Retrieved data from Excel: " + rowCount + " rows, " + columnCount + " columns");
        return data;
    }

    // Get data as List of Maps with column headers as keys
    public List<Map<String, String>> getDataAsListOfMaps() {
        List<Map<String, String>> dataList = new ArrayList<>();
        
        Row headerRow = sheet.getRow(0);
        int rowCount = sheet.getLastRowNum();
        
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            Map<String, String> dataMap = new HashMap<>();
            
            for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                String columnName = getCellValue(headerRow.getCell(j)).toString();
                String cellValue = getCellValue(row.getCell(j)).toString();
                dataMap.put(columnName, cellValue);
            }
            
            dataList.add(dataMap);
        }
        
        return dataList;
    }

    // Get cell value as Object
    private Object getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    return cell.getNumericCellValue();
                }
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    // Close workbook
    public void close() {
        try {
            if (workbook != null) {
                workbook.close();
                logger.info("Excel workbook closed");
            }
        } catch (IOException e) {
            logger.error("Failed to close Excel workbook", e);
        }
    }
}