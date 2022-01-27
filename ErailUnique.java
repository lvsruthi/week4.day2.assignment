package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Launch the URL - https://erail.in/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		driver.get("https://erail.in/");
				
		//Click the 'sort on date' checkbox
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		//clear and type in the from station text field
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("MSB");
		from.sendKeys(Keys.ENTER);
		
		//clear and type in the to station text field
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("BCT");
		to.sendKeys(Keys.ENTER);
		
		//Add a java sleep for 2 seconds
		Thread.sleep(2000);
		
		//Store all the train names in a list
		int row_count = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr")).size();
		List <String> TrainName = new ArrayList<String>();
		for(int i=1;i<=row_count;i++)
		{	
			String names= driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]//td[2]")).getText();
			TrainName.add(names);
		}
		System.out.println("Lis count "+ TrainName.size());
		
		//Add the list into a new Set
		
		Set<String> NamesList = new HashSet<String>(TrainName);
		
		//And print the size of it
		System.out.println("Set count "+ NamesList.size());
		int difference = TrainName.size()- NamesList.size();
		System.out.println("Total No of duplicte Train name is "+ difference);
		
		driver.close();
	}

}
