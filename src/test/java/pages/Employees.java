package pages;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class Employees extends BasePage {
    private WebDriver driver;
    private  NgWebDriver ngDriver;

    public Employees(WebDriver driver) {
        super((driver));
        this.driver=driver;
        this.ngDriver=new NgWebDriver((JavascriptExecutor) driver);
    }
    @ByAngularModel.FindBy(rootSelector = "employeeForm", model = "selectedEmployee.firstName")
    private WebElement employeeFirstName;

    @ByAngularModel.FindBy(rootSelector = "employeeForm", model = "selectedEmployee.lastName")
    private WebElement employeeLastName;

    @ByAngularModel.FindBy(rootSelector = "employeeForm", model = "selectedEmployee.startDate")
    private WebElement employeeStartDate;

    @ByAngularModel.FindBy(rootSelector = "employeeForm", model = "selectedEmployee.email")
    private WebElement employeeEmail;

    public void clickCreateEmployeeButton(){
        ngDriver.waitForAngularRequestsToFinish();
        driver.findElement(By.id("bAdd")).click();
    }

    public void clickEditEmployeeButton() {
        ngDriver.waitForAngularRequestsToFinish();
        driver.findElement(By.id("bEdit")).click();
    }

    public void clickDeleteEmployeeButton() {
        ngDriver.waitForAngularRequestsToFinish();
        driver.findElement(By.id("bDelete")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    public void clickOnAddEmployeeButton(){
        driver.findElement(ByAngular.buttonText("Add")).click();
    }

    public void clickOnUpdateEmployeeButton(){
        ngDriver.waitForAngularRequestsToFinish();
        driver.findElement(ByAngular.buttonText("Update")).click();
    }

    public void createNewEmployee(String fName,String lName,String startDate,String email){
        ngDriver.waitForAngularRequestsToFinish();
        employeeFirstName.sendKeys(fName);
        employeeLastName.sendKeys(lName);
        employeeStartDate.sendKeys(startDate);
        employeeEmail.sendKeys(email);
        clickOnAddEmployeeButton();
    }

    public void updateEmployee(String fName,String lName,String startDate,String email){
        ngDriver.waitForAngularRequestsToFinish();
        employeeFirstName.clear();
        employeeFirstName.sendKeys(fName);
        employeeLastName.clear();
        employeeLastName.sendKeys(lName);
        employeeStartDate.clear();
        employeeStartDate.sendKeys(startDate);
        employeeEmail.clear();
        employeeEmail.sendKeys(email);
        clickOnUpdateEmployeeButton();
    }

    public List<String> getEmployeeNames(){
        List<String> employeeNameList= new ArrayList<>();
        ngDriver.waitForAngularRequestsToFinish();
        driver.findElement(By.id("employee-list")).findElements(By.tagName("li")).forEach(item->employeeNameList.add(item.getText()));
        return employeeNameList;
    }

    public void clickOnEmployeeName(String employeeName){
        ngDriver.waitForAngularRequestsToFinish();
        driver.findElement(By.id("employee-list")).findElements(By.tagName("li")).stream()
               .filter(empName->empName.getText().contains(employeeName))
                .findFirst().get().click();
    }

}
