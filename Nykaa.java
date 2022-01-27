package week4.day2.assignment;

import java.util.List;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//nykaa link
		driver.get("https://www.nykaa.com/");
		
		//hover over on Brands
		
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		WebElement Loreal = driver.findElement(By.xpath("//a[text()=\"L'Oreal Paris\"]"));
		
		//Actions Class
		Actions builder = new Actions(driver);
		//Mouseover on Brands and Search L'Oreal Paris
		builder.moveToElement(brands).click(Loreal).perform();
		
		// Check the title contains L'Oreal Paris(Hint-GetTitle)
		String Title = driver.findElement(By.xpath("//h1[1]")).getText();
		System.out.println("Title is "+ Title);
		
		if(Title.contains("L'Oreal Paris"))
			System.out.println("List is displayed properly for L'Oreal Paris");
		else
			System.out.println("List is not displayed for L'Oreal Paris");
		
		//Click sort By and select customer top rated
		WebElement sortBy= driver.findElement(By.xpath("//span[@class='sort-name']"));
		sortBy.click();
		WebElement topCustomerRated= driver.findElement(By.xpath("//span[@class='title' and text()='customer top rated']"));
		topCustomerRated.click();
		
		//Click Category and click Hair->Click haircare->Shampoo
		
		//WebElement Category= 
		        Thread.sleep(2000);
				driver.findElement(By.xpath("//span[@class='title ' and text()='Category']")).click();
		//WebElement Hair= 
		        Thread.sleep(2000);
				driver.findElement(By.xpath("//span[@class='filter-name ' and text()='Hair']")).click();
		//WebElement HairCare= 
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		//WebElement shampoo=
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		//builder.click(Category).click(Hair).click(HairCare).click(shampoo).perform();
		
		//Click->Concern->Color Protection
				Thread.sleep(2000);
		//WebElement concern= 
				driver.findElement(By.xpath("//span[text()='Concern']")).click();
		 		Thread.sleep(2000);
		//WebElement colorProtection= 
		 		driver.findElement(By.xpath("//span[@class='title' and text()='Color Protection']")).click();
		//builder.click(concern).click(colorProtection).perform();
		
		//check whether the Filter is applied with Shampoo
		String filtervalue1= driver.findElement(By.xpath("(//span[@class='filter-value'])[1]")).getText();
		System.out.println("Filter is"+ filtervalue1);
		if(filtervalue1.contains("Shampoo"))
				System.out.println("Shampoo filtered is applied");
		else
			System.out.println("Shampoo filtered is not applied");
		
		//Click on L'Oreal Paris Colour Protect Shampoo
		WebElement FrstProduct= driver.findElement(By.xpath("(//div[@class='productWrapper css-la441k'])[1]"));
		FrstProduct.click();
		//go to next window
		Set<String> windows = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windows);
		driver.switchTo().window(window.get(1));
		
		//select size
		WebElement Size= driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select options = new Select(Size);
		options.selectByVisibleText("175ml");
		
		//print MRP
		String MRP= driver.findElement(By.xpath("(//span[text()='MRP:'])[1]/following-sibling::span")).getText();
		System.out.println("The MRP is "+ MRP);

		//add to bag
		driver.findElement(By.xpath("(//span[text()='ADD TO BAG'])[1]")).click();
		//go to shopping bag
		//WebElement shoppingBag= 
		driver.findElement(By.xpath("//span[text()='Account']/following::div[1]")).click();
		
		//goes to frame
		driver.switchTo().frame(0);
		
		//print grand total
		String grandTotal= driver.findElement(By.xpath("(//span[text()='Grand Total'])[1]/parent::div/following-sibling::div")).getText();
		System.out.println("Total is "+ grandTotal);
		
		//Continue Button
				driver.findElement(By.xpath("//i[@class='proceed-arrow']")).click();
				
				
		//continue as guest
		 //WebElement continueAsGuest= 
				driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		
		//secondGrandTotal		
		String SecondgrandTotal= driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		System.out.println("Second Total is "+ SecondgrandTotal);
		
		if(grandTotal.contains(SecondgrandTotal))
			System.out.println("Total MAtched");
		else
			System.out.println("Total doesnt match");
		Thread.sleep(1000);
		driver.quit();
		
		
		
		
	}

}
