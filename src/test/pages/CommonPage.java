package pages;

import base.BasePage;
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
    User user = new User();

    public CommonPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickNavBtn(String buttonName) {
        click(driver.findElement(By.linkText(buttonName)));
    }

    public WebElement findById(String id) {
        return driver.findElement(By.id(id));
    }

    @FindBy(xpath = "//input[@class='form-control']")
    public List<WebElement> formFiilOut;

    public void fiilForm(String firstName, String lastName, String phoneNumber, String email) {
        sendKeys(formFiilOut.get(0), firstName);
        sendKeys(formFiilOut.get(1), lastName);
        sendKeys(formFiilOut.get(2), phoneNumber);
        sendKeys(formFiilOut.get(3), email);
    }

    @FindBy(id = "Select-role")
    public WebElement selectBtn;

    public void selectByText(String text) {
        click(selectBtn);
        Select select = new Select(selectBtn);
        select.selectByVisibleText(text);
    }


}
