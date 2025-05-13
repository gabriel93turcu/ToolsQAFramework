package frontend.pages;

import frontend.pageLocators.LoginLocators;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginProcess(String username, String password) {
        elementHelper.fillLocator(LoginLocators.usernameLocator, username);
        LoggerUtility.infoLog("The user fills username field with " + username + " value");

        elementHelper.fillLocator(LoginLocators.passwordLocator, password);
        LoggerUtility.infoLog("The user fills password field with " + password + " value");

        elementHelper.clickLocator(LoginLocators.loginLocator);
        LoggerUtility.infoLog("The user clicks on Login field");
    }
}
