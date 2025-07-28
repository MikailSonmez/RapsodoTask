package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GolfPage {
    WebDriver driver;

    @FindBy(xpath = "//li[@class='BoxedLink Text6 Noselect OpenMenu BarlowSemibold Active']")
    WebElement mlmProductLink;

    @FindBy(xpath = "//div[@id='ProductsMenu']//a[contains(text(),'Launch')]")
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
