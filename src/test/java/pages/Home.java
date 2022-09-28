package pages;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.ConfigProperties;
import utils.Locators;

public class Home {
    WebDriver driver;
    WebDriverWait wait;


    ConfigProperties config = ConfigFactory.create(ConfigProperties.class);

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
    By logoutButtonBy = By.linkText(Locators.logout_button);
    By forgotPasswordBy = By.className(Locators.forgot_password);
    By forgotUsernameBy = By.id(Locators.forgot_username);
    By newPasswordBy = By.id(Locators.new_password);
    By changePasswordBy = By.id(Locators.change_password);
    By facebookBy = By.className(Locators.facebook);
    By facebookUsername = By.id(Locators.facebook_username);
    By facebookPassword = By.id(Locators.facebook_password);
    By facebookSubmit = By.id(Locators.facebook_submit);


    @FindBy(xpath = "text() = 'Главные рубрики'")
    WebElement MainPageText;

    public void closeCookie(){
        driver.findElement(cookiesButtonBy).click();
    }

    public void navigate(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("headerLogo"))));
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

    //Test Case 5
    public void facebookLogin(){
        driver.findElement(cookiesButtonBy).click();
        driver.findElement(yourProfileButtonBy).click();
        driver.findElement(facebookBy).click();
        driver.findElement(facebookUsername).sendKeys("kamzadias31@gmail.com");
        driver.findElement(facebookPassword).sendKeys("Dias070403");
        driver.findElement(facebookSubmit).click();
    }
    //Test Case 4
    public void resetPassword(){
        driver.findElement(cookiesButtonBy).click();
        driver.findElement(yourProfileButtonBy).click();
        driver.findElement(forgotPasswordBy).click();
        driver.findElement(forgotUsernameBy).sendKeys("87476521977");
        driver.findElement(changePasswordBy).click();
        driver.findElement(newPasswordBy).sendKeys("Dias07042011");
        driver.findElement(changePasswordBy).click();
    }
    //Test Case 1
    public void writeLogin(){
        driver.findElement(cookiesButtonBy).click();
        driver.findElement(yourProfileButtonBy).click();
        driver.findElement(loginInputBy).sendKeys(config.username());
        driver.findElement(passInputBy).sendKeys(config.password());
        driver.findElement(loginButtonBy).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Ваши объявления']")));
    }

    //Test Case 2
    public void writeWrongLogin(){
        driver.findElement(cookiesButtonBy).click();
        driver.findElement(yourProfileButtonBy).click();
        driver.findElement(loginInputBy).sendKeys("dmarlambekov@gmail.com");
        driver.findElement(passInputBy).sendKeys("qABVXr@D-*zn78");
        driver.findElement(loginButtonBy).click();
    }

}
