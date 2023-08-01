package com.rallypay.utils;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import org.apache.poi.xssf.usermodel.XSSFCell;
        import org.apache.poi.xssf.usermodel.XSSFRow;
        import org.apache.poi.xssf.usermodel.XSSFSheet;
        import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

//How to read excel files using Apache

    public static String[][] getExcelData(String fileName, String sheetName) {
        String[][] arrayExcelData = null;
        try
        {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\com\\rallypay\\resources\\"+fileName);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sh = wb.getSheet(sheetName);
            XSSFRow row = sh.getRow(0);
            int noOfRows = sh.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            XSSFCell cell;
            arrayExcelData = new String[noOfRows-1][noOfCols];
            for(int i =1; i<noOfRows;i++){
                for(int j=0;j<noOfCols;j++){
                    row = sh.getRow(i);
                    cell= row.getCell(j);
                    arrayExcelData[i-1][j] = cell.getStringCellValue();
                    System.out.println(arrayExcelData[i-1][j] + "arrayExcelData");
                }
            }
        }
        catch (Exception e) {
            System.out.println("The exception is: " +e.getMessage());
        }
         return arrayExcelData;
     }

    }