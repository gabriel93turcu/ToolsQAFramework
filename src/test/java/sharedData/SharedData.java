package sharedData;

import loggerUtility.LoggerUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SharedData {
    private String testName;

    @BeforeMethod(alwaysRun = true)
    public void prepareEnvironment() {
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTest(testName);
    }

    @AfterMethod(alwaysRun = true)
    public void clearEnvironment() {
        LoggerUtility.finishTest(testName);
    }
}
