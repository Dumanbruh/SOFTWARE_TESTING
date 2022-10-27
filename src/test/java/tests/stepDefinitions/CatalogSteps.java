package tests.stepDefinitions;


import common.DriverSettings;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Catalog;
import pages.Home;


public class CatalogSteps {
    private Catalog catalog;
    private Home home;
    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario){
        DriverSettings settings = new DriverSettings();
        settings.initDriver();
        driver = DriverSettings.driver;
        WebDriverWait wait = DriverSettings.wait;
        catalog = new Catalog(driver, wait);
        home = new Home(driver, wait);
    }

    @Given("user is authorized")
    public void user_is_authorized() {
        home.writeLogin("dmarlambekov@gmail.com", "qABVXr@D-*zn78K");
    }
    @Given("I go to main page")
    public void i_go_to_main_page() {
        home.navigate();
    }
    @Given("I add to favourites")
    public void i_add_to_favourites() {
        catalog.addToFav();
    }

    @Given("I choose a category")
    public void i_choose_a_category(){
        home.closeCookie();
        catalog.navigate();
    }

    @Given("I enter item name {string}")
    public void i_enter_item_name(String string){
        catalog.enterSearch(string);
    }

    @Given("I enter city name {string}")
    public void i_enter_city_name(String string){
        catalog.writeRegion(string);
    }

    @When("I click on search button")
    public void i_click_on_search_button(){
        catalog.clickSearch();
    }

    @Then("Items list should update")
    public void items_list_should_update() {
        catalog.gridIsShown();
    }

    @Given("I select a category in Catalog page")
    public void i_select_a_category_in_catalog_page() {
        catalog.selectCategory();
    }
    @Given("I enter max sum {int}")
    public void i_enter_max_sum(Integer int1) {
        catalog.inputMaxSum(int1);
    }
    @Given("I enter min sum {int}")
    public void i_enter_min_sum(Integer int1) {
        catalog.inputMinSum(int1);
    }


    @After
    public void tearDown(Scenario scenario){
        driver.quit();
    }

}
