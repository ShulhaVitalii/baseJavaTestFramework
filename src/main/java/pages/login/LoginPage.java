package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    private final By titleLogin = By.xpath("//h5[text()='Login']");
    private final By inputUsername = By.xpath("//input[@name='username']");
    private final By inputPassword = By.xpath("//input[@name='password']");
    private final By buttonSubmit = By.xpath("//button[@type='submit']");
    private final By alertInvalidCred = By.xpath("//div[@role='alert']//*[text()='Invalid credentials']");


    public LoginPage shouldBeLoginPage(){
        WebElement loginText = driver.findElement(titleLogin);
        waitElementIsVisible(loginText);

        return this;
    }

    public LoginPage enterUsername(String username){
        WebElement Username = driver.findElement(inputUsername);
        waitElementIsVisible(Username).sendKeys(username);
        return null;
    }

    public LoginPage enterPassword(String password){
        WebElement Password = driver.findElement(inputPassword);
        waitElementIsVisible(Password).sendKeys(password);
        return null;
    }

    public LoginPage clickOnSubmitButton(){
        driver.findElement(buttonSubmit).click();
        return this;
    }

    public LoginPage loginOrangeHRM(String login , String password){
        shouldBeLoginPage();
        enterUsername(login);
        enterPassword(password);
        clickOnSubmitButton();
        return this;
    }

    public LoginPage alertShouldBePresent(){
        WebElement alert = driver.findElement(alertInvalidCred);
        waitElementIsVisible(alert);
        return this;
    }

    public LoginPage filedLoginOrangeHRM(String login , String password){
        loginOrangeHRM(login, password);
        alertShouldBePresent();
        return this;
    }
}
