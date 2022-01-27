package week4.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//draggable link
		
		driver.get("https://jqueryui.com/resizable/");
		
		
		//move to frame 0
		driver.switchTo().frame(0);
		
		//Actions class
		Actions builder = new Actions(driver);
		WebElement size = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		
		//both works
		builder.click(size).dragAndDropBy(size, 100, 50).perform();
	//	builder.clickAndHold(size).moveByOffset(100, 50).perform();
		
		


	}

}
