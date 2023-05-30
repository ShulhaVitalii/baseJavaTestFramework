package tests.selectvolkswagen;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.AVTO_RIA_HOME_URL;

public class SelectVolkswagenTest extends BaseTest {

    @Test
    public void checkIsRedirectToVolkswagen(){
        basePage.open(AVTO_RIA_HOME_URL);
        homePage
                .selectCar()
                .pressSubmitButton();

        volkswagenListingPage.checkCountsCards();
    }
}
