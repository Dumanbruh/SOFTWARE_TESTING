package utils;

import common.BaseTest;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil extends BaseTest {

    public Sheet readExcel(String filePath, String fileName, String sheetName) throws IOException{
        File file =	new File(filePath+"\\"+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        if(fileExtensionName.equals(".xlsx")){
            workbook = new XSSFWorkbook(inputStream);
        }
        else if(fileExtensionName.equals(".xls")){
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook.getSheet(sheetName);
    }
}
