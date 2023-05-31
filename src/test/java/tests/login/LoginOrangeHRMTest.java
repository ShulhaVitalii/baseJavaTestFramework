package tests.login;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.ORANGE_HRM_URL;

public class LoginOrangeHRMTest extends BaseTest {

    @Test
    public void successfulLoginLogoutOrangeHRMTest(){
        basePage.open(ORANGE_HRM_URL);
        loginPage.loginOrangeHRM("Admin","admin123");
        dashboardPage.shouldBeDashboardPage();
        dashboardPage.logoutOrangeHRM();
        loginPage.shouldBeLoginPage();
    }

    @Test
    public void loginFiledNameCorrectPassword(){
        basePage.open(ORANGE_HRM_URL);
        loginPage.filedLoginOrangeHRM("adm", "admin123");
    }

    @Test
    public void loginFiledNameFiledPassword(){
        basePage.open(ORANGE_HRM_URL);
        loginPage.filedLoginOrangeHRM("adm", "admin");
    }

    @Test
    public void loginCorrectNameFiledPassword(){
        basePage.open(ORANGE_HRM_URL);
        loginPage.filedLoginOrangeHRM("admin", "admin");
    }
}
