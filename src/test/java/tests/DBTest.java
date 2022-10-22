package tests;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class DBTest extends BaseTest {
    @Test
    public void dbLoginTest() {
        try {
            resultSet = statement.executeQuery("select * from olxuser");
            home.closeCookie();
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();

            while (resultSet.next()) {
                Statement insertStmt = connection.createStatement();
                home.navigateToLoginPage();
                home.writeLogin(resultSet.getString("username"));
                home.writePassword(resultSet.getString("password"));
                home.clickLogin();
                Thread.sleep(10000);
                if(driver.getCurrentUrl().contains("d/myaccount")){
                    insertStmt.execute("INSERT INTO testcase\n" +
                            "(\"name\", status)\n" +
                            "VALUES('"+ methodName +"', true);");
                    profile.hover();
                    Thread.sleep(5000);
                }
                else{
                    insertStmt.execute("INSERT INTO testcase\n" +
                            "(\"name\", status)\n" +
                            "VALUES('"+ methodName +"', false);");
                }
            }
        } catch (SQLException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void dbSearchTest() throws SQLException, InterruptedException {
        home.closeCookie();
        catalog.navigate();
        catalog.enterSearch("Видеокарта");
        catalog.writeRegion("Нур-Султан");
        catalog.clickSearch();


        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        Statement insertStmt = connection.createStatement();
        Thread.sleep(3000);
        if(driver.getCurrentUrl().contains("q-")){
            insertStmt.execute("INSERT INTO testcase\n" +
                    "(\"name\", status)\n" +
                    "VALUES('"+ methodName +"', true);");
        }
        else{
            insertStmt.execute("INSERT INTO testcase\n" +
                    "(\"name\", status)\n" +
                    "VALUES('"+ methodName +"', false);");
        }

    }
}
