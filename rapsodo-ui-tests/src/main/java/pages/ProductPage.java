package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;

    @FindBy(xpath = "//button[normalize-space()='Add to Cart']")
    WebElement addToCartButton;

    @FindBy(css = "div[class='FlexRow Gap8 AlignItemsCenter ProductStickySinglePriceWrapper'] span[class='Acumin sticky-product-price']") 
    WebElement productPrice;

    @FindBy(xpath = ".//img[@alt='MLM2PRO™']") 
    WebElement productImage;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public void clickAddToCart() {
        productImage.click();
        addToCartButton.click();
    }
}
