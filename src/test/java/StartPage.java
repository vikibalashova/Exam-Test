
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage  {


    @FindBy(xpath = "//*[@ id ='lst-ib']")
            private WebElement gogleId;

    WebDriver browser = new FirefoxDriver();


    public StartPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(gogleId, 10);

    }
    public FirstPage search(String searchWord) {
        Alert searchField;
        searchField.sendKeys(searchWord);
        searchField.sendKeys(Keys.ENTER);

        return  new FirstPage(browser);
    }
    public boolean isLoaded () {
        return gogleId.isDisplayed()
                && getCurrentPageUrl().equals("https://www.google.com/")
                && getCurrentPageTitle().equals("Google");

    }

}



