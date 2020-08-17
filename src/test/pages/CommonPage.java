package pages;

import base.BasePage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pojos.User;

import java.util.List;

public class CommonPage extends BasePage {

    WebDriver driver;
    UserMgtPage userMgtPage;

    public CommonPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "submit-btn")
    public WebElement submitBtn;

    @FindBy(xpath = "//input[@class='form-control']")
    public List<WebElement> formFiilOut;

    @FindBy(id = "Select-role")
    public WebElement selectBtn;

    @FindBy(id ="login-btn")
    public WebElement login_Btn;

    @FindBy(id ="access-db-btn")
    public WebElement accessDb_Btn;

    public void clickNavBtn(String buttonName) {
        click(driver.findElement(By.linkText(buttonName)));
    }

    public WebElement findById(String id) {
        return driver.findElement(By.id(id));
    }

    public void selectByText(String text) {
        click(selectBtn);
        Select select = new Select(selectBtn);
        select.selectByVisibleText(text);
    }

    public void fiilForm(String firstName, String lastName, String phoneNumber, String email, String role) {
        sendKeys(formFiilOut.get(0), firstName);
        sendKeys(formFiilOut.get(1), lastName);
        sendKeys(formFiilOut.get(2), phoneNumber);
        sendKeys(formFiilOut.get(3), email);
        selectByText(role);
        click(submitBtn);
    }



}
