package seleniumAssmt;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {

	public static void main(String[] args) throws InterruptedException  {

		String projectpath = System.getProperty("user.dir");
		System.out.println(projectpath);
		System.setProperty("webdriver.chrome.driver", projectpath+"/Driver/chromedriver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://duckduckgo.com");
		driver.findElement(By.name("q")).sendKeys("Hi... good evening");
		driver.findElement(By.id("search_button_homepage")).sendKeys(Keys.RETURN);
		
		Thread.sleep(4000);
		driver.close();
		System.out.println("Ran sucessfully...");

	}
}
