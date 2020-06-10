package orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import orangeHRM.baseRequest.BaseMethods;

public class LoginPage extends BaseMethods {

	// Enter UserName
	
	public LoginPage enterUser(String user) {
		WebElement username = driver.findElement(By.id("txtUsername"));
		username.clear();
		username.sendKeys(user);
		return this;
	}

	// Enter Password

	public LoginPage enterPassword(String password) {
		WebElement passwrd = driver.findElement(By.id("txtPassword"));
		passwrd.clear();
		passwrd.sendKeys(password);
		return this;
	}

	// Click Login

	public DashboardPage clickLogin() {
		driver.findElement(By.id("btnLogin")).click();
		return new DashboardPage();
	}

}
