package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Catalog;
import pages.Home;
import pages.Profile;

import java.time.Duration;

public class ProfileTest {

    WebDriver driver;
    WebDriverWait wait;
    Catalog catalog;
    Home home;
    Profile profile;
    private final String url = "https://www.olx.kz/";

    @BeforeTest
    public void InitDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().maximize();
        home = new Home(driver, wait);
        profile = new Profile(driver, wait);
        driver.get(url);
    }


    @Test
    public void DeleteFavouritesTest(){
        home.writeLogin("dmarlambekov@gmail.com","qABVXr@D-*zn78K");
        profile.navigateToFavList();
        profile.deleteFav();
    }

    @Test
    public void CreateAdvertisement(){
        home.writeLogin("dmarlambekov@gmail.com","qABVXr@D-*zn78K");
        profile.navigateToCreationPage();
        profile.enterProductName("Продам наушники в отличном состояний");
        profile.openCategoryModal();
        profile.chooseSuggestedCategory();
        profile.enterDescription("Продам наушники в отличном состояний. В комплекте коробка + чехол + наушники + зарядка. Торг уместен");
        profile.enterPrice("10000");
        profile.chooseSeller();
        profile.chooseState();
        profile.chooseRequiredSelects();
        profile.enterLocation("Усть");
        profile.submitCreation();
    }

    @Test
    public void DeleteAdvertisement(){
        home.writeLogin("dmarlambekov@gmail.com","qABVXr@D-*zn78K");
        profile.navigateToAds();
        profile.deleteAdvertisement();
        profile.skipStatisticModal();
    }

    @Test
    public void hover(){
        home.writeLogin("dmarlambekov@gmail.com","qABVXr@D-*zn78K");
        profile.hover();
    }

    @Test
    public void createCV(){
        home.writeLogin("dmarlambekov@gmail.com","qABVXr@D-*zn78K");
        profile.hover();
        profile.createCv();
    }

//    @AfterTest
//    public void TearDown(){
//        driver.quit();
//    }
}
