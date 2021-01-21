package seleniumAssmt;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReports1 {
	ExtentHtmlReporter htmlreport;
	ExtentReports extent;
	WebDriver driver ;


	@BeforeSuite
	public void starttest() {
		htmlreport = new ExtentHtmlReporter("extent1.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		String projectpath = System.getProperty("user.dir");
		System.out.println(projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"/Driver/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();   

	}
	@Test
	public void test() {

		ExtentTest test1 = extent.createTest("Testing on duckduckgo.com", "This is to validate search");
		test1.log(Status.INFO, "Starting the test");
		driver.get("https://duckduckgo.com");
		test1.pass("Navigated to website");

		driver.findElement(By.name("q")).sendKeys("Website automation from scratch");
		test1.pass("Entered text in textbox");
		driver.findElement(By.id("search_button_homepage")).sendKeys(Keys.RETURN);
		test1.pass("Searched");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		test1.pass("Browser closed");
		test1.info("Search sucessfull");

	}


	@AfterSuite
	public void endtest() {
		driver.close();
		driver.quit();
		System.out.println("Ran sucessfully...");
		extent.flush();

	}

}
