package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultPage extends BasePage{

    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//a[@class='pn']")
    private WebElement nextButton;

    @FindBy(xpath = "//tr/td[@class='cur']")
    private WebElement paginationNumber;


    public ResultPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        waitUntilPageIsOpen("search?source");
    }

    /**
     * Method checks if the page was loaded
     * @return true if the page was loaded comparing the following data: page url, page title, web element presence
     */
    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("search?source")
                && webDriver.getTitle().contains("Google");
    }

    /**
     * Method returns number of items which were got using searchTerm
     * @return
     */
    public int getNumberOfSearchResults(){
        return searchResults.size();
    }

    /**
     * Method checks if search term is present in the result page and each result's item
     * @param searchTerm String with searchTerm
     * @return true if search term is present
     */
    public boolean isSearchTermPresent(String searchTerm){
        for(WebElement element: searchResults){
            String elementText = element.getText();
            if(!elementText.toLowerCase().contains(searchTerm.toLowerCase())){
                return false;
            }
        }
        return true;
    }

    /**
     * Method enables the next pagination number or page
     */
    public void goToNextPage(){
        nextButton.click();
    }

    /**
     * Method returns the pagination number
     * @return
     */
    public int getActivePaginationNumber(){
        return Integer.parseInt(paginationNumber.getText());
    }
}
