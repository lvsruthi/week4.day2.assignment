package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		driver.get("http://www.leafground.com/pages/sorttable.html");
		
		//row count
		int TableRow = driver.findElements(By.xpath("//table[@id='table_id']//tr")).size();
		System.out.println("Table row count is "+ TableRow);
		
		//copy names into List
		List<String> SortedNames = new ArrayList<String>();
		for(int i=1;i<TableRow;i++)
		{
			String name = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]//td[2]")).getText();
			System.out.print(name+  "   ");
			SortedNames.add(name);
		
		}
		//list is sorted
		System.out.println("   ");
		Collections.sort(SortedNames);
		//First list after sorting
		System.out.println("After Storing, the first list");
		for(int i=0;i<TableRow-1;i++)
		{
			System.out.println(SortedNames.get(i));
		}	
		//click on Names to sort
		driver.findElement(By.xpath("//table[@id='table_id']//th[2]")).click();
		//copy names into List2
		List<String> SecondNamesList = new ArrayList<String>();
		for(int i=1;i<TableRow;i++)
		{
			String name = driver.findElement(By.xpath("//table[@id='table_id']//tr["+ i +"]//td[2]")).getText();
			SecondNamesList.add(name);
		}
		
		//PRint the second list
		System.out.println("Without Storing, the SecondList list");
				for(int i=0;i<TableRow-1;i++)
		{
			System.out.println(SecondNamesList.get(i));
		}
		
		
		//validate before list one and list two
		int flag=1;
		for(int i=0;i<TableRow-1;i++)
		{
			String one = SortedNames.get(i);
			String two = SecondNamesList.get(i);
			if(one.equals(two))
				continue;
			else
				{
				flag=0;
				break;
				}
		}
		if(flag==1)
			System.out.println("List match");
		else
			System.out.println("List did not match");
		
		driver.close();
		
	}

}
