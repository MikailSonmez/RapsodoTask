package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import org.openqa.selenium.By;

public class CartPage {
    WebDriver driver;

    @FindBy(css = ".cart-item__title")
    WebElement cartItemTitle;

    @FindBy(css = ".cart-item__price")
    WebElement cartItemPrice;

    @FindBy(css = ".quantity__button--plus")
    WebElement increaseQuantityButton;

    @FindBy(css = ".cart-subtotal__price")
    WebElement cartTotalPrice;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void increaseQuantity() {
        increaseQuantityButton.click();
    }

    public String getCartTotalPrice() {
        return cartTotalPrice.getText();
    }

    public String getCartItemPrice() {
        return cartItemPrice.getText();
    }

    public boolean isCartEmpty() {
        List<WebElement> items = driver.findElements(By.cssSelector(".cart-item__title"));
        return items.isEmpty();
    }
}
