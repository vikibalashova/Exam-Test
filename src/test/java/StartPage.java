import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class StartPage extends BasePage {


    @FindBy(xpath = "//*[@ id ='lst-ib']")
    private WebElement gogleId;

    WebDriver browser;


    public StartPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(gogleId, 10);

    }

    public FirstPage search(String searchWord) {
        gogleId.sendKeys(searchWord);
        gogleId.sendKeys(Keys.ENTER);

        return new FirstPage(browser);
    }

    public boolean isLoaded() {
        return gogleId.isDisplayed()
                && getCurrentPageUrl().equals("https://www.google.com/")
                && getCurrentPageTitle().equals("Google");

    }



}



