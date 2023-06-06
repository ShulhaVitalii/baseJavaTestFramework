package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static constants.Constant.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void open(String url){
        driver.get(url);
    }

    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void urlShouldContain(String text){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(text));

    }

    public void clickSidebarButton(String text){
        String xpath = String.format("//span[contains(@class, 'oxd-main-menu-item--name') and text()='%s']", text);
        driver.findElement(By.xpath(xpath)).click();
    }


    public void clickOnElement(By element){
        WebElement elem = driver.findElement(element);
        waitElementIsVisible(elem);
        elem.click();
    }

    public void clickLinkByText(String text){
        String xpath = String.format("//a[text()='%s']", text);
        WebElement link = driver.findElement(By.xpath(xpath));
        waitElementIsVisible(link);
        link.click();
    }



}
