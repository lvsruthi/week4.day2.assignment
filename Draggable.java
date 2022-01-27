package week4.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//draggable link
		
		driver.get("https://jqueryui.com/draggable/");
		
		
		//move to frame 0
		driver.switchTo().frame(0);

		WebElement drag = driver.findElement(By.xpath("//p[text()='Drag me around']"));
		
		//create object of Actions Class
		Actions builder = new Actions(driver);
		
		//drop in random place
		builder.dragAndDropBy(drag, 100, 200).perform();
		
		
		
	}

}
