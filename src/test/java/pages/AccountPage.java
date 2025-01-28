package pages;

import org.openqa.selenium.By;

public class AccountPage extends BasePage{
    // public By account_text = By.xpath("//h1[normalize-space()='Account']");

    public By welcome_text = By.xpath("//p[@class='welcome-msg']");

    public By logout_btn=By.xpath("//span[normalize-space()='Log out']");
    public By account_btn = By.xpath("//a[@class='d-lg-show'][normalize-space()='My Account']");


    public void doLogout(){
        if (getElement(logout_btn).isDisplayed()){
            clickOnElement(logout_btn);
        }
    }


}