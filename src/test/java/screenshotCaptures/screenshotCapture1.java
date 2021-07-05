package screenshotCaptures;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshotCapture1 {
	
  public static void  ScreenShot(WebDriver driver, String FileName) throws IOException
	 {
		 File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 try
		 {
	     FileUtils.copyFile(file, new File("G:\\eclipse-workspace\\com.automationpractice\\src\\test\\java\\screenshotCaptures"+FileName+System.currentTimeMillis()+".jpg")); 
		 }
		 catch (Exception e) 
		 {
			 e.printStackTrace();
		 }
     }
}
