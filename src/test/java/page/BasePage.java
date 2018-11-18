package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

    WebDriver webDriver;

    /**
     * Method check if the page with specific url is loaded
     * @param url String with url
     */
    public void waitUntilPageIsOpen(String url){
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.urlContains(url));
    }
}
