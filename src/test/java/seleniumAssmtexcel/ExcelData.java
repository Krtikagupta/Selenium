package seleniumAssmtexcel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExcelData {
	WebDriver driver=null;
	ExtentHtmlReporter htmlreport;
	ExtentReports extent;


	@BeforeTest
	public void starttest() {
		htmlreport = new ExtentHtmlReporter("extentexcel.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/Driver/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test(dataProvider = "testdata1" )

	public void runtest(String username, String password) throws InterruptedException {
		System.out.println(username+ " | "+password);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(3000);
		driver.close();


	}

	@DataProvider(name= "testdata1")
	public   Object[][] getdata() {
		ExtentTest test1 = extent.createTest("Testing on orangehrm", "This is to validate search");
		test1.log(Status.INFO, "Starting the test");
		String excelpath= "F:/eclipse work/SeliniumFramework/excelfile/MyData.xlsx";
		Object data[][]= testdata(excelpath, "Sheet1");
		return data;

	}

	public static Object[][]testdata(String excelPath, String sheetName) {
		excelclass excel = new excelclass(excelPath, sheetName);
		int rowcount = excel.rowcount();
		int colcount = excel.colcount();
		Object data[][]= new Object[rowcount-1][colcount];


		for(int i=1; i<rowcount; i++) {
			for(int j=0; j<colcount; j++) {
				String celldata= excel.coldataStr(i, j);
				System.out.print(celldata+" | ");
				data[i-1][j]= celldata;
			}

		}
		return data;

	}

	@AfterTest
	public void endtest() {
		driver.close();
		driver.quit();
		System.out.println("Ran sucessfully...");
		extent.flush();

	}

}
