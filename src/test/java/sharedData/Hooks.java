package sharedData;

import loggerUtility.LoggerUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import suites.AtfSuite;

public class Hooks {
    private String testName;
    public DriverService driverService;

    @BeforeMethod(alwaysRun = true)
    public void prepareEnvironment() {
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTest(testName);
    }

    @BeforeMethod(onlyForGroups = {AtfSuite.FE_SUITE, AtfSuite.E2E_SUITE})
    public void prepareFeEnvironment() {
        driverService = new DriverService();
        driverService.prepareDriver();
    }

    @AfterMethod(onlyForGroups = {AtfSuite.FE_SUITE, AtfSuite.E2E_SUITE})
    public void clearFeEnvironment() {
        driverService.quitDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void clearEnvironment() {
        LoggerUtility.finishTest(testName);
    }
}
