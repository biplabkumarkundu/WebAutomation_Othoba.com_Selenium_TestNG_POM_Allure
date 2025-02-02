package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;
import utilities.DriverSetup;

public class TestRegisterPage extends DriverSetup {

    RegisterPage registerPage=new RegisterPage();

    @BeforeMethod
    public void setup_class(){

        registerPage.navigateToRegisterPage();
    }

    @Test
    public void testRegister() throws InterruptedException {
        registerPage.writeOnElement(registerPage.phonenumber_field,"01821594858");
        registerPage.writeOnElement(registerPage.email_field,"bk@gmail.com");
      registerPage.clickOnElement(registerPage.gender_male);
      registerPage.writeOnElement(registerPage.firstname_field,"Biplab");
      registerPage.writeOnElement(registerPage.lastname_field,"Kundu");
      registerPage.selectOnElement(registerPage.day_field,"3");
      registerPage.selectOnElement(registerPage.month_field,"January");
      registerPage.selectOnElement(registerPage.year_field,"1997");
      registerPage.writeOnElement(registerPage.password,"bkkundu");
      registerPage.writeOnElement(registerPage.confirm_password,"bkkundu");
        registerPage.clickOnElement(registerPage.captcha);
      registerPage.clickOnElement(registerPage.register_btn);

//      WebElement birthDate=registerPage.getElement(registerPage.day_field);
//      Select select=new Select(birthDate);
//     // select.selectByIndex(10);
//      select.selectByVisibleText("15");
//        System.out.println(select);
      Thread.sleep(4000);
    }
}
