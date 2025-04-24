package tests.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import services.AccountService;

import java.util.HashMap;
import java.util.Map;

public class CreateUserTest {

    private static final Logger log = LoggerFactory.getLogger(CreateUserTest.class);

    @Test
    public void testMethod() {
        String userName = "GabiTest" + System.currentTimeMillis();
        String password = "Password!123";
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("userName", userName);
        requestBody.put("password", password);

        AccountService accountService = new AccountService();
        accountService.createAccount(requestBody);

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();

        WebElement userNameElement = driver.findElement(By.id("userName"));
        userNameElement.sendKeys(userName);
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(password);
        WebElement loginElement = driver.findElement(By.id("login"));
        loginElement.click();
    }
}
