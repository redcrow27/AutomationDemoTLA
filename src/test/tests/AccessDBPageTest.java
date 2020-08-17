package tests;

import base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccessDBPage;
import pages.CommonPage;
import pages.LogInPage;
import pojos.User;

import java.lang.reflect.Method;
import java.util.Set;

public class AccessDBPageTest extends BaseTest {
    AccessDBPage accessDBPage;
    CommonPage commonPage;
    User user;
    JavascriptExecutor js;
    String mainWindow_ID;
    Set<String> set;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, ITestResult result) {
        super.setUp(method, result);
        accessDBPage = new AccessDBPage(getDriver());
        commonPage = new CommonPage(getDriver());
        commonPage.clickNavBtn("User-Mgt");
        mainWindow_ID = getDriver().getWindowHandle();
        commonPage.click(commonPage.accessDb_Btn);
        set = getDriver().getWindowHandles();
        js = (JavascriptExecutor) getDriver();
        user = new User();
    }

    @Test(description = "Verifying Title of User Database Page")
    public void verifyTitle(){
        accessDBPage.windowHandle(mainWindow_ID, set);
        screenshot.takeScreenshotAndLog();
        Assert.assertEquals(getDriver().getTitle(), "User DB");
        extentTest.log(LogStatus.PASS, "Tested title: " + getDriver().getTitle() + " - with success");
    }


    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

}
