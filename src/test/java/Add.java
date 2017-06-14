import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class Add {

    private By buyButton = xpath("//*[@id=\"detail_buy_label\"]/div[4]/div[1]/div/form/span/span/button");
    private By popupBuy = cssSelector("div[class=\"popup-css popup-cart\"]");
    private By popupClose = cssSelector("a[class=\"popup-close\"]");
    private By cart = xpath("//*[@id=\"cart_popup_header\"]/div[2]");
    private By cartPopup = cssSelector("div[id=\"cart-popup\"]");
    private By quantity = cssSelector("input[name=\"quantity\"]");
    protected WebDriver driver;

    public Add(WebDriver driver) {
        this.driver = driver;
    }


    public void buyGood() {
        driver.findElement(buyButton).click();
        Config.sleep(10);
        Assert.assertTrue(driver.findElement(popupBuy).isDisplayed(), "Popup has not display!");
        Assert.assertTrue(driver.findElement(popupBuy).getText().contains("Вы добавили товар в корзину"), "Popup has not display!");
        driver.findElement(popupClose).click();

    }

    public void checkCart() {
        driver.findElement(cart).click();
        Assert.assertTrue(driver.findElement(cartPopup).isDisplayed(), "Cart has not opened!");
        int count = 0;
        String value = driver.findElement(quantity).getAttribute("value");
        if (!value.equals("")) {
            count = Integer.parseInt(value);
        }
        Assert.assertTrue(count == 1, "Product has not added!");
        Config.sleep(10);
    }

}
