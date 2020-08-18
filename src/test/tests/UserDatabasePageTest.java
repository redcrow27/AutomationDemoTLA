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

    @Test(description = "Register new record in User-Msg page and click Submit table button then verify data is displayed in User Database table correctly")
    public void verifyTestDataExist() {
        userDatabasePage.moveIntoView(userDatabasePage.table.findElement(By.xpath(userDatabasePage.rXpatS(commonPage.dataForDB[0]))));
        screenshot.takeScreenshotAndLog();
        for (int i = 0; i < commonPage.dataForDB.length; i++) {
            Assert.assertEquals(userDatabasePage.table.findElement(By.xpath(userDatabasePage.rXpatS(commonPage.dataForDB[i]))).getText(),commonPage.dataForDB[i]);
            extentTest.log(LogStatus.PASS, "Previous " + commonPage.headerName[i] + " was " + commonPage.dataForDB[i] + " and Current " + commonPage.headerName[i] +
                    " is: " + userDatabasePage.table.findElement(By.xpath(userDatabasePage.rXpatS(commonPage.dataForDB[i]))).getText());
        }
    }

    @Test(description = "verify default password is in firstname.lastname$ format")
    public void verifyPasswordFormat() {
        userDatabasePage.moveIntoView(userDatabasePage.rows.get(0));
        screenshot.takeScreenshotAndLog();

        for(int i = 0; i < userDatabasePage.rows.size(); i++) {
          String name = userDatabasePage.rows.get(i).findElement(By.xpath("td[1]")).getText().toLowerCase();
          String lastName = userDatabasePage.rows.get(i).findElement(By.xpath("td[2]")).getText().toLowerCase();
          String expectedPassword = userDatabasePage.rows.get(i).findElement(By.xpath("td[6]")).getText();
          Assert.assertEquals(name + "." + lastName + "$", expectedPassword);
          extentTest.log(LogStatus.PASS, name + " and " + lastName + " Tested with firstname.lastname$ password format: " +
                   expectedPassword + " - with success");
        }
    }

    @Test(description = "verify Delete button is removing user from the db table")
    public void verifyDeleteBtn() {
    userDatabasePage.moveIntoView(userDatabasePage.deleteBtn.get(0));
    screenshot.takeScreenshotAndLog();
    int beforeClickDeleteBtn = userDatabasePage.deleteBtn.size();
    extentTest.log(LogStatus.INFO, "Tested and found " + beforeClickDeleteBtn + " delete buttons");

    userDatabasePage.click(userDatabasePage.deleteBtn.get(0));
    screenshot.takeScreenshotAndLog();
    int afterClickDeleteBtn = userDatabasePage.deleteBtn.size();
    Assert.assertNotEquals(beforeClickDeleteBtn, afterClickDeleteBtn);
    extentTest.log(LogStatus.PASS, "Tested and found after clicking one of delete button: " + afterClickDeleteBtn + " buttons left");
    }


    @AfterMethod

    public void tearDown(){
        getDriver().quit();
    }

}
