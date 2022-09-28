package tests;

import common.BaseTest;
import org.testng.annotations.Test;

public class CatalogTest extends BaseTest {

    @Test
    public void SearchTest(){
        extentTest = extentReports.createTest("Search test");
        home.closeCookie();
        catalog.navigate();
        catalog.enterSearch("Видеокарта");
        catalog.writeRegion("Нур-Султан");
        catalog.clickSearch();
    }

    @Test
    public void FilterTest(){
        extentTest = extentReports.createTest("Filtering test");
        home.closeCookie();
        catalog.navigate();
        catalog.selectCategory();
        catalog.inputMinSum(100);
        catalog.inputMaxSum(5000);
    }

    @Test
    public void FavouritesTest(){
        extentTest = extentReports.createTest("Add to favourites test test");
        home.writeLogin();
        home.navigate();
        catalog.navigate();
        catalog.addToFav();
    }

    @Test
    public void SortingTest(){
        extentTest = extentReports.createTest("Sorting test");
        home.closeCookie();
        catalog.enterSearchMain("iPhone");
        catalog.clickSearchMain();
        catalog.recomendationFilter();
        catalog.selectAppearance();
    }



}
