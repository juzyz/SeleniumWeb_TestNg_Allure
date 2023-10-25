package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.card.CarCardPage;
import pages.listing.CarListingPage;
import pages.carhome.CarHomePage;

import static common.Config.*;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected CarHomePage carHomePage = new CarHomePage(driver);
    protected CarListingPage carListingPage = new CarListingPage(driver);
    protected CarCardPage carCardPage = new CarCardPage(driver);

    @AfterTest
    /* Delete WebDriver cookies */
    public  void clearCookiesAndLocalStorage () {
        if (CLEAR_COOKERS_AND_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite(alwaysRun = true)
    /* Quits the driver, closing every associated window */
    public void close () {
        if (HOLD_BROWSER_OPEN){
            driver.quit();
        }
    }

}
