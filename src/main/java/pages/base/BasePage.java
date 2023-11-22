package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static constants.Constant.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;
    public BasePage (WebDriver driver) {
        this.driver = driver;
    }

    public void open (String url) {
        driver.get(url);
    }
    /* Wait Element Visibility Block */
    public WebElement waitElementIsVisible (WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    public WebElement waitLocatedElementIsVisible (By element){
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    /* Wait Presence Visibility Block */
    public WebElement waitLocatedElementIsPresent (By element){
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public List<WebElement> waitLocatedElementsArePresent (By element){
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
    }

}
