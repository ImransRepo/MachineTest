package orangeHRM.testcases;

import org.testng.annotations.Test;

import orangeHRM.baseRequest.BaseMethods;
import orangeHRM.pages.LoginPage;

public class TC002_Fetch_EmpDetails extends BaseMethods {
	
	// Test Case 002 to validate Employee details based on Employee ID
	
	@Test
	public void OrangeHRM_002() {
		
		new LoginPage()
		.enterPassword("admin")
		.enterPassword("admin123")
		.clickLogin()
		.validateEmployeeLogin("Jacqueline White")
		.clickPIM()
		.selectEmployeeList()
		.FetchEmployeeDetails();
	}

}
