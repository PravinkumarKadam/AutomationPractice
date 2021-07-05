package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UseCaseOFJavaScript {
 
	static WebDriver driver;
	
	@Before
	public void setUp()
	{
		System.setProperty("WebDriver.Chrome.Driver", "ChromeDriver.exe");
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    	driver.get("https://www.irctc.co.in/nget/train-search");

	}
	
	@Test
	public void _0_test() throws InterruptedException 
	{
		Thread.sleep(5000);
	
	 WebElement LogInButton = driver.findElement(By.xpath("(//a//label[ @class=\"search_btn\" and text()='PNR STATUS'])[1]"));
	 //LogInButton.click();
	 ClickElementByJS(LogInButton);
	 sendKeyUsingJSSwithID("userId","textUser");
	 Thread.sleep(3000);
	 System.out.println(driver.getTitle());
	}
	






    public static void  ClickElementByJS(WebElement element)
     {
       JavascriptExecutor js = ((JavascriptExecutor)driver);
       js.executeScript("arguments[0].click();", element);	 
     }
      
    public static void scrolPageDown() 
     {
         JavascriptExecutor js = ((JavascriptExecutor)driver);
         js.executeScript("window.scrollTO(0,document.body.scrollHeight)"); 	     
     }
 
    public static void drawBorder(WebElement element)
     {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].style.border ='3px solid red'",element); 	            
      }

    public static void sendKeyUsingJSSwithID(String id, String value)
     {
   	   JavascriptExecutor js = ((JavascriptExecutor)driver);
       js.executeScript("document.getElementById('"+id+"').value='"+value+"'"); 	            
     }
     
     public static void openNewWindowTab(String newURL)
      {
   	    JavascriptExecutor js = ((JavascriptExecutor)driver);
   	    js.executeScript("window.open();"); 	            
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        driver.get(newURL);
      }

}


