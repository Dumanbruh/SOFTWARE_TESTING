package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.Catalog;
import pages.Home;
import pages.Profile;
import utils.Constants;
import utils.Screenshot;

import java.io.IOException;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentTest;
    ConfigProperties config = ConfigFactory.create(ConfigProperties.class);
    protected Catalog catalog;
    protected Home home;
    protected Profile profile;

    @BeforeTest
    public void setUp(){
        extentReports = new ExtentReports();
        Constants.HTML_REPORT_PATH = System.getProperty("user.dir") + "/src/test-output/html/Report" + System.currentTimeMillis() + ".html";
        htmlReporter = new ExtentHtmlReporter(Constants.HTML_REPORT_PATH);
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Hostname", config.baseUrl());
        extentReports.setSystemInfo("Execution Environment", "Staging");
        extentReports.setSystemInfo("Browser", config.browser());
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


    @AfterMethod
    public void TearDown(ITestResult iTestResult) throws IOException {
        if(iTestResult.getStatus() == ITestResult.FAILURE){;
            extentTest.log(Status.FAIL, "TEST CASE FAILED:  " + iTestResult.getName());
            extentTest.log(Status.FAIL, "TEST CASE FAILED, ROUTE CAUSE:  " + iTestResult.getThrowable());
            String screenshotPath = Screenshot.getBase64Screenshot(driver, iTestResult.getName());
            extentTest.log(Status.INFO, MarkupHelper.createLabel(iTestResult.getName() + " -- FAILED, Snapshot below: ", ExtentColor.RED));
            extentTest.log(Status.INFO, "" ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
        }
        else if(iTestResult.getStatus() == ITestResult.SKIP){
            extentTest.log(Status.SKIP, "TEST CASE SKIPPED:  " + iTestResult.getName());
        }
        else if(iTestResult.getStatus() == ITestResult.SUCCESS){
            extentTest.log(Status.PASS, "TEST CASE PASSED:  " + iTestResult.getName());
        }
        driver.quit();
    }


    @AfterTest
    public void endReport() {
        extentReports.flush();
    }
}
