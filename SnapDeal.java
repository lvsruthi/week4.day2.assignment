package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//1. snapdeal link
		driver.get("https://www.snapdeal.com/");
		
		//2. Go to Mens Fashion
		WebElement men = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(men).perform();
		
		//3. Go to Sports Shoes
	    driver.findElement(By.xpath("(//span[text()=\"Sports Shoes\"])[1]")).click();
		
		//4. Get the count of the sports shoes
		String count = driver.findElement(By.xpath("//h1[@class='category-name']/following-sibling::span")).getText();
		System.out.println("Count is "+ count);
				    
		//5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes'][1]")).click();
		
		//6. Sort by Low to High
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
		
		Thread.sleep(2000);
		
		//7. Check if the items displayed are sorted correctly
		List <WebElement> Rates = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		int size = Rates.size();
		for( int i =0; i < size; i++)
		{
		   
			WebElement rate = Rates.get(0);
			String product_rate = rate.getText();
			WebElement rate1 = Rates.get(1);
			String product_rate1 = rate.getText();
			System.out.println("Its in increasing order " + product_rate);
          // if(product_rate<=product_rate1)
        	 //  System.out.println("Its in increasing order " + rate + rate1);
		}
		
		//8.Select the price range (900-1200)
		WebElement fromval =driver.findElement(By.name("fromVal"));
		fromval.clear();
		fromval.sendKeys("900");
		WebElement toVal =driver.findElement(By.name("toVal"));
		toVal.clear();
		toVal.sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		
		Thread.sleep(2000);
		
		//9.Filter with color Navy 
		driver.findElement(By.xpath("//a[text()=' Navy']/parent::label")).click();
	
		//10 verify the all applied filters 
		String Color = driver.findElement(By.xpath("(//div[@class='filters'])[1]/div[2]/a")).getText();
		String price = driver.findElement(By.xpath("(//div[@class='filters'])[1]/div[1]/a")).getText();
		System.out.println("Color and Price are"+ Color + price);
		
		if(price.contains("Rs. 900 - Rs. 1200")&&(Color.contains("Navy")))
			System.out.println("Both color and price filters are there");
				
		//11. Mouse Hover on first resulting Training shoes
			WebElement FirstShoe = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
		//12. click QuickView button
			builder.moveToElement(FirstShoe).perform();
			 driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
						
	    //its not a new window so used index (0)
			 Set<String> windows = driver.getWindowHandles();
			 List<String> window = new ArrayList<String>(windows);
			 driver.switchTo().window(window.get(0));
		//13. Print the cost and the discount percentage
			 String cost =  driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
			 String Percentage = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
			 System.out.println("The cost is"+ cost + "The percentage is "+ Percentage);
				
		//14. Take the snapshot of the shoes.
			 File source = driver.getScreenshotAs(OutputType.FILE);
			 File Dest = new File("./screenshot/img.png");
			 FileUtils.copyFile(source, Dest);
		//15. Close the current window
			 Thread.sleep(1000);
			 driver.close();
			 
		//16. Close the main window
			 driver.quit();
		
	
	}

}
