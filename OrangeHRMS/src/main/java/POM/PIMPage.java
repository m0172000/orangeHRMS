package POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {

	@FindBy(linkText = "PIM")
	private WebElement pimMenu;

	@FindBy(linkText = "Add Employee")
	private WebElement addEmployee;

	@FindBy(name = "firstName")
	private WebElement firstName;

	@FindBy(name = "lastName")
	private WebElement lastName;

	@FindBy(xpath = "//label[text()='Employee Id']/../following-sibling::div/input")
	private WebElement empId;

	@FindBy(xpath = "//span[contains(@class,'oxd-switch-input')]")
	private WebElement createLoginToggle;

	@FindBy(xpath = "//label[text()='Username']/../following-sibling::div/input")
	private WebElement empUsername;

	@FindBy(xpath = "//input[@type='password'][1]")
	private WebElement empPassword;

	@FindBy(xpath = "//*[text()=\"Confirm Password\"]/../..//input")
	private WebElement empConfirmPassword;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveBtn;

	@FindBy(xpath = "(//div[@class=\"orangehrm-edit-employee-content\"]//h6)[1]")
	private WebElement personalHeader;

	@FindBy(linkText = "Employee List")
	private WebElement employeeList;

	@FindBy(xpath = "//label[text()='Employee Name']/../following-sibling::div//input")
	private WebElement searchName;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement searchBtn;

	@FindBy(xpath = "//div[@class='oxd-table-body']/div")
	private List<WebElement> tableRows;

	public PIMPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	
	public WebElement getPimMenu() {
		return pimMenu;
	}



	public WebElement getAddEmployee() {
		return addEmployee;
	}



	public WebElement getFirstName() {
		return firstName;
	}



	public WebElement getLastName() {
		return lastName;
	}



	public WebElement getEmpId() {
		return empId;
	}



	public WebElement getCreateLoginToggle() {
		return createLoginToggle;
	}



	public WebElement getEmpUsername() {
		return empUsername;
	}



	public WebElement getEmpPassword() {
		return empPassword;
	}



	public WebElement getEmpConfirmPassword() {
		return empConfirmPassword;
	}



	public WebElement getSaveBtn() {
		return saveBtn;
	}



	public WebElement getPersonalHeader() {
		return personalHeader;
	}



	public WebElement getEmployeeList() {
		return employeeList;
	}



	public WebElement getSearchName() {
		return searchName;
	}



	public WebElement getSearchBtn() {
		return searchBtn;
	}



	public List<WebElement> getTableRows() {
		return tableRows;
	}



	public String addEmployee(String fname, String lname, String uname, String pwd) {
		pimMenu.click();
		addEmployee.click();
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		String employeeId = empId.getAttribute("value");
		createLoginToggle.click();
		empUsername.sendKeys(uname);
		empPassword.sendKeys(pwd);
		empConfirmPassword.sendKeys(pwd);
	
		saveBtn.click();
		return employeeId;
	}

	public boolean isEmployeeCreated() {
		return personalHeader.getText().contains("Personal Details");
	}

	public boolean searchEmployee(String name) throws Throwable {
		pimMenu.click();
		employeeList.click();
		searchName.sendKeys(name);
		searchBtn.click();
		searchBtn.click();
		Thread.sleep(Duration.ofSeconds(5));
		return tableRows.size() > 0;
	}
}
