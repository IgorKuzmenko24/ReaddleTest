import org.testng.annotations.Test;

public class TestCases extends Config {

    @Test(priority = 1)
    protected void checkFilter() {
        Search search = new Search(driver);
        search.searchProduct();
    }

    @Test(priority = 2)
    protected void checkProductsInCatalog() {
        Search search = new Search(driver);
        search.checkProductsInCatalog();
    }

    @Test(priority = 3, dependsOnMethods = "checkFilter")
    protected void checkProductPage() {
        Selection selection = new Selection(driver);
        selection.productPage();

    }

    @Test(priority = 4, dependsOnMethods = "checkProductPage")
    protected void checkBuyProduct() {
        Add add = new Add(driver);
        add.buyGood();
    }

    @Test(priority = 5, dependsOnMethods = "checkBuyProduct")
    protected void checkCart() {
        Add add = new Add(driver);
        add.checkCart();
    }

}