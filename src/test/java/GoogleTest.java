import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleTest extends Methods {


    //private StartPage startPage;

    @Test
    public void basicSearchTest() {
        String searchWord = "Selenium";
        
       Assert.assertTrue(startPage.isLoaded(), "HomePage is not loaded");
        FirstPage firstPage = startPage.search(searchWord);

        Assert.assertTrue(firstPage.isLoaded(), "Search page is not loaded.");
        Assert.assertEquals(firstPage.getSearchResultsCount(), 10, "Search results count is wrong.");

        List<String> searchResults = firstPage.getSearchResultsList();

        for (String searchResult : searchResults) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchWord.toLowerCase()),
                    "searchWord" + searchWord + "not found in: \n" + searchResults);
        }

         SecondPage secondPage =firstPage.goToSecondPage();
        Assert.assertTrue(secondPage.isLoaded(), "Second search page is not loaded.");
        Assert.assertEquals(secondPage.getSearchResultsCount(), 10, "Search results count is wrong.");

        List<String> searchResultsSecondPage = firstPage.getSearchResultsList();

        for (String searchResult : searchResultsSecondPage) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchWord.toLowerCase()),
                    "searchWord" + searchWord + "not found in: \n" + searchResults);
        }


    }
}