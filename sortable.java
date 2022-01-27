package week4.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sortable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//draggable link
		
		driver.get("https://jqueryui.com/sortable/");
		
		
		//move to frame 0
		driver.switchTo().frame(0);
		//to select 1 3 5
		WebElement one = driver.findElement(By.xpath("//ul[@id='sortable']/li[1]"));
		WebElement five = driver.findElement(By.xpath("//ul[@id='sortable']/li[5]"));
		
		//Actions class
		Actions builder = new Actions(driver);
		
	//	builder.clickAndHold(one).moveToElement(five).release().perform();
		builder.clickAndHold(one)
		.dragAndDrop(one, five)
		.release()
		.perform();
		
		Thread.sleep(1000);
		driver.close();
		
		
	}

}
