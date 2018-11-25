package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import page.SearchPage;

public class BaseTest {

    WebDriver webDriver;
    SearchPage searchPage;

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser){

        if(browser.equalsIgnoreCase("firefox")){
            webDriver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")){
            webDriver = new ChromeDriver();
        }
        webDriver.navigate().to("https://www.google.com/");
        searchPage = PageFactory.initElements(webDriver, SearchPage.class);
    }

    //TEST
    @AfterMethod
    public void afterMethod(){
        webDriver.quit();
    }
}
