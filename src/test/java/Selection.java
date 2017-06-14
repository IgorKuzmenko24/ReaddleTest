import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class Selection {

    private By allProducts = cssSelector("div[class=\"g-i-tile-i-title clearfix\"");
    private By imageOfProduct = cssSelector("img[id=\"base_image\"]");
    private By descriptionProduct = cssSelector("div[class=\"b-rich-text text-description-content box-hide\"");
    private By quantityComments = cssSelector("span[class=\"m-tabs-i-comments\"]");

    protected WebDriver driver;

    public Selection(WebDriver driver) {
        this.driver = driver;
    }

    public void productPage() {
        List<WebElement> productsList = driver.findElements(allProducts);
        productsList.get(0).click();
        Assert.assertTrue(driver.findElement(descriptionProduct).isDisplayed(), "Product has not opened!!!");
        Assert.assertTrue(driver.findElement(imageOfProduct).isDisplayed(), "Product has not opened!!!");
        String comments = driver.findElement(quantityComments).getText();

        int count = 0;
        if (!comments.equals("")) {
            count = Integer.parseInt(comments);
        }
        Assert.assertTrue(count != 0, "There are no comments!");

    }

}
