package tests;

import common.BaseTest;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    public void GooglePlayButtonTest(){
        home.closeCookie();
        home.clickGooglePlay();
    }

    @Test
    public void AppleStoreButtonTest(){
        home.closeCookie();
        home.clickAppleStore();
    }

    @Test
    public void MoreButtonTest(){
        home.closeCookie();
        home.clickMoreButton();
    }

    @Test
    public void YourProfileButtonTest(){
        home.closeCookie();
        home.clickYourProfile();
    }

    @Test
    public void RegistrationTest(){
        home.closeCookie();
        home.writeLogin();
    }

    @Test
    public void WrongRegistrationTest(){
        home.closeCookie();
        home.writeWrongLogin();
    }

    @Test
    public void resetPasswordTest(){
        home.closeCookie();
        home.resetPassword();
    }

    @Test
    public void faceebookLogin(){
        home.closeCookie();
        home.facebookLogin();
    }
}