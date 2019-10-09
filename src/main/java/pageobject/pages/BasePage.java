package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.InitDrv;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage() {
        driver = InitDrv.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 40,1000);
    }

    public WebElement waitForVisibility(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickable(WebElement element) {
       return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForSomeSec(int seconds) {
        wait = new WebDriverWait(driver, seconds, 1000);
    }
}