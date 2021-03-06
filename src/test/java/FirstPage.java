import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FirstPage extends BasePage {

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResult;
    private Iterable<? extends WebElement> searchResults;

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement searchResultsSum;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement secondPage;

    public FirstPage(WebDriver browser) {
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


    public List<String> getSearchResultsList() {
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement tt : searchResult) {
            ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView();", tt);
            searchResultsList.add(tt.getText());
        }
        return searchResultsList;

    }

    private String getSearchTotalResultsText() {
        return searchResultsSum.getText();
    }


    public SecondPage goToSecondPage() {
        secondPage.click();
        return new SecondPage(browser);
    }
}



