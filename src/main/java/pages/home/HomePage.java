package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By marka = By.xpath("//input[@aria-label='Пошук Марка']");
    private By volkswagen = By.xpath("//a[text()='Volkswagen']");

    private By submitButton = By.xpath("//button[@type='submit']");



    public HomePage selectCar(){
        driver.findElement(marka).sendKeys("Volkswagen");
        driver.findElement(volkswagen).click();

        return this;
    }

    public HomePage pressSubmitButton(){
        WebElement searchButton = driver.findElement(submitButton);
        waitElementIsVisible(searchButton).click();

        return this;
    }


}
