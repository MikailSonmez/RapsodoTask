package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "(//*[name()='svg'])[12]")
    WebElement cartIcon;

    @FindBy(xpath = "//a[normalize-space()='GOLF']")
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
