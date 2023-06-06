package tests.pim;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class PimPageTest extends BaseTest {

    @Test
    public void openPimPage(){
        loginPage.loginOHRM();
        basePage.clickSidebarButton("PIM");
        pimPage.shouldBePIMPage();
    }

    @Test
    public void createNewEmployee() {
        loginPage.loginOHRM();
        basePage.clickSidebarButton("PIM");
        pimPage.shouldBePIMPage();
        String employeeId = pimPage.addEmployee();
        pimPage.checkEmployeeById(employeeId, "Vitalii", "Shulha");
    }

    @Test
    public void updateEmployee(){
        loginPage.loginOHRM();
        basePage.clickSidebarButton("PIM");
        pimPage.shouldBePIMPage();
        pimPage.findEmployeeByName("Vitalii");
        try{
            pimPage.updateEmployer("Vitalii");
        }catch (Exception e){
            String employeeId = pimPage.addEmployee();
            pimPage.updateEmployer("Vitalii");
            pimPage.checkEmployeeById(employeeId,"Vitalii", "ShulhaUPDATED");
        }

    }

    @Test
    public void removeTestEmployee(){
        loginPage.loginOHRM();
        basePage.clickSidebarButton("PIM");
        pimPage.shouldBePIMPage();
        try {
            pimPage.removeTestEmployers();
        }catch (Exception e){
            String employeeId = pimPage.addEmployee();
            pimPage.checkEmployeeById(employeeId,"Vitalii", "Shulha");
            pimPage.removeTestEmployers();
        }
    }
}
