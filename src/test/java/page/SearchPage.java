package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@name='btnK']")
    private WebElement searchButton;


    public SearchPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method checks if the page was loaded
     * @return true if the page was loaded comparing the following data: page url, page title, web element presence
     */
    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().equals("https://www.google.com/")
                && webDriver.getTitle().equals("Google")
                && isSearchFieldDisplayed();
    }

    /**
     * Method checks if the searchField is displayed
     * @return true if the searchField is displayed
     */
    public boolean isSearchFieldDisplayed(){
        return searchField.isDisplayed();
    }

    /**
     * Method that search the specific search term
     * @param searchTerm String with searchTerm
     * @return ResultPage object
     */
    public ResultPage search(String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return PageFactory.initElements(webDriver, ResultPage.class);
    }
}
