package pageobject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlayStationPage extends ProductPage {

    static int price = 0;

    @FindBy(xpath = "//*[text()[contains(.,'Slim Black')]]")
    public WebElement PSblack;

    @FindBy(xpath = "//*[@class='clearfix']//*[@class='current-price-value']")
    public WebElement pricePS;

    @FindBy(xpath = "//*[@class='form-control select']")
    public WebElement guaranteePS;

    @FindBy(xpath = "//*[@class='btn btn-cart btn-lg']")
    public WebElement buyPS;

    @FindBy(xpath = "//*[@id='header-search']//*[@name='q']")
    public WebElement searchPlace;

    public void actions() {
        PSblack.click();
        guaranteePS.sendKeys("2");
        price = getDigit(pricePS.getText());
        buyPS.click();
        searchPlace.sendKeys("detroit" + Keys.ENTER);
    }
}
