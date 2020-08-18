package tests;

import base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UserDatabasePage;
import pages.CommonPage;
import pojos.User;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

public class UserDatabasePageTest extends BaseTest {
    UserDatabasePage userDatabasePage;
    CommonPage commonPage;
    User user;
    JavascriptExecutor js;
    String mainWindow_ID;
    Set<String> set;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, ITestResult result) {
        super.setUp(method, result);
        userDatabasePage = new UserDatabasePage(getDriver());
        commonPage = new CommonPage(getDriver());
        commonPage.clickNavBtn("User-Mgt");
        mainWindow_ID = getDriver().getWindowHandle();
        commonPage.click(commonPage.accessDb_Btn);
        set = getDriver().getWindowHandles();
        js = (JavascriptExecutor) getDriver();
        user = new User();
        userDatabasePage.windowHandle(mainWindow_ID, set);
    }

    @Test(description = "Verifying Title of User Database Page")
    public void verifyTitle(){
        screenshot.takeScreenshotAndLog();
        Assert.assertEquals(getDriver().getTitle(), "User DB");
        extentTest.log(LogStatus.PASS, "Tested title: " + getDriver().getTitle() + " - with success");
    }

    @Test(description = "verify all fields in registration from are as table row headers")
    public void verifyTableHeaders() {
        for (int i = 0; i < commonPage.headerName.length; i++) {
            extentTest.log(LogStatus.INFO, "Registration table header row has: " + commonPage.headerName[i]);
        }
        screenshot.takeScreenshotAndLog();
        Assert.assertTrue(commonPage.compareArrAndList(commonPage.headerName, commonPage.headRow_DB));

        for (int i = 0; i < commonPage.headRow_DB.size() - 1; i++) {
            extentTest.log(LogStatus.PASS, "User Database table header row contains: " + commonPage.headRow_DB.get(i).getText());
        }
    }

    @Test(description = "verify 3 records are present with no edit or delete option")
    public void verifyDeleteOption(){
        userDatabasePage.moveIntoView(userDatabasePage.rows.get(0));
        screenshot.takeScreenshotAndLog();
        Assert.assertTrue(userDatabasePage.checkEditDeleteBtn(userDatabasePage.rows));
        extentTest.log(LogStatus.PASS, "Tested first 3 rows does not have Edit and Delete button: " +
                userDatabasePage.checkEditDeleteBtn(userDatabasePage.rows));

    }


    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

}
