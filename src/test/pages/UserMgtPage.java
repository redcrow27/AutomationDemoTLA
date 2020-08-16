package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UserMgtPage extends BasePage {
    WebDriver driver;

    public UserMgtPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="login-btn")
    public WebElement login_Btn;

    @FindBy(id ="access-db-btn")
    public WebElement accessDb_Btn;

    public String[] fields = {"Firstname", "Lastname", "Phonenumber", "Email", "Select-role"};

    @FindBy(xpath = "//table[@id='list-table']//tbody")
    public WebElement dataTable;


    @FindBy(id = "submit-btn")
    public WebElement submitBtn;

    @FindBy(id = "clear-btn")
    public WebElement clearBtn;





}
