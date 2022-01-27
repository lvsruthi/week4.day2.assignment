package week4.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitAppear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				
				driver.manage().window().fullscreen();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				driver.get("http://www.leafground.com/pages/appear.html");
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				
				WebElement Appear = driver.findElement(By.xpath("//button[@id='btn']"));
				
				wait.until(ExpectedConditions.textToBePresentInElement(Appear, "Voila! I'm here Guys"));
				
				driver.close();
				

	}

}
