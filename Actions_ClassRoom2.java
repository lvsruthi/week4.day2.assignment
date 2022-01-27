package week4.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_ClassRoom2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*    ClassRoom2:
			1. Navigate to https://www.snapdeal.com/
			2. Hover on (go to source and present f8 or function f8 -> screen will be passed) Men's Fashion and select Shirts
			3. Hover on First Result and Click on Quick View
			4. Close the browser */
			
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//login in https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		
		Actions builder = new Actions(driver);
		WebElement men = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		WebElement shirt= driver.findElement(By.linkText("Shirts"));
		//hover over to mens fashion
		builder.moveToElement(men).pause(1000).click(shirt).perform();
		
		Thread.sleep(5000);
	//	driver.findElement(By.xpath("span[text()='Shirts']")).click();
		/* this can be added in builder action
		 * driver.findElement(By.linkText("Shirts")).click();
		 */
			
		//hover over 1st result
		 WebElement FrstImage = driver.findElement(By.xpath("//picture[@class='picture-elem']"));
		 builder.moveToElement(FrstImage).perform();
		 Thread.sleep(2000);
		 
		//click on quick view
		 driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		 
		

	}

}
