package week4.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitTextChange {
	
	public static void main(String args[])
	{
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://www.leafground.com/pages/disapper.html");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement change = driver.findElement(By.xpath("//button[@id='btn']/b"));
		
		wait.until(ExpectedConditions.invisibilityOf(change));
		
		driver.close();
	}
	
	
}
