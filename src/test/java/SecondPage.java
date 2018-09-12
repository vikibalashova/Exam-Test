import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SecondPage extends BasePage {
    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResult;
    private Iterable<? extends WebElement> searchResults;

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement searchResultsSum;

    public SecondPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(searchResultsSum, 10);
    }

    public boolean isLoaded() {
        return searchResultsSum.isDisplayed() && getCurrentPageTitle().contains("Поиск в Google") && getCurrentPageUrl().contains("/search");

    }

    public int getSearchResultsCount() {
        return searchResult.size();
    }

}
