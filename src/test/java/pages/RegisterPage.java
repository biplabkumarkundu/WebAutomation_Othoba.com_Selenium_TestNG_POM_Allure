package pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage{

    public By phonenumber_field= By.xpath("//input[@id='Phone']");

    public By email_field=By.xpath("//input[@id='Email']");

    public By gender=By.xpath("//label[normalize-space()='Gender']");

    public By gender_male=By.xpath("//label[normalize-space()='Male']");

    public By gender_female=By.xpath("//label[normalize-space()='Female']");

    public By firstname_field=By.xpath("//input[@id='FirstName']");

    public By lastname_field=By.xpath("//input[@id='LastName']");

    public By date_of_birth=By.xpath("//label[normalize-space()='Date of birth:']");

    public By day_field=By.xpath("//select[@name='DateOfBirthDay']");

    public By month_field=By.xpath("//select[@name='DateOfBirthMonth']");

    public By year_field=By.xpath("//select[@name='DateOfBirthYear']");

    public By password=By.xpath("//input[@id='Password']");

    public By confirm_password=By.xpath("//input[@id='ConfirmPassword']");
    public By captcha=By.xpath("//div[@id='captcha_681483463']");

    public By register_btn=By.xpath("//button[@id='register-button']");

    public void navigateToRegisterPage(){
        HomePage homePage = new HomePage();
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.register_btn);
    }




}
