package orangeHRM.baseRequest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import orangeHRM.utils.ExcelDataProvider;

public class BaseMethods {

	public static ChromeDriver driver;
	public String excelFileName;

	// Set up ChromeDriver and load URL

	@BeforeSuite
	public void login() {

		System.setProperty("webdriver.chrome.driver", "./drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	// Close the current Window

	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}

	// Read the data from DataProvider
	
	@DataProvider(name = "readData")
	public String[][] sendData() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
		String[][] excelData = data.readExcelData(excelFileName);
		return excelData;
	}

}
