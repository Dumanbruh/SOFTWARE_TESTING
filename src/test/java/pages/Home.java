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

public class Home {
    WebDriver driver;
    WebDriverWait wait;


    ConfigProperties config = ConfigFactory.create(ConfigProperties.class);

    public Home(WebDriver driver, WebDriverWait wait){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    By googlePlayBy = By.id("footerAppAndroid");
    By appleStoreBy = By.id("footerAppIphone");
    By cookiesButtonBy = By.className("cookiesBarClose");
    By moreButtonBy = By.className("footer-business-partner__btn");
    By yourProfileButtonBy = By.id("topLoginLink");
    By loginInputBy = By.id("userEmail");
    By passInputBy = By.id("userPass");
    By loginButtonBy = By.id("se_userLogin");

    By logoutButtonBy = By.linkText("Выйти");
    By forgotPasswordBy = By.className("login-form__lostpassword");
    By forgotUsernameBy = By.id("username");
    By newPasswordBy = By.id("password");
    By changePasswordBy = By.id("se_userSignIn");
    By facebookBy = By.className("login-button--facebook");
    By facebookUsername = By.id("email");
    By facebookPassword = By.id("pass");
    By facebookSubmit = By.id("loginbutton");


    @FindBy(xpath = "text() = 'Главные рубрики'")
    WebElement MainPageText;

    @FindBy(xpath = "//a[@href='/']")
    WebElement logo;

    public void closeCookie(){
        driver.findElement(cookiesButtonBy).click();
    }

    public void navigate(){
        wait.until(ExpectedConditions.elementToBeClickable(logo));
        logo.click();
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

    public void writeLogin(String login){
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonBy));
        driver.findElement(loginInputBy).sendKeys(login);
    }

    public void writePassword(String password){
        wait.until(ExpectedConditions.elementToBeClickable(passInputBy));
        driver.findElement(passInputBy).sendKeys(password);
    }

    public void navigateToLoginPage(){
        driver.findElement(yourProfileButtonBy).click();
    }

    public void clickLogin(){
        driver.findElement(loginButtonBy).click();
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
    public void writeLogin(String login, String password){
        driver.findElement(yourProfileButtonBy).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonBy));
        driver.findElement(loginInputBy).sendKeys(login);
        wait.until(ExpectedConditions.elementToBeClickable(passInputBy));
        driver.findElement(passInputBy).sendKeys(password);
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
