package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Home;

import java.time.Duration;

public class HomeTest {
    WebDriver driver;
    WebDriverWait wait;
    Home homePage;
    private final String url = "https://www.olx.kz/";

    @BeforeTest
    public void InitDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new Home(driver, wait);
        driver.get(url);
    }

    @Test
    public void GooglePlayButtonTest(){
        homePage.clickGooglePlay();
    }

    @Test
    public void AppleStoreButtonTest(){
        homePage.clickAppleStore();
    }

    @Test
    public void MoreButtonTest(){
        homePage.clickMoreButton();
    }

    @Test
    public void YourProfileButtonTest(){
        homePage.clickYourProfile();
    }

    @Test
    public void RegistrationTest(){
        homePage.writeLogin("dmarlambekov@gmail.com","qABVXr@D-*zn78K");
    }
}