package pages.card;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

public class CarCardPage extends BasePage {

    public CarCardPage(WebDriver driver) {
        super(driver);
    }

    private final By vinTag = By.cssSelector(".vhcl-info__moreDetails.push--top ul li:nth-of-type(3)");
    private final By calculatePaymentsLink = By.cssSelector("a#js-payment-calc-button");
    private final By calculateButton = By.cssSelector("#js-payment-calc button");
    private final By calculatePaymentsForm = By. cssSelector("#vhcl-info");

    public CarCardPage checkVinTagValueExistence () {
        waitLocatedElementIsPresent(vinTag);
        return this;
    }

    public CarCardPage clickCalculatePaymentsButton (){
        WebElement calPaymentBtn = waitLocatedElementIsPresent(calculatePaymentsLink);
        calPaymentBtn.click();
        return this;
    }

    public CarCardPage checkCalculatePaymentsFormIsOpened() {
        WebElement paymentForm = waitLocatedElementIsVisible(calculatePaymentsForm);
        waitLocatedElementIsVisible(calculateButton);
        Assert.assertTrue(paymentForm.isEnabled());
        return this;
    }
}
