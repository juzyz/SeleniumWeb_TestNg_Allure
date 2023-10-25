package tests.calculatePayment;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.CAR_DEFAULT_SEARCH;

public class CalculatePaymentTest extends BaseTest {

    @Test (description = "Check opening modal form")
    public void openCalculatePaymentForm (){
        basePage.open(CAR_DEFAULT_SEARCH);
        carListingPage.clickCarCardLink();
        carCardPage
                .clickCalculatePaymentsButton()
                .checkCalculatePaymentsFormIsOpened();

    }

}
