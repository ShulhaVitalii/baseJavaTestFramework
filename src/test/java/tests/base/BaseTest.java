package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.dashboard.DashboardPage;
import pages.home.HomePage;
import pages.listing.VolkswagenListingPage;
import pages.login.LoginPage;
import pages.pim.PIMPage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);

    protected VolkswagenListingPage volkswagenListingPage = new VolkswagenListingPage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected DashboardPage dashboardPage = new DashboardPage(driver);
    protected PIMPage pimPage = new PIMPage(driver);


    @AfterTest
    public void clearCookiesAndLocalStorage(){
        if(CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");

        }
    }

    @AfterTest (alwaysRun = true)
    public void close(){
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
