package pages.listing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

public class CarListingPage extends BasePage {

    public CarListingPage(WebDriver driver) {
        super(driver);
    }

    private final By card = By.cssSelector(".t-flex.t-gap-6.t-items-start.t-p-6");
    private final By priceTag = By.cssSelector(".l-column.l-column--medium-4.push-none strong.delta");
   private final By firstCarCardLink = By.cssSelector("h4.hN > a");


    public CarListingPage checkCardsCount() {
        Assert.assertEquals(driver.findElements(card).size(), 50);
        return this;
    }

    public CarListingPage checkCardsMaxPrice(int maxPrice) {
        /* Get price tag of all cards */
        Assert.assertTrue(driver.findElements(priceTag).stream().allMatch(elm ->
            /* Deleting $ and , sings, convert text to an integer and compare the integer to maxPrice */
             Integer.valueOf( elm.getText().replaceAll("[$,]", "")) <= maxPrice
        ));
        return this;
    }

    public CarListingPage clickCarCardLink () {
        WebElement carLink = driver.findElement(firstCarCardLink);
        waitElementIsVisible(carLink);
        carLink.click();
        return this;
    }

//    public CarListingPage returnFailedStatus () {
//        Assert.assertEquals(2, 1);
////        Assert.fail("This TC is used to check behavior on failure.");
//        return this;
//    }

}
