package frontend.pages;

import helpMethods.frontend.ElementHelper;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    protected ElementHelper elementHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.elementHelper = new ElementHelper(driver);
    }
}
