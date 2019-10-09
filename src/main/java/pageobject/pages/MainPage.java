package pageobject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@id='header-search']//*[@name='q']")
    public WebElement searchPlace;

    public MainPage() {
        driver.get("https://www.dns-shop.ru/");
    }

    public void searhItems(String name){
        searchPlace.click();
        searchPlace.sendKeys(name);
        searchPlace.sendKeys(Keys.ENTER);
    }
}