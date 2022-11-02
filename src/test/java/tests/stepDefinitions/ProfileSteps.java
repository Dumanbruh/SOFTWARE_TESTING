package tests.stepDefinitions;

import common.DriverSettings;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Catalog;
import pages.Home;
import pages.Profile;

public class ProfileSteps {
    private WebDriver driver;

    private WebDriverWait wait;
    private Home home;

    @Before
    public void setUp(Scenario scenario){
        DriverSettings settings = new DriverSettings();
        settings.initDriver();
        driver = DriverSettings.driver;
        wait = DriverSettings.wait;
        home = new Home(driver, wait);
    }

    @When("I am on main page")
    public void i_am_on_main_page() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Главные рубрики']")));
    }

    @Then("I close the cookies")
    public void i_close_the_cookies() {
        home.closeCookie();
    }

    @Then("I go to login page")
    public void i_go_to_login_page() {
        home.navigateToLoginPage();
    }

    @Then("I write login {string}")
    public void i_write_login(String string) {
        home.writeLogin(string);
    }

    @Then("I write password {string}")
    public void i_write_password(String string) {
        home.writePassword(string);
    }

    @Then("I click on login button")
    public void i_click_on_login_button() {
        home.clickLogin();
    }

    @After
    public void tearDown(Scenario scenario){
        driver.quit();
    }
}
