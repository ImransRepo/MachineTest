package orangeHRM.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import orangeHRM.baseRequest.BaseMethods;

public class DashboardPage extends BaseMethods {

	// Validate Logged in user

	public DashboardPage validateEmployeeLogin(String LoginUser) {
		WebElement uName = driver.findElementById("account-name");
		Assert.assertTrue(uName.getText().contains(LoginUser));
		return this;
	}

	// Click on PIM

	public DashboardPage clickPIM() {
		driver.findElementByLinkText("PIM").click();
		return this;
	}

	// Select Employee List

	public DashboardPage selectEmployeeList() {
		driver.findElementByLinkText("Employee List").click();
		return this;

	}

	// Get Employee Details

	public void FetchEmployeeDetails() {

		// Get No. of Rows & Columns in the table

		List<WebElement> rows = driver.findElementsByXPath("//table[@id='employeeListTable']/tbody/tr");
		int totalRows = rows.size();
		System.out.println("Total Rows count = " + totalRows);

		List<WebElement> cols = driver.findElementsByXPath("//table[@id='employeeListTable']/thead/tr/th");
		int totalColumns = cols.size();
		System.out.println("Total Columns count = " + totalColumns);

		// Create a Map to store Emp_ID as key and Emp_Details as value

		HashMap<String, String> map = new HashMap<String, String>();

		// Iterate through each row of employee

		for (int i = 1; i < rows.size(); i++) {

			// 1. Get Employee ID
			WebElement empId = driver
					.findElementByXPath("//table[@id='employeeListTable']/tbody[1]/tr[" + i + "]/td[2]");
			// 2. Get Employee Name
			WebElement empName = driver
					.findElementByXPath("//table[@id='employeeListTable']/tbody[1]/tr[" + i + "]/td[3]");
			// 3. Get Job Title
			WebElement jobTitle = driver
					.findElementByXPath("//table[@id='employeeListTable']/tbody[1]/tr[" + i + "]/td[4]");
			// 4. Get Employee Status
			WebElement empStatus = driver
					.findElementByXPath("//table[@id='employeeListTable']/tbody[1]/tr[" + i + "]/td[5]");
			// 5. Get Sub Unit
			WebElement subUnit = driver
					.findElementByXPath("//table[@id='employeeListTable']/tbody[1]/tr[" + i + "]/td[6]");

			// Set Key = Employee ID
			String key = empId.getText();

			// Set Value = Employee Details
			String value = "Employee Name = " + empName.getText() + " , " + "Job Title = " + jobTitle.getText() + " , "
					+ "Employee Status = " + empStatus.getText() + " , " + "Sub Unit = " + subUnit.getText();

			map.put(key, value);

		}

		// Print Details (Value) of each Employee ID ( Key)

		for (Map.Entry<String, String> entry : map.entrySet()) {

			System.out.println("Employee ID = " + entry.getKey() + "  " + entry.getValue());

		}
	}

	// Select Drop-down containing Logout option

	public DashboardPage clickDropDown() {
		driver.findElementByXPath("//i[@class='material-icons']").click();
		return this;
	}

	// Click Logout option

	public void clickLogout() {
		driver.findElement(By.id("logoutLink")).click();
	}
}
