package pages.listing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

public class VolkswagenListingPage extends BasePage {

    public VolkswagenListingPage(WebDriver driver) {
        super(driver);
    }

    private final By card = By.xpath("//a[@data-template-v]");

    public VolkswagenListingPage checkCountsCards(){
        int countCard = driver.findElements(card).size();
        Assert.assertEquals(countCard, 10);
        return this;
    }


}
