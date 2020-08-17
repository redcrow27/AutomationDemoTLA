package tests;

import base.BaseTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccessDBPage;
import pages.CommonPage;
import pages.LogInPage;
import pojos.User;

import java.lang.reflect.Method;

public class AccessDBPageTest extends BaseTest {
    AccessDBPage accessDBPage;
    CommonPage commonPage;
    User user;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, ITestResult result) {
        super.setUp(method, result);
        accessDBPage = new AccessDBPage(getDriver());
        commonPage = new CommonPage(getDriver());
        commonPage.clickNavBtn("User-Mgt");
        commonPage.click(commonPage.accessDb_Btn);
        user = new User();
    }




    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

}
