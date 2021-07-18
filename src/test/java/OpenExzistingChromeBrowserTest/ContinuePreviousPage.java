package OpenExzistingChromeBrowserTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ContinuePreviousPage {
 WebDriver driver;
	public  void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
	  options.setExperimentalOption("debuggerAddress", "localhost:9922");
	
	  
	  driver = new ChromeDriver(options);
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	 System.out.println("Base page Titile is : "+ driver.getTitle());
	
	 driver.findElement(By.name("q")).sendKeys("Selenium"+Keys.ENTER);
	 
	 System.out.println("Next page title is : "+ driver.getTitle());
	
	 driver.findElement(By.xpath("//span[text()='Selenium webDriver']//ancestor::a")).click();

	
	}

//  Set the chrome.exe path into system variable path
//	execute the below command before start executing the script
//	Chrome.exe --remote-debugging-port=9922 chrome.exe --user-date-dir=<some directory>
//   Note - can select any poet number in above acommand (4 digits)
//  Ex - > chrome.exe --remote-debugging-port=9922 chrome.xe --user-data-dir= ADDressOfChromeDriverInCDrive



}

