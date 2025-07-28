package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class HomePage {
    WebDriver driver;

    @FindBy(css = "a[href*='cart']")
    WebElement cartIcon;

    @FindBy(linkText = "Golf")
    WebElement golfButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    public void clickGolfButton() {
        golfButton.click();
    }
}
