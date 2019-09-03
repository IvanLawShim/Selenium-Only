package demo_one;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class test_one {

	public static void main(String[] args) {
		System.out.println("Start Demo.");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Christian\\Documents\\Projects\\Selenium Test\\Demo Selenium\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String PageSrc;
		
		driver.get("http://vpw.45f.myftpupload.com/shop/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"top\"]")).sendKeys(Keys.ESCAPE);
		PageSrc = driver.getPageSource();
		
		if (PageSrc.contains("apple-mobile-web-app-capable") && PageSrc.contains("mobile-web-app-capable")) {
			System.out.println("\n\n\n\nSuccess!" + "\n\n\nThe appopriate meta tag is present.\n\n\n");
			driver.close();
		}
		else {
			System.out.println("\n\n\n\nFailed" + "\n\n\nThe appropiate meta tag is not present.\n\n\n");
			driver.close();
		}
		
		
	}

}
