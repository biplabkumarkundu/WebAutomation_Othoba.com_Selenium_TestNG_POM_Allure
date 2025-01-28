package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public  By email_input_box = By.xpath("//form[@autocomplete='off']//input[@id='PhoneOrEmail_Popup']");

    public  By password_input_box = By.xpath("//form[@autocomplete='off']//input[@id='Password_Popup']");

    public  By signin_btn = By.xpath("//input[@id='dl-login-inpage']");

    public  By error_msg1 = By.xpath("//div[contains(text(),'Login was unsuccessful. Please correct the errors ')]");

    public By error_msg3 =By.id("PhoneOrEmail_Popup-error");



    public void navigateToLoginPage(){
        HomePage homePage = new HomePage();
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.signup_btn);
    }

}