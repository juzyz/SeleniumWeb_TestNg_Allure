package tests.searchCar;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.CAR_PAGES;

public class SearchCarTest extends BaseTest {

    @Test(description = "Find cars and check the maximum number of cards displayed on a page",
            priority = 1)
    public void checkMaxCarNumberOnPage() {
        basePage.open(CAR_PAGES);
        carHomePage
                .enterCarBrandToSearch("Ford")
                .enterLocationToSearch("Ottawa, ON")
                .clickFindCar();
        carListingPage.checkCardsCount();
    }

    @Test (description = "Check that filtered cars have price not higher that set one",
            priority = 0)
    public void checkMaxPriceOfFilteredCar() {
        String maxPrice = "30000";
        basePage.open(CAR_PAGES);
        carHomePage
                .enterLocationToSearch("Calgary, AB")
                .enterMaxPriceToSearch(maxPrice)
                .clickFindCar();
        carListingPage.checkCardsMaxPrice(Integer.valueOf(maxPrice));
    }

    @Test(description = "", dataProvider = "excelData",
            dataProviderClass = providers.ExcelDataProvider.class)
    public void checkAllFilters (String brand, String  model, String location, String	minPrice, String	maxPrice) {
        System.out.println("===Begin of the test===");
        System.out.println("Brand "+ brand);
        System.out.println("Model " + model);
        System.out.println("Location " + location);
        System.out.println("minPrice " + minPrice);
        System.out.println("maxPrice " + maxPrice);
        System.out.println("===End of the test===");
    }

}
