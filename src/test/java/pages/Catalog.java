package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Locators;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Catalog {
    WebDriver driver;
    WebDriverWait wait;

    Random rand = new Random();

    public Catalog(WebDriver driver, WebDriverWait wait){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    By searchField = By.id(Locators.search_id);
    By searchBtn = By.name(Locators.search_button_name);

    @FindBy(xpath = "//input[@data-testid='" + Locators.city_select_test_id + "']")
    WebElement regionSearch;

    @FindBy(className = "css-1qvyz1h")
    WebElement categorySelect;

    @FindBy(className = "css-1bjsvqt")
    WebElement categoryList;

    @FindBy(className = "css-c5h5gn")
    WebElement filtersWrapper;

    @FindBy(className = "css-19vlskm")
    WebElement subCategoryWrapper;

    @FindBy(xpath = "//button[@data-testid='" + Locators.catalog_cookies_button + "']")
    WebElement cookieCloseButton;

    @FindBy(xpath = "//div[@role='"+ Locators.tab_list_role +"']")
    WebElement tabList;

    @FindBy(xpath = "//div[@data-testid='" + Locators.advertisement_grid_id +"']")
    WebElement advertisementGrid;

    @FindBy(xpath = "//span[@data-testid='" + Locators.add_to_fav_btn_id +"']")
    List<WebElement> favBtn;


    //Main page
    @FindBy(xpath = "//div[@class='li fleft']")
    List<WebElement> mainCategories;

    public void closeCookies(){
        cookieCloseButton.click();
    }

    public void navigate(){
        WebElement category = mainCategories.get(rand.nextInt(mainCategories.size()));
        category.click();
        if(Objects.equals(driver.findElement(By.tagName("h3")).getText(), "Главные рубрики")){
            String categoryId = category.findElement(By.tagName("a")).getAttribute("data-id");
            WebElement subCategory = driver.findElement(By.xpath("//div[@data-subcategory='" + categoryId + "']"));
            if(subCategory.getCssValue("display").equals("block")){
                List<WebElement> subCategoryElements = subCategory.findElements(By.xpath("//a[@data-category-id='"+ categoryId +"']"));
                subCategoryElements.get(rand.nextInt(subCategoryElements.size())).click();
            }
        }
        wait.until(ExpectedConditions.visibilityOf(advertisementGrid));
    }

    public void enterSearch(String searchData){
        driver.findElement(searchField).sendKeys(searchData);
        //User should be able to see "Clear input" cross.
        Assert.assertTrue(driver.findElement(By.xpath("//button[@data-testid='" + Locators.clear_search_test_id + "']")).isDisplayed());
    }

    public void writeRegion(String searchData){
        regionSearch.click();
        regionSearch.sendKeys(searchData);
    }

    public void clickSearch(){
        driver.findElement(searchBtn).click();
    }

    public void hoverFilter(){
        categorySelect.click();
        wait.until(ExpectedConditions.visibilityOf(categoryList));
    }

    public void selectCategory(){
        hoverFilter();

        WebElement categoriesWrapper = categoryList.findElement(By.className("css-1g9b9fl"));
        List<WebElement> categories = categoriesWrapper.findElements(By.tagName("li"));
        Actions action = new Actions(driver);

        action.moveToElement(categories.get(rand.nextInt(categories.size()))).perform();

        if(subCategoryWrapper.isDisplayed()){
            List<WebElement> subCategories = subCategoryWrapper.findElements(By.tagName("li"));
            subCategories.get(rand.nextInt(subCategories.size())).click();
        }

        if(filtersWrapper.findElements(By.className("css-127pph6")).size() > 0){
            System.out.println("Filters are appeared!");
        }
    }

    public void selectSeller(){
        tabList.findElements(By.tagName("button")).get(ThreadLocalRandom.current().nextInt(0, 3)).click();
    }

    public void inputMinSum(Integer minSum){
        driver.findElement(By.name(Locators.min_sum_input_name)).click();
        driver.findElement(By.name(Locators.min_sum_input_name)).sendKeys(minSum.toString());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='" + Locators.sum_dropdown + "']")).isDisplayed());
    }

    public void inputMaxSum(Integer maxSum){
        driver.findElement(By.name(Locators.max_sum_input_name)).click();
        driver.findElement(By.name(Locators.max_sum_input_name)).sendKeys(maxSum.toString());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='" + Locators.sum_dropdown + "']")).isDisplayed());
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@data-testid='" + Locators.clear_btn_id + "']"))));
//        wait.until(ExpectedConditions.visibilityOf(tabList));
    }



    public void addToFav(){
        favBtn.get(rand.nextInt(favBtn.size())).click();
//        WebElement favSnackbar = driver.findElement(By.xpath("//div[@data-testid='" + Locators.add_to_fav_snackbar_id + "']"));
//
//        Assert.assertTrue(favSnackbar.isDisplayed());
    }




}
