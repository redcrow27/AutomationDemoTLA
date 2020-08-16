package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.lang.reflect.Method;

public class HomePageTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, ITestResult result) {
        super.setUp(method, result);
        homePage = new HomePage(getDriver());
    }



    @AfterMethod
    public void tearDown(){
        screenshot.takeScreenshotAndLog();
        getDriver().quit();
    }


}
