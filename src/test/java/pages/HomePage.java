package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public String url = "https://www.othoba.com/";

    public String title = "Hassle-free online shopping in Bangladesh | Othoba.com";

    public By signup_btn = By.xpath("//a[@class='login sign-in header-design-color']");

    public By register_btn=By.xpath("//a[normalize-space()='Register']");

    public By logout_btn=By.xpath("//span[normalize-space()='Log out']");

    public void loadHomePage(){

        loadAWebPage(url);
    }


}