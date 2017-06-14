import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;


public class Search {

    private String nameOfProduct = "iPhone";
    private By searchField = cssSelector("input[ autocomplete=\"off\"]");
    private By searchButton = cssSelector("button[name=\"rz-search-button\"]");
    private String filterName = "Apple";

    protected WebDriver driver;

    public Search(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct() {
        driver.findElement(searchField).sendKeys(nameOfProduct);
        driver.findElement(searchButton).click();
        WebElement element = driver.findElement(By.cssSelector("div[class=\"filter-active\"]"));
        Assert.assertTrue(element.getText().contains(filterName), "Product has not found!!!");

    }

    public void checkProductsInCatalog() {
        int count = 0;
        List<WebElement> allProducts = driver.findElements(By.cssSelector("div[class=\"g-i-tile g-i-tile-catalog\""));
        for (WebElement w : allProducts) {
            if (w.getText().contains(nameOfProduct)) {
                count++;
            }
        }
        Assert.assertTrue(count >= 2, "Less than 2 elements");

    }

}
