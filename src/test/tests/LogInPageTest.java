package tests;

import base.BaseTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LogInPage;
import pages.UserMgtPage;
import pojos.User;

import java.lang.reflect.Method;

public class LogInPageTest extends BaseTest {
    LogInPage logInPage;
    CommonPage commonPage;
    User user;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, ITestResult result) {
        super.setUp(method, result);
        logInPage = new LogInPage(getDriver());
        commonPage = new CommonPage(getDriver());
        commonPage.clickNavBtn("User-Mgt");
        commonPage.click(commonPage.login_Btn);
        user = new User();
    }

    @Test
    public void validateEnterPage() {

    }


    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

}
