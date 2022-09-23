package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Locators;
import org.testng.annotations.Test;

import java.util.List;

public class Home {
    WebDriver driver;
    WebDriverWait wait;

    public Home(WebDriver driver, WebDriverWait wait){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    By googlePlayBy = By.id(Locators.google_play_button);
    By appleStoreBy = By.id(Locators.apple_store_button);
    By cookiesButtonBy = By.className(Locators.cookies_button);
    By moreButtonBy = By.className(Locators.more_button);
    By yourProfileButtonBy = By.id(Locators.your_profile_button);
    By loginInputBy = By.id(Locators.login_input);
    By passInputBy = By.id(Locators.pass_input);
    By loginButtonBy = By.id(Locators.login_button);

    @FindBy(xpath = "text() = 'Главные рубрики'")
    WebElement MainPageText;

    public void closeCookie(){
        driver.findElement(cookiesButtonBy).click();
    }

    public void navigate(){
        driver.findElement(By.id("headerLogo")).click();
    }

    public void clickGooglePlay(){
        driver.findElement(googlePlayBy).click();
    }

    public void clickAppleStore(){
        driver.findElement(appleStoreBy).click();
    }

    public void clickMoreButton(){
        driver.findElement(moreButtonBy).click();
    }

    public void clickYourProfile(){
        driver.findElement(cookiesButtonBy).click();
        driver.findElement(yourProfileButtonBy).click();

    }

    public void writeLogin(String login, String pwd){
        driver.findElement(cookiesButtonBy).click();
        driver.findElement(yourProfileButtonBy).click();
        driver.findElement(loginInputBy).sendKeys(login);
        driver.findElement(passInputBy).sendKeys(pwd);
        driver.findElement(loginButtonBy).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Ваши объявления']")));
    }

}
