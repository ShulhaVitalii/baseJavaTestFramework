package pages.pim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;


public class PIMPage extends BasePage {
    public PIMPage(WebDriver driver) {
        super(driver);
    }

    public final By employerInfoText = By.xpath("//*[text()='Employee Information']");
    public final By addEmployeeLink = By.xpath("//a[text()='Add Employee']");
    public final By inputFirstName = By.xpath("//input[@name='firstName']");
    public final By inputLastName = By.xpath("//input[@name='lastName']");
    public final By inputEmployeeId = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    public final By buttonSubmit = By.xpath("//button[@type='submit']");
    public final By inputEmployeeNameToSearch = By.xpath("//input[@placeholder='Type for hints...']");
    public final By deleteButton = By.xpath("//i[@class='oxd-icon bi-trash']/..");
    public final By editButton = By.xpath("//i[@class='oxd-icon bi-pencil-fill']/..");
    public final By checkboxSelectAll = By.xpath("(//span[contains(@class, 'oxd-checkbox-input')])[1]");
    public final By deleteSelected = By.xpath("//button[text()=' Delete Selected ']");
    public final By confirmDeletionButton =
            By.xpath("//div[@role='document']//button[text()=' Yes, Delete ']");
    public final By employeeFirstNameInTable = By.xpath("((//div[@role='row'])[2]//div[@role='cell'])[3]");
    public final By employeeLastNameInTable = By.xpath("((//div[@role='row'])[2]//div[@role='cell'])[4]");

    public PIMPage shouldBePIMPage(){

        WebElement headerText = driver.findElement(employerInfoText);
        waitElementIsVisible(headerText);
        urlShouldContain("pim");
        return this;
    }

    public String addEmployee(){
        clickOnElement(addEmployeeLink);
        urlShouldContain("addEmployee");
        String employeeId = driver.findElement(inputEmployeeId).getCssValue("_value");

        driver.findElement(inputFirstName).sendKeys("Vitalii");
        driver.findElement(inputLastName).sendKeys("Shulha");
        clickOnElement(buttonSubmit);

        return employeeId;

    }

    public void checkEmployeeById(String employeeId, String firstName, String lastName){
        clickLinkByText("Employee List");
        urlShouldContain("viewEmployeeList");
        driver.findElement(By.xpath("//*[text()='Employee Information']"));
        driver.findElement(inputEmployeeId).sendKeys(employeeId);
        clickOnElement(buttonSubmit);

        driver.findElement(By.xpath(String.format("//div[text()='%s']", employeeId)));
        String employeeFirstName = driver.findElement(employeeFirstNameInTable).getText();
        String employeeLastName = driver.findElement(employeeLastNameInTable).getText();

        Assert.assertEquals(employeeFirstName, firstName);
        Assert.assertEquals(employeeLastName, lastName);

        driver.findElement(deleteButton).click();
        driver.findElement(confirmDeletionButton).click();

    }
    public void findEmployeeByName(String name){
        clickLinkByText("Employee List");
        urlShouldContain("viewEmployeeList");
        driver.findElement(By.xpath("//*[text()='Employee Information']"));
        driver.findElement(inputEmployeeNameToSearch).sendKeys(name);
        clickOnElement(buttonSubmit);
    }

    public void removeTestEmployers(){
        findEmployeeByName("Vitalii");
        WebElement selectAll = driver.findElement(checkboxSelectAll);
        waitElementIsVisible(selectAll).click();
        driver.findElement(deleteSelected).click();
        driver.findElement(confirmDeletionButton).click();

    }

    public String updateEmployer(String name){
        findEmployeeByName(name);
        driver.findElement(editButton).click();

        driver.findElement(inputLastName).sendKeys("UPDATED");
        clickOnElement(buttonSubmit);
        String employeeId = driver.findElement(inputEmployeeId).getCssValue("_value");

        return employeeId;
    }



}
