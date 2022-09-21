package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Locators;

import java.util.List;

public class Catalog {
    WebDriver driver;
    WebDriverWait wait;

    public Catalog(WebDriver driver, WebDriverWait wait){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    By searchField = By.id(Locators.search_id);
    By searchBtn = By.name(Locators.search_button_name);

    @FindBy(className = "css-1amhcb2")
    WebElement wrapper;

    @FindBy(xpath = "//input[@data-testid='" + Locators.city_select_test_id + "']")
    WebElement regionSearch;


    public void enterSearch(String searchData){
        driver.findElement(searchField).sendKeys(searchData);
        //User should be able to see "Clear input" cross.
        Assert.assertTrue(driver.findElement(By.xpath("//button[@data-testid='" + Locators.clear_search_test_id + "']")).isDisplayed());
    }

    public void writeRegion(String searchData){
        regionSearch.sendKeys(searchData);
        Assert.assertTrue(wrapper.isDisplayed());
    }


    public void clickSearch(){
        driver.findElement(searchBtn).click();
    }




}
