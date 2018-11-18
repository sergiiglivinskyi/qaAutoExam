package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.ResultPage;

public class SearchTest extends BaseTest{

    @DataProvider
    public Object[][] searchTermDataProvider() {
        return new Object[][]{
                {"selenium"},
                {"SELENIUM"},
        };
    }

    @Test(dataProvider = "searchTermDataProvider")
    public void searchTest(String searchTerm){
        Assert.assertTrue(searchPage.isPageLoaded(), "Search Page is not loaded");
        ResultPage resultPage = searchPage.search(searchTerm);
        Assert.assertTrue(resultPage.isPageLoaded(), "Result Page is not loaded");

        Assert.assertEquals(resultPage.getActivePaginationNumber(), 1, "Incorrect Pagination number is loaded");
        Assert.assertEquals(resultPage.getNumberOfSearchResults(), 10, "Search Results does not equals to 10");
        Assert.assertTrue(resultPage.isSearchTermPresent(searchTerm), "Search Term does not present");
        resultPage.goToNextPage();
        Assert.assertEquals(resultPage.getActivePaginationNumber(), 2, "Incorrect Pagination number is loaded");
        Assert.assertEquals(resultPage.getNumberOfSearchResults(), 10, "Search Results does not equals to 10");
        Assert.assertTrue(resultPage.isSearchTermPresent(searchTerm), "Search Term does not present");
    }

}
