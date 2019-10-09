package pageobject.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetroitPage extends ProductPage {

    static int price = 0;

    @FindBy(xpath = "//*[@class='clearfix']//*[@class='current-price-value']")
    public WebElement priceDetroit;

    @FindBy(xpath = "//*[@class='btn btn-cart btn-lg']")
    public WebElement buyDetroit;

    @FindBy(xpath = "//*[@class='buttons']//*[@data-of='totalPrice']")
    public WebElement totalPrice;

    public void actions() {
        price = getDigit(priceDetroit.getText());
        buyDetroit.click();
        waitForSomeSec(10);
        Assert.assertEquals(getDigit(totalPrice.getText()) ,PlayStationPage.price + price);
        totalPrice.click();
    }
}
