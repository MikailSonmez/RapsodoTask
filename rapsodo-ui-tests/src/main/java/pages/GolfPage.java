package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GolfPage {
    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Mobile Launch Monitor (MLM)')]")
    WebElement mlmProductLink;

    @FindBy(xpath = "//a[contains(text(),'Shop MLM')]")
    WebElement shopMLMButton;

    public GolfPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMLMProduct() {
        mlmProductLink.click();
    }

    public void clickShopMLM() {
        shopMLMButton.click();
    }
}
