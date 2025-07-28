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

    @FindBy(xpath  = "//span[normalize-space()='$699.99']")
    WebElement cartItemPrice;

    @FindBy(xpath = "//div//div[3]//div[2]//div[2]//div[1]//div[1]//button[2]//*[name()='svg']")
    WebElement increaseQuantityButton;

    @FindBy(xpath  = "//div[normalize-space()='$699.99']")
    WebElement cartTotalPrice;

    @FindBy(xpath = "//p[normalize-space()='Your cart is currently empty.']")
    WebElement cartEmpty;

    @FindBy(xpath = "(//*[@class='js-qty__num R-qty-num-hide'])[3]")
    WebElement itemQuantity;


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

    public String cartEmpty() {
        return cartItemPrice.getText();
    }
    public String itemQuantity() {
        return itemQuantity.getText();
    }
}
