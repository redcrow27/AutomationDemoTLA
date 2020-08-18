package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;

public class UserDatabasePage extends BasePage {
    WebDriver driver;

    public UserDatabasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text()='User Database']")
    public WebElement userDB;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> rows;

    @FindBy(xpath = "//table")
    public WebElement table;

    @FindBy(xpath = "//td[7]//div/button[1]")
    public WebElement editBtn;

    @FindBy(xpath = "//td[7]//div/button[2]")
    public List<WebElement> deleteBtn;

    @FindBy(xpath = "//button[text()='Update']")
    public WebElement updateBtn;

    @FindBy(xpath = "//button[text()='Return']")
    public WebElement returnBtn;

    @FindBy(xpath = "((//tbody//tr)[4])/td[1]")
    public WebElement rowFourName;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameBox;

    public Boolean checkEditDeleteBtn(List<WebElement> rows) {
        for(int i = 0; i < 3; i++) {
            if( rows.get(i).findElement(By.xpath("//td[7]//div/button[1]")).isEnabled() && rows.get(i).findElement(By.xpath("//td[7]//div/button[2]")).isEnabled() ){
                return true;
            }
        }
        return false;
    }

    public String rXpatS(String str) {
        String result = "//*[text()='"+ str +"']";
        return result;
    }







}
