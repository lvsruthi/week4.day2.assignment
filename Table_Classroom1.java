package week4.day2.assignment;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Table_Classroom1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		
		//login in https://erail.in/
		driver.get("https://erail.in/");
		
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MS", Keys.ENTER);
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MDU", Keys.ENTER);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Thread.sleep(5000);
		
		List<WebElement> trainName = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]"));
		Thread.sleep(10000);
		
		//Set to restore the trainNAme to check duplicates
		Set<String> nonDupSet = new HashSet<String>();
		//to store duplicate values alone
		Set<String> DupSet = new HashSet<String>();
		
		int i =1;
		//print the Train names
		for( WebElement foreachName : trainName)
		{
			String name = foreachName.getText();
				
     		boolean result = nonDupSet.add(name);
					if(true)
						nonDupSet.add(name);
					else
						DupSet.add(name); 
					System.out.println(i+":"+name);
					i++;
			
		}	
		
		//if Set(no duplicates is equal to LIST)
		System.out.println("List count" + trainName.size() + "  Set Count " +nonDupSet.size());
		if(trainName.size() == nonDupSet.size())
		{
			System.out.println("There are no duplicates");
			
		}
		else
		{
			System.out.println("The Duplicates are "+ DupSet);
			
		}
		driver.close();
		
	}

}
