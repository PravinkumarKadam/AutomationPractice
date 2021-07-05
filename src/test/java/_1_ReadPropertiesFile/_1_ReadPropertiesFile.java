package _1_ReadPropertiesFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
 
public class  _1_ReadPropertiesFile {

   static  WebDriver driver ;
   static WebDriverWait wait;
   static Properties prop;

    public static Properties init_prop() 
    {
         prop = new Properties();
     try 
     {
    	 FileInputStream fip = new FileInputStream("G:\\eclipse-workspace\\com.automationpractice\\src\\test\\resources\\conf.properties");
     	  prop.load(fip); 
     }
     catch(FileNotFoundException e)
     {
    	 System.out.println("Config.properties file not found please give correct path");
    	 e.printStackTrace();
     }
     catch(IOException e)
     {
    	 System.out.println("IOException occurd while loading the Config.properties file");
    	 e.printStackTrace();
     }
        return prop;
    }


    public  static WebDriver init_driver(Properties prop)
    {
        String browserName = prop.getProperty("browser");

        System.out.println("Running on ----->" + browserName + "browser" + "," + System.getProperty("os.name") + "," + System.getProperty("os.arch") + "," + System.getProperty("os.version") + ", Java version: " + System.getProperty("java.version"));

        if (browserName.equalsIgnoreCase("chrome"))
        {
            System.getProperty("WebDriver.Chrome.Driver","ChromeDriver.exe");

            if (prop.getProperty("headless").equalsIgnoreCase("yes"))
            {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                 driver = new ChromeDriver(options);
            }
            else
            {
                driver = new ChromeDriver();
            }
        }

        if (prop.getProperty("maximize").equalsIgnoreCase("yes"))
        {
            driver.manage().window().maximize();
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("ImplicitWait")),TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
       return driver;
    }
    

}
