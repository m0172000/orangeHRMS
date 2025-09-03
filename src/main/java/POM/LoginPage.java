package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;

	@FindBy(css = "button[type='submit']")
	private WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void login(String user, String pwd) {
		username.sendKeys(user);
		password.sendKeys(pwd);
		loginBtn.click();
	}
	
}
