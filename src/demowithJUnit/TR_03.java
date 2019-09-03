package demowithJUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TR_03 {
	
	WebDriver driver = utilities.driverfactory.open("chrome");
	WebDriverWait wait2 = new WebDriverWait(driver, 10);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@BeforeMethod
	public void RunningTests() {
		System.out.println("Initializing Test: Checklist #1 --> 3");
		String MeganCoreyShopURL = "http://vpw.45f.myftpupload.com/shop/";
		driver.manage().window().maximize();
		driver.get(MeganCoreyShopURL);	
		System.out.println("Running Test: Checklist #1 --> 3");
	}
	
	@AfterSuite
	public void end() {
		System.out.println("===============================================");
		System.out.println("||      End of Test:  Checklist #1 --> 3     ||");
		System.out.println("===============================================");
		driver.close();
	}
	
	
	@Test
	public void Test1() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//*[@id=\"top\"]")).sendKeys(Keys.ESCAPE);
	
		String ActualURL = driver.getCurrentUrl();
		Assert.assertTrue(ActualURL==ActualURL.toLowerCase(),driver.getTitle()+" is not in Lower Case.");
		Reporter.log("All in Lower Case|" + driver.getTitle());			
	}
	
	@Test
	public void Test2() {
			
		WebElement product_1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/main/div/ul/li[1]/div/a/div[2]/div[2]/div/h2"));
		
		js.executeScript("arguments[0].scrollIntoView();",product_1);
		js.executeScript("arguments[0].click();",product_1);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String product1_url = driver.getCurrentUrl(); 
		
		Assert.assertTrue(product1_url==product1_url.toLowerCase(),driver.getTitle()+" is in Lower Case.");
		Reporter.log("All in Lower Case|" + driver.getTitle());
				
		driver.navigate().back();

	}
	
	@Test
	public void Test3() {
		
		WebElement product_2 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/main/div/ul/li[2]/div/a/div[2]/div[2]/div/h2"));

		js.executeScript("arguments[0].scrollIntoView();",product_2);
		js.executeScript("arguments[0].click();",product_2);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		String product2_url = driver.getCurrentUrl(); 

		Assert.assertTrue(product2_url==product2_url.toLowerCase(),driver.getTitle()+" is in Lower Case.");
		Reporter.log("All in Lower Case|" + driver.getTitle());
		driver.navigate().back();
				
	}
	
	@Test
	public void Test4() {

		WebElement product_3 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/main/div/ul/li[3]/div/a/div[2]/div[2]/div/h2"));

		try {			
			js.executeScript("arguments[0].scrollIntoView();",product_3);
			js.executeScript("arguments[0].click();",product_3);
		} catch (Exception e) {
			js.executeScript("arguments[0].scrollIntoView();",product_3);
			js.executeScript("arguments[0].click();",product_3);
		}

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		String product3_url = driver.getCurrentUrl(); 
		Assert.assertTrue(product3_url== product3_url.toLowerCase(),driver.getTitle()+" is in Lower Case.");
		Reporter.log("All in Lower Case|" + driver.getTitle());
		
	}
	
	@Test
	public void Test5() {
		
		driver.navigate().to("http://vpw.45f.myftpupload.com/cart/");;
		
		String ActualUrl = driver.getCurrentUrl(); 
		
		Assert.assertTrue(ActualUrl==ActualUrl.toLowerCase(),driver.getTitle()+" is in Lower Case.");
		Reporter.log("All in Lower Case|" + driver.getTitle());		
	
	}
	
	@Test
	public void Test6() {
		
		driver.navigate().to("http://vpw.45f.myftpupload.com/checkout/");
		
		String ActualUrl = driver.getCurrentUrl(); 
		
		Assert.assertTrue(ActualUrl==ActualUrl.toLowerCase(),driver.getTitle()+" is in Lower Case.");
		Reporter.log("All in Lower Case|" + driver.getTitle());
	}
	
}
