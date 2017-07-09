package actitime;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Desired {
	
	
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}

	public static void main(String[] args) {
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		
		//WebDriver driver = new ChromeDriver(capabilities);
		
		WebDriver driver = new FirefoxDriver(capabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://the-internet.herokuapp.com/drag_and_drop");
		
		WebElement colA = driver.findElement(By.xpath(".//*[@id='column-a']"));
		
		WebElement colB = driver.findElement(By.xpath(".//*[@id='column-b']"));
		
		Actions draganddrop = new Actions(driver);
		
		draganddrop.dragAndDrop(colB, colA).build().perform();
		
		draganddrop.dragAndDrop(colA, colB).build().perform();	

	}

}
