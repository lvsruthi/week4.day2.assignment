package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		//1.Load the uRL https://www.amazon.in/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().fullscreen();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//amazon link
		driver.get("https://www.amazon.in/");
		//disable Notifications
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		//2.search as oneplus 9 pro 
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("oneplus 9 pro");
		//search.sendKeys(Keys.ENTER);
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		
		//3.Get the price of the first product
		String FirstPrice = driver.findElement(By.className("a-price-whole")).getText();
		System.out.println("The price of first phone is "+ FirstPrice );
		
		//convert string price to integer
		FirstPrice = FirstPrice.replaceAll("[^\\d.]", "");
		int FPrice = Integer.parseInt(FirstPrice);
		System.out.println("The price of first phone is "+ FPrice );
		
		//4. Print the number of customer ratings for the first displayed product
		WebElement CustomerRating = driver.findElement(By.xpath("(//a[@class='a-link-normal s-link-style']/span)[2]"));
		System.out.println("No of customer Ratings is" + CustomerRating.getText());
		
		driver.findElement(By.xpath("(//span[@class='a-icon-alt'])[1]/parent::i")).click();
			
		//5. Mouse Hover on the stars
		WebElement rating= driver.findElement(By.xpath("(//i[@class='a-icon a-icon-popover'])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(rating).perform();
		
		//6. Get the percentage of ratings for the 5 star.
		String ReviewPercentage = driver.findElement(By.xpath("(//span[@class='a-size-base']/a)[2]")).getText();
		System.out.println("Percentage of 5% star rating is "+ ReviewPercentage);
		
		//7. Click the first text link of the first image
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		
		//8. Take a screen shot of the product displayed
		//go to the next window
		Set <String> Windows = driver.getWindowHandles();
		List<String> Window = new ArrayList<String>(Windows);
		driver.switchTo().window(Window.get(1));
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/amazon.png");
		FileUtils.copyFile(source, dest);
				
		//9. Click 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();
		
		Thread.sleep(3000);
		//10. Get the cart subtotal and verify if it is correct.
		WebElement SubTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
		String subs = SubTotal.getText();
		subs = subs.replace(".00","").replaceAll("[^0-9]", "");
		int IntSubs = Integer.parseInt(subs);
		System.out.println("The SubTotal is "+ subs);
		System.out.println("The SubTotal is "+ IntSubs);
		
		if( FirstPrice.contains(subs))
			System.out.println(FirstPrice + "Price Matches" + subs);
		else
			System.out.println("Price did not match");
		
		driver.quit();
	}

}
