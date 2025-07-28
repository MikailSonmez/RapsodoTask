package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.DriverManager;
import static org.junit.Assert.*;
import java.time.Duration;

public class RapsodoSteps {
    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);
    GolfPage golfPage = new GolfPage(driver);
    ProductPage productPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    String expectedProductPrice;

    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
       driver.manage().window().maximize(); 
        driver.get("https://rapsodo.com");
        assertTrue(driver.getCurrentUrl().contains("rapsodo.com"));
    }

    @When("the user clicks the cart icon")
    public void the_user_clicks_the_cart_icon() {
        homePage.clickCartIcon();
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        cartPage.cartEmpty();
    }

    @When("the user navigates to Golf > Mobile Launch Monitor")
    public void the_user_navigates_to_golf_mobile_launch_monitor() {
        homePage.clickGolfButton();
        golfPage.clickMLMProduct();
    }

    @And("clicks Shop MLM")
    public void clicks_shop_mlm() {
        golfPage.clickShopMLM();
    }

    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String expectedTitle) {
        assertTrue(driver.getTitle().contains(expectedTitle));
    }

    @When("the user clicks Add to Cart")
    public void the_user_clicks_add_to_cart() {
        expectedProductPrice = productPage.getProductPrice();
        productPage.clickAddToCart();
    }

    @Then("the user should be redirected to the cart screen")
    public void the_user_should_be_redirected_to_cart() {
        assertTrue(driver.getCurrentUrl().contains("cart"));
    }

    @Then("the product price should match the previous screen")
    public void the_product_price_should_match() {
        String cartPrice = cartPage.getCartItemPrice();
        assertEquals(expectedProductPrice, cartPrice);
    }

    @When("the user increases the quantity to {int}")
    public void the_user_increases_the_quantity_to(Integer quantity) {
        for (int i = 1; i < quantity; i++) {
            cartPage.increaseQuantity();
        }

    }
    @Then("the quantity of the third item should be {string}")
    public void verifyThirdItemQuantity(String expectedQuantity) {
            String actualQuantity = cartPage.itemQuantity();
            assertEquals(2, actualQuantity);
        }
    @Then("the total price should be correct")
    public void the_total_price_should_be_correct() {
        assertNotNull(cartPage.getCartTotalPrice());
        driver.quit();
    }
}
