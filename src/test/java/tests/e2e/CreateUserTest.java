package tests.e2e;

import modelObject.request.RequestCreateUser;
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

    @Test
    public void testMethod() {
        RequestCreateUser requestBody = new RequestCreateUser("src/test/resources/testData/CreateUserData.json");

        AccountService accountService = new AccountService();
        accountService.createAccount(requestBody);

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();

        WebElement userNameElement = driver.findElement(By.id("userName"));
        userNameElement.sendKeys(requestBody.getUserName());
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(requestBody.getPassword());
        WebElement loginElement = driver.findElement(By.id("login"));
        loginElement.click();
    }
}
