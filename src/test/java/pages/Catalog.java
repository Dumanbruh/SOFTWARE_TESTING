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

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Catalog {
    WebDriver driver;
    WebDriverWait wait;

    Random rand = new Random();

    public Catalog(WebDriver driver, WebDriverWait wait){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    By searchField = By.id("search");
    By searchBtn = By.name("searchBtn");

    @FindBy(xpath = "//input[@data-testid='location-search-input']")
    WebElement regionSearch;

    @FindBy(className = "css-1qvyz1h")
    WebElement categorySelect;

    @FindBy(className = "css-1bjsvqt")
    WebElement categoryList;

    @FindBy(className = "css-c5h5gn")
    WebElement filtersWrapper;

    @FindBy(className = "css-19vlskm")
    WebElement subCategoryWrapper;


    @FindBy(xpath = "//div[@role='tablist']")
    WebElement tabList;

    @FindBy(xpath = "//div[@data-testid='listing-grid']")
    WebElement advertisementGrid;

    @FindBy(xpath = "//span[@data-testid='adAddToFavorites']")
    List<WebElement> favBtn;

    @FindBy(className = "css-1xqxmn3")
    WebElement recomendationSelect;

    @FindBy(xpath = "//div[@data-testid='flyout-content']")
    WebElement recomendationList;

    By searchInput = By.id("headerSearch");
    By searchButton = By.id("submit-searchmain");

    //Main page
    @FindBy(xpath = "//div[@class='li fleft']")
    List<WebElement> mainCategories;



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
        Assert.assertTrue(driver.findElement(By.xpath("//button[@data-testid='clear-btn']")).isDisplayed());
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
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("range-from-input"))));
        driver.findElement(By.name("range-from-input")).click();
        driver.findElement(By.name("range-from-input")).sendKeys(minSum.toString());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='flyout-content']")).isDisplayed());
    }

    public void inputMaxSum(Integer maxSum){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("range-to-input"))));
        driver.findElement(By.name("range-to-input")).click();
        driver.findElement(By.name("range-to-input")).sendKeys(maxSum.toString());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-testid='flyout-content']")).isDisplayed());
    }



    public void addToFav(){
        favBtn.get(rand.nextInt(favBtn.size())).click();
    }


    public void enterSearchMain(String searchData){
        driver.findElement(searchInput).sendKeys(searchData);
    }
    public void clickSearchMain(){
        driver.findElement(searchButton).click();
    }

    public void recomendationFilter(){
        recomendationSelect.click();
        wait.until(ExpectedConditions.visibilityOf(recomendationList));
    }

    public void selectAppearance(){
        List<WebElement> categories = recomendationList.findElements(By.tagName("div"));
        System.out.println(categories.size());
        Actions action = new Actions(driver);

        action.moveToElement(categories.get(rand.nextInt(categories.size()))).perform();
    }




}
