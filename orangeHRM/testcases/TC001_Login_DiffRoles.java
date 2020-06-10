package orangeHRM.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import orangeHRM.baseRequest.BaseMethods;
import orangeHRM.pages.LoginPage;

public class TC001_Login_DiffRoles extends BaseMethods {
	
	
	// Pass FileName for DataProvider
	@BeforeTest
	public void setData() {
		excelFileName="LoginCredentials";
	}
	
	// Test Case 001 to validate login/logout functionality using different Roles

	@Test(dataProvider = "readData")
	public void OrangeHRM_001(String user, String password, String LoginName) {
	
		new LoginPage()
		.enterUser(user)
		.enterPassword(password)
		.clickLogin()
		.validateEmployeeLogin(LoginName)
		.clickDropDown()
		.clickLogout();
	}

}
