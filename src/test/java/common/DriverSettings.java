package common;

import common.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverSettings {

    public static WebDriver driver;
    public static WebDriverWait wait;
    ConfigProperties config = ConfigFactory.create(ConfigProperties.class);


    public void initDriver(){
        switch (config.browser()){
            case "edge" :
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari" :
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            default :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get(config.baseUrl());
    }

}
