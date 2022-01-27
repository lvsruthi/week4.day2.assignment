package week4.day2.assignment;

import java.time.Duration;
import java.util.ResourceBundle.Control;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//draggable link
		
		driver.get("https://jqueryui.com/selectable/");
		
		
		//move to frame 0
		driver.switchTo().frame(0);
		//to select 1 3 5
		WebElement one = driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"));
		WebElement three = driver.findElement(By.xpath("//ol[@id='selectable']/li[3]"));
		WebElement five = driver.findElement(By.xpath("//ol[@id='selectable']/li[5]"));
		
		//Actions class
		Actions builder = new Actions(driver);
		
		builder.keyDown(Keys.CONTROL).click(one).click(three).click(five).keyDown(Keys.CONTROL).perform();
		

	}

}
