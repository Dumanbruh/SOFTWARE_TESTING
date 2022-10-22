package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.aeonbits.owner.ConfigFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Catalog;
import pages.Home;
import pages.Profile;
import utils.Constants;
import utils.Screenshot;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentTest;
    protected static Connection connection;
    protected static Statement statement;
    protected static ResultSet resultSet;
    protected static ConfigProperties config = ConfigFactory.create(ConfigProperties.class);
    protected Catalog catalog;
    protected Home home;
    protected Profile profile;

    @BeforeTest
    public void setUp() throws IOException {
        Constants.HTML_REPORT_PATH = System.getProperty("user.dir") + "/src/test-output/html/Report" + System.currentTimeMillis() + ".html";
        Constants.EXCEL_PATH = System.getProperty("user.dir") + "/src/";
        extentReports = new ExtentReports();
        htmlReporter = new ExtentHtmlReporter(Constants.HTML_REPORT_PATH);
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Hostname", config.baseUrl());
        extentReports.setSystemInfo("Execution Environment", "Staging");
        extentReports.setSystemInfo("Browser", config.browser());
    }

    @BeforeClass
    public void InitDb(){
        try {
            connection = DriverManager.getConnection(config.databaseUrl(), config.databaseUser(), config.databasePassword());
            statement = connection.createStatement();
        }
        catch (Exception e){
            System.err.println( e.getClass().getName() + " : " + e.getMessage() );
        }
    }

    @BeforeMethod
    public void Init(){
        DriverSettings settings = new DriverSettings();
        settings.initDriver();
        driver = DriverSettings.driver;
        wait = DriverSettings.wait;
        catalog = new Catalog(driver, wait);
        home = new Home(driver, wait);
        profile = new Profile(driver, wait);
    }


//    @AfterMethod
//    public void TearDown(ITestResult iTestResult) throws IOException {
//        if(iTestResult.getStatus() == ITestResult.FAILURE){;
//            extentTest.log(Status.FAIL, "TEST CASE FAILED:  " + iTestResult.getName());
//            extentTest.log(Status.FAIL, "TEST CASE FAILED, ROUTE CAUSE:  " + iTestResult.getThrowable());
//            String screenshotPath = Screenshot.getBase64Screenshot(driver, iTestResult.getName());
//            extentTest.log(Status.INFO, MarkupHelper.createLabel(iTestResult.getName() + " -- FAILED, Snapshot below: ", ExtentColor.RED));
//            extentTest.log(Status.INFO, "" ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
//        }
//        else if(iTestResult.getStatus() == ITestResult.SKIP){
//            extentTest.log(Status.SKIP, "TEST CASE SKIPPED:  " + iTestResult.getName());
//        }
//        else if(iTestResult.getStatus() == ITestResult.SUCCESS){
//            extentTest.log(Status.PASS, "TEST CASE PASSED:  " + iTestResult.getName());
//        }
//        driver.quit();
//    }

    @AfterClass
    public void CloseConnection(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @AfterTest
    public void endReport() throws IOException {
        extentReports.flush();
    }
}
