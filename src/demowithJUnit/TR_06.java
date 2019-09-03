package demowithJUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TR_06 {
	
	WebDriver driver = utilities.driverfactory.open("chrome");
	WebDriverWait wait2 = new WebDriverWait(driver, 10);
	JavascriptExecutor js = (JavascriptExecutor) driver;
		
	@BeforeMethod
	public void RunningTests() {
		
		System.out.println("Running Test: Checklist #1 --> 6");
		System.out.println("Initializing Test: Checklist #1 --> 6");
		String MeganCoreyURL = "http://vpw.45f.myftpupload.com/";
		driver.manage().window().maximize();
		driver.get(MeganCoreyURL);
	}

	@AfterSuite
	public void EndTests() {
		System.out.println("===============================================");
		System.out.println("||      End of Test:  Checklist #1 --> 6     ||");
		System.out.println("===============================================");
		driver.close();
	}
	
	@Test
	public void Test1() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//*[@id=\"top\"]")).sendKeys(Keys.ESCAPE);

		String PageSrc = driver.getPageSource();
		
		Assert.assertTrue(PageSrc.contains("<!DOCTYPE html>"),"The site does not use and HTML5 doctype declaration.");
		Reporter.log("Contains HTML5 doctype declaration|" + driver.getTitle());
	}
	
	@Test
	public void Test2() {
		driver.navigate().to("http://vpw.45f.myftpupload.com/product");
	}

}
