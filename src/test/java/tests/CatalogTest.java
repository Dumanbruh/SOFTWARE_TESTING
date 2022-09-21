package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Catalog;

import java.time.Duration;

public class CatalogTest {
    WebDriver driver;
    WebDriverWait wait;
    Catalog catalog;
    private final String url = "https://www.olx.kz/d/elektronika/";

    @BeforeTest
    public void InitDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        catalog = new Catalog(driver, wait);
    }

    @Test
    public void SearchTest(){
        driver.get(url);

        catalog.enterSearch("Видеокарта");
        catalog.writeRegion("Нур-Султан");
//        catalog.clickSearch();
    }



//    @AfterTest
//    public void TearDown(){
//        driver.quit();
//    }

}
