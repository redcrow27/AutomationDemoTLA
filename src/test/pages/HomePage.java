package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[starts-with(@class, 'navbar-brand ml-3')]")
    public List<WebElement> linkTexts16;

    @FindBy(linkText = "User-Mgt")
    public WebElement userMgt_Btn;

    public String[] navButtons = {"Home", "Inputs", "Selectors", "Select-class", "Alert", "Pop-Up", "Multiple-window",
            "Tables", "Calendar", "iFrames", "Action-class","JS-Executor","Synchronization", "Files", "User-Mgt"};


}
