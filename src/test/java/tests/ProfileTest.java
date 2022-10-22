package tests;

import org.testng.annotations.Test;
import common.BaseTest;


public class ProfileTest extends BaseTest {

    @Test
    public void DeleteFavouritesTest(){
        extentTest = extentReports.createTest("Delete favourites test");
        home.writeLogin(config.username(), config.password());
        profile.navigateToFavList();
        profile.deleteFav();
    }

    @Test
    public void CreateAdvertisement(){
        extentTest = extentReports.createTest("Create advertisement test");
        home.writeLogin(config.username(), config.password());
        profile.navigateToCreationPage();
        profile.enterProductName("Продам телевизор");
        profile.openCategoryModal();
        profile.chooseSuggestedCategory();
        profile.enterDescription("Продам бас гитару в отличном состояний. В комплекте чехол + струны + каподастр + медиатор. Торг уместен");
        profile.enterPrice("10000");
        profile.chooseSeller();
        profile.chooseState();
        profile.chooseRequiredSelects();
        profile.enterLocation("Усть");
        profile.submitCreation();
    }

    @Test
    public void DeleteAdvertisement(){
        extentTest = extentReports.createTest("Delete advertisement test");
        home.writeLogin(config.username(), config.password());
        profile.navigateToAds();
        profile.deleteAdvertisement();
        profile.skipStatisticModal();
    }

    @Test
    public void Logout() throws InterruptedException {
        extentTest = extentReports.createTest("Logout test");
        home.writeLogin(config.username(), config.password());
        profile.hover();
    }

    @Test
    public void createCV(){
        home.writeLogin(config.username(), config.password());
        profile.createCv();
    }

}
