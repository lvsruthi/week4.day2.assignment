package week4.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_Classroom3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*ClassRoom3:
			1. Navigate to http://www.leafground.com/pages/Dropdown.html
			2. Select Selenium and LoadRunner from dropdown
		*/
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("—disable-notifications");
		
		//login in https://www.snapdeal.com/
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		
	    WebElement DropDown1 = driver.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[1]"));
	    WebElement DropDown2 = driver.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[4]"));
	  
	    
	    Actions builder = new Actions(driver);
	    builder.keyDown(Keys.CONTROL).click(DropDown1).click(DropDown2).keyUp(Keys.CONTROL).perform();
	    Thread.sleep(1000);
	    
	

	}

}
