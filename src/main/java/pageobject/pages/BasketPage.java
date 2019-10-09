package pageobject.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by aasx .
 */
public class BasketPage extends BasePage {

    static int forBoth = 0;
    static int forXbox = 0;
    static int total = 0;
    static int for3XboxAndDetroit = 0;

    @FindBy(xpath = "//*[@class='buttons']//*[@data-of='totalPrice']")
    WebElement totalPrice;

    @FindBy(xpath = "//*[@class='cart-list__product-thumbnail']")
    List<WebElement> purchases;

    @FindBy(xpath = "//*[@class='cart-list__product-name-link']")
    List<WebElement> purchasesNames;

    @FindBy(xpath = "//*[@class='cart-list__products']/div[2]//*[@class='remove-button__icon']")
    WebElement deleteSecond;

    @FindBy(xpath = "//*[@class='count-buttons__icon-plus']")
    WebElement plus;

    @FindBy(xpath = "//*[text()='Вернуть удалённый товар']")
    WebElement backDeleted;

    public void actions() {
        forBoth = DetroitPage.getDigit(totalPrice.getText());
        deleteSecond.click();
        waitForSomeSec(3);
        forXbox = DetroitPage.getDigit(totalPrice.getText());
        waitForVisibility(purchases.get(0));
        Assert.assertNull(getPurchase("detroit"));
        Assert.assertEquals(forBoth - DetroitPage.price, PlayStationPage.price);
        plus.click();
        waitForSomeSec(10);
        plus.click();
        backDeleted.click();
        waitForVisibility(totalPrice);
        total = ProductPage.getDigit(totalPrice.getText());
        for3XboxAndDetroit = (3 * forXbox) + DetroitPage.price;
        Assert.assertEquals(for3XboxAndDetroit, total);
    }

    public WebElement getPurchase(String name) {
        return purchases.stream().filter(x -> x.getText().toLowerCase().
                contains(name.toLowerCase())).findFirst().orElse(null);
    }

    public void deleteFromBasket(WebElement webElement) {

    }

}

