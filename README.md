# Automation Framework setup guide (for Mac)

## Download the following components:

1. Go to [Oracle official site](http://www.oracle.com/technetwork/java/javase/downloads/index.html) and download JDK package:

    * Click on JDK Download button (latest version can be used)

    * Click on Accept License Agreement and download JDK package for Mac

2. Download FireFox Browser and make sure it has the latest version

3. Download Google Chrome Browser and make sure it has the latest version

4. Go to [Geckodriver](https://github.com/mozilla/geckodriver/releases) and download the latest version geckodriver.
Set up the geckodriver:

        echo $PATH
        /usr/local/bin/
        mv /Users/Sergii/Downloads/geckodriver /usr/local/bin/geckodriver
 
5. Install Google Chrome driver:

        brew cask install chromedriver


## Tools Setup:

1. Install JDK package

2. Install IntelliJ IDEA application

3. Install FireFox Browser

4. Launch IntelliJ IDEA, create New Project, select Maven, select JDK installed version 

5. Go to [Maven Repository](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.11.0), then click on 
Maven tab and copy internal text (it is needed for Selenium setup)

6. Paste copied text to pom.xml file (using this file you can configure/install any tools and libraries for your project according to your needs)

7. Go to IntelliJ IDEA --> View --> Check On the following: Tool Buttons

8. Click on Maven Project tool bar in the right side and double click on Install item (Selenium Components have been installed)


## Project Content:

1. **/src/test/page** package contains Page Objects for each Page:

    * **BasePage** contains WebDriver initialization and waiters
    
    * **ResultPage** contains WebElements and methods for Result Page
    
    * **SearchPage** contains WebElements and methods for Search Page

2. **/src/test/test** package contains Tests:

    * **BaseTest** contains Before and After methods
    
    * **SearchTest** contains Tests
    
3. **.gitignore** file - it can be used for determining the files which should not be pushed to the repository. 
   For that purposes it is needed to enter just their names into .gitignore file.
   
4. **parallelTests.xml** - it contains info how the test are run on the different browsers

5. **pom.xml** - contains all dependencies which needed for proper tests execution (TestNG, Selenium WebDriver, Apache Maven)


## How to Run the tests:

1. Go to root project folder using Terminal

2. Run the next command: 

        mvn clean install -DsuiteXmlFile=parallelTests.xml 