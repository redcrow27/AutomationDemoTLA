package tests;

import base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.UserMgtPage;

import java.lang.reflect.Method;

public class UserMgtPageTest extends BaseTest {
    UserMgtPage userMgtPage;
    CommonPage commonPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, ITestResult result) {
        super.setUp(method, result);
        userMgtPage = new UserMgtPage((getDriver()));
        commonPage = new CommonPage(getDriver());
        commonPage.clickNavBtn("User-Mgt");
    }

    @Test(description = "Verifying title of User-Mgt Page")
    public void verifyTitle(){
        screenshot.takeScreenshotAndLog();
        Assert.assertEquals(getDriver().getTitle(), "Register New User");
    }

    @Test(description = "Verifying title of Login and Access DB Button")
    public void verifyLoginAndAccessBtn(){
        screenshot.takeScreenshotAndLog();
        Assert.assertTrue(userMgtPage.login_Btn.isDisplayed());
        extentTest.log(LogStatus.PASS, "Tested button: " + userMgtPage.login_Btn.getText().toUpperCase() + " - with success");

        Assert.assertTrue(userMgtPage.accessDb_Btn.isDisplayed());
        extentTest.log(LogStatus.PASS, "Tested button: " + userMgtPage.accessDb_Btn.getText().toUpperCase() + " - with success");
    }

    @Test(description = "Testing all fields are present")
    public void verifyRegFields(){
        screenshot.takeScreenshotAndLog();
        for (String field: userMgtPage.fields){
            Assert.assertTrue(commonPage.findById(field).isDisplayed());
            extentTest.log(LogStatus.PASS, "Tested field: " + commonPage.findById(field).getAttribute("name") + " - with success");
        }
    }

    @Test(description = "Verifying Data Table is Empty")
    public void verifyDataTableEmpty(){
        userMgtPage.moveIntoView(userMgtPage.dataTable);
        screenshot.takeScreenshotAndLog();
        Assert.assertEquals(userMgtPage.dataTable.getText().length(), 0);
        extentTest.log(LogStatus.PASS, "Tested Table Data: " + userMgtPage.dataTable.getText() + " - with success");

    }

    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }


}