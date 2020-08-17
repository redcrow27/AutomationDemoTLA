package tests;

import base.BaseTest;
import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.UserMgtPage;
import pojos.User;

import java.lang.reflect.Method;

public class UserMgtPageTest extends BaseTest {
    UserMgtPage userMgtPage;
    CommonPage commonPage;
    User user;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, ITestResult result) {
        super.setUp(method, result);
        userMgtPage = new UserMgtPage((getDriver()));
        commonPage = new CommonPage(getDriver());
        commonPage.clickNavBtn("User-Mgt");
        user = new User();
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

    @Test(description = "Verifying filling out the form")
    public void verifyFillingOutFieldsAndDelete(){
        String selectRole = "Instructor";
        commonPage.fiilForm(user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail(), selectRole);
        userMgtPage.moveIntoView(userMgtPage.dataTable);
        screenshot.takeScreenshotAndLog();

        String[] str = {user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail(), selectRole};
        for(int i = 0; i < userMgtPage.tableInput.size(); i++) {
            extentTest.log(LogStatus.PASS,  userMgtPage.fName[i] + " has value: " +
                    userMgtPage.tableInput.get(i).getText() + " and my object's " + userMgtPage.fName[i] + ": " + str[i]);
        }

        userMgtPage.click(userMgtPage.clearBtn);
        Assert.assertEquals(userMgtPage.dataTable.getText().length(), 0);
        screenshot.takeScreenshotAndLog();
        extentTest.log(LogStatus.PASS, "Tested table is empty");
    }

    @Test(description = "verify Clear_table button will clear all records from the table")
    public void verifyClearBtn(){
        String selectRole = "Student";
        commonPage.fiilForm(user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail(), selectRole);
        userMgtPage.moveIntoView(userMgtPage.dataTable);
        screenshot.takeScreenshotAndLog();

        String[] firstValue = new String[userMgtPage.tableInput.size()];
        for(int i = 0; i < userMgtPage.tableInput.size(); i++) {
           firstValue[i] = userMgtPage.tableInput.get(i).getText();
           extentTest.log(LogStatus.INFO, "Current " + userMgtPage.fName[i] + ": " +userMgtPage.tableInput.get(i).getText() );
        }

        userMgtPage.click(userMgtPage.clearBtn);
        Assert.assertEquals(userMgtPage.tableInput.size(), 0);
        screenshot.takeScreenshotAndLog();
        for(int i = 0; i < userMgtPage.tableClmName.size(); i++) {
            extentTest.log(LogStatus.PASS, userMgtPage.fName[i] +" was " + firstValue[i] +
                    " after click Clear button current value: " + userMgtPage.dataTable.getText() + " - is empty");
        }
    }

    @Test(description = "verify Submit_table button will clear all records from the table")
    public void verifySubmitTableBtn() {
        String selectRole = "Mentor";
        commonPage.fiilForm(user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail(), selectRole);
        userMgtPage.moveIntoView(userMgtPage.dataTable);
        screenshot.takeScreenshotAndLog();

        String[] firstVal = new String[userMgtPage.tableInput.size()];
        for (int i = 0; i < userMgtPage.tableInput.size(); i++) {
            firstVal[i] = userMgtPage.tableInput.get(i).getText();
            extentTest.log(LogStatus.INFO, "Current " + userMgtPage.fName[i] + ": " + userMgtPage.tableInput.get(i).getText());
        }

        userMgtPage.click(userMgtPage.submitTableBtn);
        Assert.assertEquals(userMgtPage.tableInput.size(), 0);
        screenshot.takeScreenshotAndLog();
        for (int i = 0; i < userMgtPage.tableClmName.size(); i++) {
            extentTest.log(LogStatus.PASS, userMgtPage.fName[i] + " was " + firstVal[i] +
                    " after click Submit_table button current value: " + userMgtPage.dataTable.getText() + " - is empty");
        }
    }

    @Test(description = "fiiling form with test data and submit")
    public void validateFillForm() {
        commonPage.fiilFormForDB();
        userMgtPage.moveIntoView(userMgtPage.dataTable);
        screenshot.takeScreenshotAndLog();
        for(int i = 0; i < userMgtPage.tableInput.size(); i++) {
            Assert.assertTrue(userMgtPage.tableInput.get(i).isDisplayed());
            extentTest.log(LogStatus.PASS, userMgtPage.fName[i] + ": " + userMgtPage.tableInput.get(i).getText() + " - is Displayed." );
        }
        userMgtPage.click(userMgtPage.submitTableBtn);
    }





    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }


}
