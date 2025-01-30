package testcases;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

import javax.swing.*;

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
        System.out.println(loginPage.getElement(loginPage.error_msg).getText());
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(),"Login was unsuccessful. Please correct the errors and try again.\nPhoneNumber is not valid.");
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getAttribute("class"),"required-red mb-5 text-center login-error-list-style validation-summary-errors");

    }
    @Test
    public void testLoginWithValidPhoneNumberandInvalidPassword(){
        loginPage.writeOnElement(loginPage.email_input_box,"01821594858");
        loginPage.writeOnElement(loginPage.password_input_box,"bk12345");
        loginPage.clickOnElement(loginPage.signin_btn);
        Assert.assertTrue(loginPage.is_element_visible(loginPage.signin_btn));
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getAttribute("class"),"required-red mb-5 text-center login-error-list-style validation-summary-errors");
    }
    @Test
    public void testLoginWithInvalidPhoneNumberandValidPassword(){
        loginPage.writeOnElement(loginPage.email_input_box,"0182159485");
        loginPage.writeOnElement(loginPage.password_input_box,"bk123456");
        loginPage.clickOnElement(loginPage.signin_btn);
       // System.out.println(loginPage.getElement(loginPage.error_msg1).getText());
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(),"Login was unsuccessful. Please correct the errors and try again.\nPhoneNumber is not valid.");
        Assert.assertTrue(loginPage.is_element_visible(loginPage.signin_btn));
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getAttribute("class"),"required-red mb-5 text-center login-error-list-style validation-summary-errors");
    }
    @Test
    public void testLoginWithoutPhoneNumberAndPassword(){
        loginPage.writeOnElement(loginPage.email_input_box, "");
        loginPage.writeOnElement(loginPage.password_input_box, "");
        loginPage.clickOnElement(loginPage.signin_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.email_error_msg).getText(), "Please enter your email");
        Assert.assertTrue(loginPage.is_element_visible(loginPage.signin_btn));
        //System.out.println(loginPage.getElement(loginPage.email_error_msg).getAttribute("id"));
        Assert.assertEquals(loginPage.getElement(loginPage.email_error_msg).getAttribute("id"),"PhoneOrEmail_Popup-error");
    }

    @Test
    public void testLoginEmailAndWithoutPassword(){
        loginPage.writeOnElement(loginPage.email_input_box, "0182159485");
        loginPage.writeOnElement(loginPage.password_input_box, "");
        loginPage.clickOnElement(loginPage.signin_btn);
        Assert.assertTrue(loginPage.is_element_visible(loginPage.signin_btn));
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(),"Login was unsuccessful. Please correct the errors and try again.\nPhoneNumber is not valid.");
        System.out.println(loginPage.getElement(loginPage.error_msg).getAttribute("class"));
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getAttribute("class"),"required-red mb-5 text-center login-error-list-style validation-summary-errors");


    }

    @Test
    public void testLoginValidCredentialWithEnterKey(){ //Login with valid credential by pressing Enter key
        loginPage.writeOnElement(loginPage.email_input_box, "01821594858");
        loginPage.writeOnElement(loginPage.password_input_box, "bk123456");

        Actions actions =new Actions(getDriver());
        actions.keyDown(Keys.ENTER).build().perform();
        Assert.assertFalse(loginPage.is_element_visible(loginPage.signin_btn));
        Assert.assertTrue(homePage.is_element_visible(homePage.logout_btn));
        Assert.assertEquals(accountPage.getElement(accountPage.welcome_text).getAttribute("class"),"welcome-msg");
        Assert.assertEquals(accountPage.getElement(accountPage.account_btn).getText(),"My Account");

    }

    @Test
    public void testLoginValidCredentialAndCheckEncryptedPasswordForm(){/// login with valid credetials and verify password entered should be in encrypted form
        loginPage.writeOnElement(loginPage.email_input_box, "01821594858");
        loginPage.writeOnElement(loginPage.password_input_box, "bk123456");
        Assert.assertEquals(loginPage.getElement(loginPage.password_input_box).getAttribute("type"),"password");
        System.out.println(loginPage.getElement(loginPage.password_input_box).getAttribute("type"));
        loginPage.clickOnElement(loginPage.signin_btn);

        Assert.assertFalse(loginPage.is_element_visible(loginPage.signin_btn));
        Assert.assertTrue(homePage.is_element_visible(homePage.logout_btn));
        Assert.assertEquals(accountPage.getElement(accountPage.welcome_text).getAttribute("class"),"welcome-msg");
        Assert.assertEquals(accountPage.getElement(accountPage.account_btn).getText(),"My Account");

    }
@Test
  public void testLoginWithPhoneNumberUpperCasePassword()// Verify login with a Password that contain uppercase characters
    {
    loginPage.writeOnElement(loginPage.email_input_box, "01821594858");
    loginPage.writeOnElement(loginPage.password_input_box, "BK123456");
    loginPage.clickOnElement(loginPage.signin_btn);
    Assert.assertTrue(loginPage.is_element_visible(loginPage.signin_btn));
    Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getAttribute("class"), "required-red mb-5 text-center login-error-list-style validation-summary-errors");
    }

    @Test
    public void testLoginSpecialCharacterPhoneNumberandPassword() //Verify login with a username that includes special characters
    {
        loginPage.writeOnElement(loginPage.email_input_box, "01821594858**");
        loginPage.writeOnElement(loginPage.password_input_box, "bk123456");
        loginPage.clickOnElement(loginPage.signin_btn);
        Assert.assertTrue(loginPage.is_element_visible(loginPage.signin_btn));
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Login was unsuccessful. Please correct the errors and try again.\nPhoneNumber is not valid.");
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getAttribute("class"), "required-red mb-5 text-center login-error-list-style validation-summary-errors");
    }

    @Test
    public void testLoginBlankSpacePhoneNumberandPassword() throws InterruptedException // Verify blank space for username is taken or not
    {
        Actions actions=new Actions(getDriver());

        loginPage.writeOnElement(loginPage.email_input_box, "01821594858");
        actions.keyDown(Keys.SPACE).build().perform();

        loginPage.writeOnElement(loginPage.password_input_box, "bk123456");
        loginPage.clickOnElement(loginPage.signin_btn);
        Assert.assertTrue(loginPage.is_element_visible(loginPage.signin_btn));
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Login was unsuccessful. Please correct the errors and try again.\nPhoneNumber is not valid.");
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getAttribute("class"), "required-red mb-5 text-center login-error-list-style validation-summary-errors");

    }

}
