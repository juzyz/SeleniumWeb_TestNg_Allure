package tests.calculatePayment;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.CAR_DEFAULT_SEARCH;

public class CalculatePaymentTest extends BaseTest {
    @Epic("Calculate payments")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Page settings")
    @Test (description = "Check opening modal form")
    public void calculatePaymentFormShouldBeOpenedWithoutErrors(){
        basePage.open(CAR_DEFAULT_SEARCH);
        carListingPage.clickCarCardLink();
        carCardPage
                .clickCalculatePaymentsButton()
                .checkCalculatePaymentsFormIsOpened();
    }

}
