package tests;

import common.BaseTest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;
import utils.ExcelUtil;

import java.io.IOException;
import java.util.*;

public class HybridExecuteTest extends BaseTest{
    @Test
    public void testLogin() throws IOException, InterruptedException {
        ExcelUtil excel = new ExcelUtil();
        Map<String, Integer> requiredHeaders = new HashMap<>();
        Sheet testCaseExcel = excel.readExcel(System.getProperty("user.dir") + "/src/excel/","HybridTest.xlsx" , "HybridTest");
        for (Cell cell : testCaseExcel.getRow(0)) {
            requiredHeaders.put(cell.getStringCellValue(), cell.getColumnIndex());
        }
        home.closeCookie();
        for (int i = 1; i <= testCaseExcel.getLastRowNum(); i++) {
            Row row = testCaseExcel.getRow(i);
            home.navigateToLoginPage();
            home.writeLogin(row.getCell(requiredHeaders.get("Username")).getStringCellValue());
            home.writePassword(row.getCell(requiredHeaders.get("Password")).getStringCellValue());
            home.clickLogin();
            profile.hover();
        }
    }


}
