package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CommonPage extends BasePage {

    WebDriver driver;

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

}
