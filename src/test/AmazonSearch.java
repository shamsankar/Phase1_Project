package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");    
		
		//Maximize window
		driver.manage().window().maximize();
		
		//wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		
		WebElement searchtext = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchtext.sendKeys("iphone 12");
		
		WebElement searchicon =driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchicon.click();
		List<WebElement> iphonename = driver.findElements(By.xpath("//span[@class ='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> iphoneprice = driver.findElements(By.xpath("//span[@class ='a-price-whole']"));
        
        System.out.println(iphonename.size()); //get the Price
        
        for(int count=0; count<iphonename.size(); count++)
        {
        	if (iphonename.get(count).getText().toLowerCase().contains("iphone 12")) {
        		
			System.out.println("I Phone Name :" + iphonename.get(count).getText() + "I Phone Price: " + iphoneprice.get(count).getText());
		
        }
        
        }
        
        driver.close();

	}

}
