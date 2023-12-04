package pages.carhome;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import pages.base.BasePage;

public class CarHomePage extends BasePage {

    public CarHomePage(WebDriver driver) {
        super(driver);
    }
    private final Actions actions = new Actions(driver);

    /* Brands (makes) Dropdown List*/
    private final By brandList =  By.xpath("//*[optgroup]/*[2]/child::option");

    /* Location Dropdown List*/
    private final By locationList = By.cssSelector("#js-search-form input.tt-input");
    private final By filteredLocationList = By.className("w-suggestions");
    private final By locationListItem = By.className("suggestions__item");

    /* Price buttons*/
    private final By maxPriceList= By.cssSelector("select#price_amount_end");
    private final By maxPriceItems= By.cssSelector("select#price_amount_end option");

    /* Find button*/
    private final By findBtn = By.xpath("//*[@id=\"js-search-form\"]/*/div[4]/button");

    public CarHomePage enterCarBrandToSearch (String carBrand) {
        driver.findElements(brandList)
                .stream()
                .filter(e -> e.getText().equals(carBrand))
                .findFirst().get().click();
        return this;
    }

    public CarHomePage enterLocationToSearch(String location) { // enter information
        /* Split location on city and province */
        String[]  splitLocation = location.split("[ ,]+");
        /* Navigate and clear the location dropdown list */
        WebElement input = waitLocatedElementIsPresent(locationList);
        actions.moveToElement(input).click().perform();
        input.clear();
        /* Enter city and select corresponding location in list */
        actions.sendKeys(input, splitLocation[0]).perform();
        input.click();
        waitLocatedElementIsVisible(filteredLocationList);
        waitLocatedElementsArePresent(locationListItem)
                .stream().filter(el -> el.getText().equals(location))
                .findFirst().get().click();
        actions.sendKeys(Keys.ENTER).perform();
        return this;
    }

    public CarHomePage enterMaxPriceToSearch (String maxPrice) {
        /* Find and click Max Price button*/
        WebElement maxPriceListElm = waitLocatedElementIsPresent(maxPriceList);
        actions.moveToElement(maxPriceListElm).click().perform();
        /* Find item from dropdown list with prices and click it */
        waitLocatedElementsArePresent(maxPriceItems)
                .stream().filter(el -> el.getAttribute("value").equals(maxPrice))
                .findFirst().get().click();
        actions.sendKeys(Keys.ENTER).perform();
        return this;
    }

    public CarHomePage clickFindCar() {
        WebElement find = driver.findElement(findBtn);
        waitElementIsVisible(find).click();
        actions.build().perform();
        return this;
    }

}
