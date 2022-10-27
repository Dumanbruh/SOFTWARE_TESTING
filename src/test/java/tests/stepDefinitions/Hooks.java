package tests.stepDefinitions;

import common.DriverSettings;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected void setUp(Scenario scenario){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get("https://www.olx.kz");
    }

    protected void tearDown(Scenario scenario){
        driver.quit();
    }
}
