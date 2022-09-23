package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Locators;

import java.util.List;
import java.util.Random;

public class Profile {
    WebDriver driver;

    WebDriverWait wait;

    Random random = new Random();

    @FindBy(className = "removeObservedAd")
    List<WebElement> removeAdBtn;

    @FindBy(xpath = "//a[@data-cy='myolx-link']")
    WebElement profileBtn;

    @FindBy(className = "css-bkyudi")
    WebElement favListBtn;

    @FindBy(xpath = "//button[@data-cy='post-new-ad-button']")
    WebElement createAdPageBtn;

    @FindBy(xpath = "//textarea[@data-testid='" + Locators.product_name_id + "']")
    WebElement productNameInput;

    @FindBy(xpath = "//div[@data-cy='" + Locators.category_button_id +"']")
    WebElement openCategoryBtn;

    @FindBy(xpath = "//ul[@data-testid='" + Locators.suggested_categories_id + "']")
    List<WebElement> suggestedCategoriesList;

    @FindBy(xpath = "//textarea[@data-testid='" + Locators.description_id + "']")
    WebElement descriptionInput;

    @FindBy(xpath = "//input[@data-testid='" + Locators.price_input_id +"']")
    WebElement priceInput;

    @FindBy(xpath = "//div[@class='css-iogeva']")
    List<WebElement> requiredSelects;

    @FindBy(xpath = "//div[@class='css-1mzzuk6']")
    List<WebElement> requiredFields;

    @FindBy(xpath = "//input[@data-cy='location-search-input']")
    WebElement locationField;

    @FindBy(xpath = "//button[@data-cy='" + Locators.submitAll_btn_id + "']")
    WebElement submitAll;

    @FindBy(xpath = "//button[@data-testid='submit-btn']")
    WebElement submitCreationBtn;

    @FindBy(xpath = "//button[@aria-label='" + Locators.delete_add_btn_label +"']")
    List<WebElement> deleteAdBtns;

    @FindBy(className = "css-1c2kok2-BaseStyles")
    WebElement skipStatisticBtn;

    @FindBy(xpath = "//div[@data-testid='" + Locators.locations_list_id +"']")
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
        wait.until(ExpectedConditions.visibilityOfAllElements(suggestedCategoriesList));
        List<WebElement> btnList = suggestedCategoriesList.get(0).findElements(By.tagName("button"));
        btnList.get(2).click();
        suggestedCategoriesList.get(1).findElements(By.tagName("li")).get(7).click();
        suggestedCategoriesList.get(2).findElements(By.tagName("li")).get(1).click();

//        for(int i = 0; i < suggestedCategoriesList.size(); i++){
//            List<WebElement> subCategories = suggestedCategoriesList.get(i).findElements(By.tagName("li"));
//            subCategories.get(random.nextInt(subCategories.size())).click();
//        }
//        List<WebElement> subCategories = suggestedCategoriesList.get(1).findElements(By.tagName("li"));
//        subCategories.get(random.nextInt(subCategories.size())).click();
//        if(suggestedCategoriesList.get(2).findElements(By.tagName("li")).size() > 0){
//            List<WebElement> subSubCategories = suggestedCategoriesList.get(2).findElements(By.tagName("li"));
//            subSubCategories.get(random.nextInt(subSubCategories.size())).click();
//        }
//        if(suggestedCategoriesList.get(3).findElements(By.tagName("li")).size() > 0){
//            List<WebElement> subsubSubCategories = suggestedCategoriesList.get(3).findElements(By.tagName("li"));
//            subsubSubCategories.get(random.nextInt(subsubSubCategories.size())).click();
//        }

    }

    public void enterDescription(String productDescription){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        List<WebElement> buttons = requiredFields.get(1).findElements(By.tagName("button"));
        buttons.get(random.nextInt(buttons.size())).click();
    }

    public void enterLocation(String location){
        locationField.sendKeys(location);
//        wait.until(ExpectedConditions.visibilityOfAllElements(locationsWrapper));
//        locationsWrapper.findElements(By.tagName("li")).get(2).submit();
    }

    public void hover(){
        WebElement mainMenu = driver.findElement(By.linkText("Ваш профиль"));

        Actions actions = new Actions(driver);
        actions.moveToElement(mainMenu).perform();

        WebElement subMenu = driver.findElement(By.xpath("//a[contains(text(),'Профиль кандидата')]"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }

    public void createCv(){
        WebElement cv = driver.findElement(By.xpath("//a[contains(text(),'Создайте ваш профиль кандидата')]"));
        cv.click();
        WebElement addinf = driver.findElement(By.className("css-1ipeylj-BaseStyles"));
        addinf.click();
        WebElement name = driver.findElement(By.name("firstName"));
        WebElement sname = driver.findElement(By.name("lastName]"));
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
            requiredFieldElementsList.findElements(By.className("css-8bnjc8")).get(1).click();
        }
    }

    public void submitCreation(){
        submitCreationBtn.click();
//        wait.until(ExpectedConditions.visibilityOf(confirmationModal));
//        okBtn.click();
        wait.until(ExpectedConditions.visibilityOf(submitAll));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        submitAll.click();
    }




}
