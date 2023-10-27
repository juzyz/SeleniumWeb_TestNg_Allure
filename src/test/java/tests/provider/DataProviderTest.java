package tests.provider;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class DataProviderTest {
    @Description("Check all filters with using data provider")
    @Epic("Data Provider functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "excelData", dataProviderClass = providers.ExcelDataProvider.class)
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
