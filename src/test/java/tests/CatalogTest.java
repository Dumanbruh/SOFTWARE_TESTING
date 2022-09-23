package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Catalog;
import pages.Home;

import java.time.Duration;

public class CatalogTest {
    WebDriver driver;
    WebDriverWait wait;
    Catalog catalog;
    Home home;
    private final String url = "https://www.olx.kz";

    @BeforeTest
    public void InitDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        catalog = new Catalog(driver, wait);
        home = new Home(driver, wait);
        driver.get(url);
    }

    @Test
    public void SearchTest(){
        catalog.closeCookies();
        catalog.enterSearch("Видеокарта");
        catalog.writeRegion("Нур-Султан");
        catalog.clickSearch();
    }

    @Test
    public void FilterTest(){
        home.closeCookie();
        catalog.navigate();
        catalog.selectCategory();
        catalog.inputMinSum(100);
        catalog.inputMaxSum(5000);
    }

    @Test
    public void FavouritesTest(){
        home.writeLogin();
        home.navigate();
        catalog.navigate();
        catalog.addToFav();
    }



//    @AfterTest
//    public void TearDown(){
//        driver.quit();
//    }

}
