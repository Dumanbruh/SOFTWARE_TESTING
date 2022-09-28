package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class Profile {
    WebDriver driver;

    WebDriverWait wait;

    Random random = new Random();

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(className = "removeObservedAd")
    List<WebElement> removeAdBtn;

    @FindBy(xpath = "//a[@data-cy='myolx-link']")
    WebElement profileBtn;

    @FindBy(className = "css-bkyudi")
    WebElement favListBtn;

    @FindBy(xpath = "//button[@data-cy='post-new-ad-button']")
    WebElement createAdPageBtn;

    @FindBy(xpath = "//textarea[@data-testid='posting-title']")
    WebElement productNameInput;

    @FindBy(xpath = "//div[@data-cy='posting-select-category']")
    WebElement openCategoryBtn;

    @FindBy(xpath = "//ul[@data-testid='categories-list']")
    List<WebElement> customCategories;

    @FindBy(xpath = "//div[@data-cy='suggested-categories-list']")
    WebElement suggestedCategories;

    @FindBy(xpath = "//textarea[@data-testid='posting-description-text-area']")
    WebElement descriptionInput;

    @FindBy(xpath = "//input[@data-testid='price-input']")
    WebElement priceInput;

    @FindBy(xpath = "//div[@class='css-iogeva']")
    List<WebElement> requiredSelects;

    @FindBy(xpath = "//div[@class='css-1mzzuk6']")
    List<WebElement> requiredFields;

    @FindBy(xpath = "//input[@data-cy='location-search-input']")
    WebElement locationField;

    @FindBy(xpath = "//button[@data-cy='purchase-pay-button']")
    WebElement submitAll;

    @FindBy(xpath = "//button[@data-testid='submit-btn']")
    WebElement submitCreationBtn;

    @FindBy(xpath = "//button[@aria-label='Деактивировать']")
    List<WebElement> deleteAdBtns;

    @FindBy(className = "css-1c2kok2-BaseStyles")
    WebElement skipStatisticBtn;

    @FindBy(xpath = "//div[@data-testid='location-list']")
    WebElement locationsWrapper;

    @FindBy(xpath = "//button[text()='Понятно']")
    WebElement okBtn;

    @FindBy(xpath = "//div[@data-testid='location-modal']")
    WebElement confirmationModal;


    public Profile(WebDriver driver, WebDriverWait wait){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    public void navigateToFavList(){
        favListBtn.click();
    }

    public void navigateToProfile(){
        profileBtn.click();
    }

    public void navigateToAds(){
        WebElement mainMenu = driver.findElement(By.linkText("Ваш профиль"));

        Actions actions = new Actions(driver);
        actions.moveToElement(mainMenu).perform();

        WebElement subMenu = driver.findElement(By.xpath("//a[contains(text(),'Объявления')]"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }

    public void deleteFav(){
        removeAdBtn.get(random.nextInt(removeAdBtn.size())).click();
    }

    public void deleteAdvertisement(){
        deleteAdBtns.get(0).click();
    }

    public void skipStatisticModal(){
        wait.until(ExpectedConditions.visibilityOf(skipStatisticBtn));
        skipStatisticBtn.click();
    }

    public void navigateToCreationPage() {
        createAdPageBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Создать объявление']")));
    }

    public void enterProductName(String productName){
        productNameInput.sendKeys(productName);
    }

    public void openCategoryModal(){
        openCategoryBtn.click();
    }


    public void chooseSuggestedCategory(){
        wait.until(ExpectedConditions.visibilityOf(suggestedCategories));
        suggestedCategories.findElements(By.xpath("//div[@data-cy='posting-suggested-categories-item']")).get(0).click();
    }

    public void chooseNotSuggestedCategory(){
        wait.until(ExpectedConditions.visibilityOfAllElements(customCategories));
        List<WebElement> btnList = customCategories.get(0).findElements(By.tagName("button"));
        btnList.get(7).click();
        customCategories.get(1).findElements(By.tagName("li")).get(1).click();
        customCategories.get(2).findElements(By.tagName("li")).get(1).click();
//        for(int i = 0; i < suggestedCategoriesList.size(); i++){
//            List<WebElement> subCategories = suggestedCategoriesList.get(i).findElements(By.tagName("li"));
//            subCategories.get(random.nextInt(subCategories.size())).click();
//        }
    }

    public void enterDescription(String productDescription){
        js.executeScript("window.scrollBy(0,500)");
        wait.until(ExpectedConditions.elementToBeClickable(descriptionInput));
        descriptionInput.click();
        descriptionInput.sendKeys(productDescription);
    }

    public void enterPrice(String price){
        priceInput.sendKeys(price);
    }

    public void chooseSeller(){
        List<WebElement> buttons = requiredFields.get(0).findElements(By.tagName("button"));
        buttons.get(random.nextInt(buttons.size())).click();
    }

    public void chooseState(){
        js.executeScript("window.scrollBy(0,500)");
        List<WebElement> buttons = requiredFields.get(1).findElements(By.tagName("button"));
        buttons.get(random.nextInt(buttons.size())).click();
    }

    public void enterLocation(String location){
        locationField.sendKeys(location);
    }

    public void hover(){
        WebElement mainMenu = driver.findElement(By.linkText("Ваш профиль"));

        Actions actions = new Actions(driver);
        actions.moveToElement(mainMenu).perform();

        WebElement subMenu = driver.findElement(By.xpath("//a[contains(text(),'Выйти')]"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }

    public void createCv(){
        WebElement mainMenu = driver.findElement(By.linkText("Ваш профиль"));

        Actions actions = new Actions(driver);
        actions.moveToElement(mainMenu).perform();


        WebElement subMenu = driver.findElement(By.xpath("//a[contains(text(),'Профиль кандидата')]"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Профиль кандидата']")));
        WebElement cv = driver.findElement(By.xpath("//a[contains(text(),'Создайте ваш профиль кандидата')]"));
        cv.click();
        WebElement addinf = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[2]/article[1]/section[1]/button[1]"));
        addinf.click();
        WebElement name = driver.findElement(By.name("firstName"));
        WebElement sname = driver.findElement(By.name("lastName"));
        name.sendKeys("Duman");
        sname.sendKeys("LOH");
        WebElement submit = driver.findElement(By.name("css-qu3r7l-BaseStyles"));
        submit.click();
    }

    public void chooseRequiredSelects(){
        for(int i = 0; i < requiredSelects.size(); i++){
            requiredSelects.get(i).click();
            WebElement requiredFieldElementsList = requiredSelects.get(i).findElement(By.tagName("ul"));
            wait.until(ExpectedConditions.visibilityOf(requiredFieldElementsList));
            wait.until(ExpectedConditions.elementToBeClickable(requiredFieldElementsList.findElements(By.className("css-8bnjc8")).get(1)));
            requiredFieldElementsList.findElements(By.className("css-8bnjc8")).get(1).click();
        }
    }

    public void submitCreation(){
        submitCreationBtn.click();
//        wait.until(ExpectedConditions.visibilityOf(confirmationModal));
//        okBtn.click();
        wait.until(ExpectedConditions.visibilityOf(submitAll));
        js.executeScript("window.scrollBy(0,500)");
        submitAll.click();
    }




}
