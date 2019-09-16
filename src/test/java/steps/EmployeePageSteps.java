package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Employees;

import java.util.List;

public class EmployeePageSteps extends BaseSteps {

    Employees employees;

    public EmployeePageSteps() {
        employees= new Employees(getDriverInstance());
    }

    @Given("customer click on Create button in employee screen")
    public void clickOnCreateEmployee()  {
       employees.clickCreateEmployeeButton();

    }

    @Given("customer click on Edit button in employee screen")
    public void clickOnEditEmployee()  {
        employees.clickEditEmployeeButton();

    }

    @Given("customer click on Delete button in employee screen")
    public void clickOnDeleteEmployee()  {
        employees.clickDeleteEmployeeButton();

    }


    @When("customer enters first name as {string} last name as {string} start date as {string} and email as {string}")
    public void customer_enters_first_name_as_last_name_as_start_date_as_and_email_as(String fName, String lName, String startDate, String email) {
        employees.createNewEmployee(fName,lName,startDate,email);
    }

    @When("customer updates first name as {string} last name as {string} start date as {string} and email as {string}")
    public void customer_update_first_name_as_last_name_as_start_date_as_and_email_as(String fName, String lName, String startDate, String email) {
        employees.updateEmployee(fName,lName,startDate,email);
    }


    @Then("customer verify the new employee first name {string} and last name {string} exist in employee list")
    public void customer_verify_the_new_employee_first_name_and_last_name_exist_in_employee_list(String fName, String lName) {
        String employeeName = fName+" "+lName;
        List<String> employeeList= employees.getEmployeeNames();
        employeeList.forEach(item->item.contains(fName));
        boolean match = employeeList.stream().anyMatch(employeeName::contains);
        Assert.assertTrue(match);
    }


    @Then("customer verify the new employee first name {string} and last name {string} does not exist in employee list")
    public void customer_verify_the_new_employee_first_name_and_last_name_does_not_exist_in_employee_list(String fName, String lName) {
        String employeeName = fName+" "+lName;
        List<String> employeeList= employees.getEmployeeNames();
        employeeList.forEach(item->item.contains(fName));
        boolean match = employeeList.stream().anyMatch(employeeName::contains);
        Assert.assertFalse(match);
    }


    @When("customer find the employee first name as {string} last name as {string} from the employee list")
    public void customer_find_the_employee_first_name_as_last_name_as_from_the_employee_list(String fName, String lName) {
        String employeeName = fName+" "+lName;
        employees.clickOnEmployeeName(employeeName);
    }


}
