package tests;

import org.testng.annotations.Test;
import common.BaseTest;


public class ProfileTest extends BaseTest {

    @Test
    public void DeleteFavouritesTest(){
        home.writeLogin();
        profile.navigateToFavList();
        profile.deleteFav();
    }

    @Test
    public void CreateAdvertisement(){
        extentTest = extentReports.createTest("Create advertisement test");
        home.writeLogin();
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
        home.writeLogin();
        profile.navigateToAds();
        profile.deleteAdvertisement();
        profile.skipStatisticModal();
    }

    @Test
    public void Logout(){
        extentTest = extentReports.createTest("Logout test");
        home.writeLogin();
        profile.hover();
    }

    @Test
    public void createCV(){
        home.writeLogin();
        profile.createCv();
    }

}
