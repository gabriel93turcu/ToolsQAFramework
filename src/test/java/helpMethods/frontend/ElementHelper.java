package helpMethods.frontend;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@AllArgsConstructor
public class ElementHelper {
    private WebDriver driver;

    private void waitForVisibleLocator(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickLocator(By locator){
        waitForVisibleLocator(locator);
        driver.findElement(locator).click();
    }

    public void fillLocator(By locator, String value) {
        waitForVisibleLocator(locator);
        driver.findElement(locator).sendKeys(value);
    }
}
