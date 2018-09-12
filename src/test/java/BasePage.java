import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    WebDriver browser;

    WebElement waitUntilElementIsVisible(WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(browser, 60);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    String getCurrentPageTitle() {
        return browser.getTitle();
    }

    String getCurrentPageUrl() {
        return browser.getCurrentUrl();
    }

    public abstract boolean isLoaded();

}