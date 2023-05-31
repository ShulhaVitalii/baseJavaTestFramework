package pages.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {

        super(driver);
    }

    public final By dashboardHeaderText = By.xpath("//header//*[text()='Dashboard']");

    public final By userDropdownMenu = By.xpath("//p[@class='oxd-userdropdown-name']");
    public final By logoutLink = By.xpath("//a[text()='Logout']");


    public DashboardPage shouldBeDashboardPage(){

        WebElement headerText = driver.findElement(dashboardHeaderText);
        waitElementIsVisible(headerText);
        urlShouldContain("dashboard");
        return this;
    }

    public DashboardPage logoutOrangeHRM(){
        driver.findElement(userDropdownMenu).click();
        driver.findElement(logoutLink).click();
        return this;
    }
}
