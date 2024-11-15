package day52_listeners_extent_reports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Invocation_count {
	
	WebDriver driver;
	@BeforeClass
	void setup() 
	{
		driver=new ChromeDriver();
		driver.get("https://randomuser.me/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(invocationCount=3, invocationTimeOut=3000, threadPoolSize=2)
	void validationtest() throws InterruptedException
	
	{ 
		WebElement email=driver.findElement(By.xpath("//li[@data-label='email']"));
		Actions act =new Actions(driver);
		act.moveToElement(email).perform();
		String text=driver.findElement(By.xpath("//p[@id='user_value']")).getText();
		System.out.println(text);
		
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		WebElement email1=driver.findElement(By.xpath("//li[@data-label='email']"));
		act.moveToElement(email1).perform();
		String text1=driver.findElement(By.xpath("//p[@id='user_value']")).getText();
		System.out.println(text1);
		
		Assert.assertEquals(text, text1);
		
		System.out.println("test failed");
		
		
		
	}
	@AfterClass
	void teardown()
	{
		driver.close();
	}
	
	
	
	
//how do i know that it is mouse hover action or normal inspecting the element 
	//how to validate the image is also changing everytime
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
