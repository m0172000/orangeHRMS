package EmployeePage;

import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.LoginPage;
import POM.PIMPage;
import commonUtlis.BaseClass;

public class EmployeTest extends BaseClass {

	@BeforeMethod
    public void setup() {
        driver.get(DataReader.getProperty("url"));
        LoginPage loginEle = new LoginPage(driver);
        String username = DataReader.getProperty("username");
        String password = DataReader.getProperty("password");
        loginEle.login(username, password);
    
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        wait.until(ExpectedConditions.urlToBe(expectedURL));
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Login failed → Dashboard not loaded.");
        
    }

    @DataProvider(name = "employeeData")
    public Object[][] getEmployeeData() {
        return new Object[][] {
            {"Manoj", "KM", "Manoj924", "Password@123"}
        };
    }

    @Test(dataProvider = "employeeData")
    public void testAddAndSearchEmployee(String fname, String lname, String uname, String pwd) throws Throwable {
        PIMPage pimele = new PIMPage(driver);

        // Step 1 Add Employee
        String empId = pimele.addEmployee(fname, lname, uname, pwd);
        wait.until(ExpectedConditions.visibilityOf(pimele.getPersonalHeader()));
        Assert.assertTrue(pimele.isEmployeeCreated(), "Employee creation failed");
        Reporter.log("Employee created successfully", true);
        
        // Step 2 Search Employee by full name
        String fullName = fname + " " + lname;
        Assert.assertTrue(pimele.searchEmployee(fullName), "Employee not found in search");
        Reporter.log("Employee found in search table", true);

    }
    
    @AfterMethod
    public void teardown() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
}
