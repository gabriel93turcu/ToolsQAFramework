package tests.e2e;

import loggerUtility.LoggerUtility;
import modelObject.request.RequestCreateUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import services.AccountService;
import sharedData.SharedData;

import java.util.HashMap;
import java.util.Map;

public class CreateUserTest extends SharedData {

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
        LoggerUtility.infoLog("The user fills username field with " + requestBody.getUserName() + " value");

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(requestBody.getPassword());
        LoggerUtility.infoLog("The user fills password field with " + requestBody.getPassword() + " value");

        WebElement loginElement = driver.findElement(By.id("login"));
        loginElement.click();
        LoggerUtility.infoLog("The user clicks on Login field");
    }
}
