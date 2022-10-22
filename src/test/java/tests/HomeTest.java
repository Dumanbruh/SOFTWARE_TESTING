package tests;

import common.BaseTest;
import org.testng.annotations.Test;
import utils.ExcelUtil;

import java.io.IOException;
import java.sql.SQLException;

public class HomeTest extends BaseTest {

    @Test
    public void GooglePlayButtonTest(){
        extentTest = extentReports.createTest("Click on googlePlay button test");
        home.closeCookie();
        home.clickGooglePlay();
    }

    @Test
    public void AppleStoreButtonTest(){
        extentTest = extentReports.createTest("Click on appleStire button test");
        home.closeCookie();
        home.clickAppleStore();
    }

    @Test
    public void MoreButtonTest(){
        extentTest = extentReports.createTest("Click on more button test");
        home.closeCookie();
        home.clickMoreButton();
    }

    @Test
    public void YourProfileButtonTest(){
        extentTest = extentReports.createTest("Click on your profile button test");
        home.closeCookie();
        home.clickYourProfile();
    }

    @Test
    public void RegistrationTest(){
        extentTest = extentReports.createTest("Login test");
        home.closeCookie();
        home.writeLogin(config.username(), config.password());
    }

    @Test
    public void WrongRegistrationTest(){
        extentTest = extentReports.createTest("Wrong login test");
        home.closeCookie();
        home.writeWrongLogin();
    }

    @Test
    public void resetPasswordTest(){
        extentTest = extentReports.createTest("Reset password test");
        home.closeCookie();
        home.resetPassword();
    }

    @Test
    public void facebookLogin(){
        extentTest = extentReports.createTest("Click on facebook button test");
        home.closeCookie();
        home.facebookLogin();
    }
}