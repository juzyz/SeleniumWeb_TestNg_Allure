package tests.searchCar;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;
 import static constants.Constant.Urls.CAR_PAGES;
import static constants.Constant.Urls.CAR_DEFAULT_SEARCH;

public class SearchCarTest extends BaseTest {
    @Epic("Search car functionality")
    @Story("Page setting")
    @Severity(SeverityLevel.NORMAL)
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

    @Epic("Search car functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Page filtering")
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


//   @Test (description = "Get failed result to check screenshot attached to allure report")
//    public void checkScreenshotTakenOnFailure(){
//        basePage.open(CAR_DEFAULT_SEARCH);
//        carListingPage
//                .clickCarCardLink();
//            //    .returnFailedStatus();
//    }

}
