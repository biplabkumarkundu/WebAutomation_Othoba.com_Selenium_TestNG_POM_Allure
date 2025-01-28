package testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    AccountPage accountPage=new AccountPage();


    @BeforeMethod
    public void setup_class(){

        loginPage.navigateToLoginPage();
    }

//    @AfterMethod
//    public void addTestScreenshot(){
//        loginPage.addScreenshot("After test");
//    }


    @Test
    public void testLoginWithValidCredentials(){
        loginPage.writeOnElement(loginPage.email_input_box,"01821594858");
        loginPage.writeOnElement(loginPage.password_input_box,"bk123456");
        loginPage.clickOnElement(loginPage.signin_btn);
        Assert.assertTrue(homePage.is_element_visible(homePage.logout_btn));
        Assert.assertTrue(accountPage.is_element_visible(accountPage.account_btn));
        Assert.assertEquals(accountPage.getElement(accountPage.welcome_text).getAttribute("class"),"welcome-msg");
        Assert.assertFalse(homePage.is_element_visible(homePage.register_btn));
        //System.out.println(accountPage.getElement(accountPage.welcome_text).getAttribute("class"));

    }
    @Test
    public void testLoginWithInvalidEmailAndPassword(){
        loginPage.writeOnElement(loginPage.email_input_box,"0182159485");
        loginPage.writeOnElement(loginPage.password_input_box,"bk12345");
        loginPage.clickOnElement(loginPage.signin_btn);
        Assert.assertTrue(loginPage.is_element_visible(loginPage.signin_btn));
        System.out.println(loginPage.getElement(loginPage.error_msg1).getText());
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg1).getText(),"Login was unsuccessful. Please correct the errors and try again.\nPhoneNumber is not valid.");


    }

}
