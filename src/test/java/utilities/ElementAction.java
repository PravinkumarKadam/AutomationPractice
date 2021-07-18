package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import _1_ReadPropertiesFile._1_ReadPropertiesFile;

import java.util.List;
import java.util.Properties;


public class ElementAction {

	 JavaScriptUtil javaScriptUtil;
     WebDriver driver;
     WebDriverWait wait;
     Actions action;
     Properties prop;


    /*
     * This constructor initialize
     * webDriver, WebDriverWait, Actions, Properties & Utils;
     * (Interface or Class)
     */

    public ElementAction(WebDriver driver) 
    {
       this.driver = driver;
       _1_ReadPropertiesFile configFile = new _1_ReadPropertiesFile();
       prop = configFile.init_prop();
       wait = new WebDriverWait(driver, Integer.parseInt(prop.getProperty("WeWebDriverWaitTimeout")));
       javaScriptUtil = new JavaScriptUtil(driver);
    }

    public  WebElement getElement(By locator)
    {
        WebElement element = null;
        if (prop.getProperty("flashTheElement").equalsIgnoreCase("yes") && prop.getProperty("drawBorderToElement").equalsIgnoreCase("yes"))
        {  
        	element = driver.findElement(locator);
            javaScriptUtil.drawBorder(element);
        	javaScriptUtil.flash(element); 
        }
        else if (prop.getProperty("flashTheElement").equalsIgnoreCase("yes"));
        {
        	element = driver.findElement(locator);
        	javaScriptUtil.drawBorder(element);
        }
      
          element = driver.findElement(locator);  
       
    return element;
    }

    public  List<WebElement> getElementsList(By locator)
    {
    	List <WebElement> element = null;
    	element = (List<WebElement>) driver.findElement(locator);
    	return element;
    }
    
    public  void doClick(By locator)
    {
    	getElement(locator).click();
    }

    public  void doActionsClick(By locator)
    {
	  action.click(getElement(locator)).build().perform();
    }
     
    public  void doSendKeys(By locator, String value)
    {
    	getElement(locator).sendKeys(value);
    }

    public  void doactionsSendKeys(By locator, String value) 
     {
    	 action.sendKeys(getElement(locator),value).build().perform();
     }

    public  boolean doIsDisplayed(By locator) 
    {
     	boolean flag = false;
	    flag = getElement(locator).isDisplayed();
	    return flag;
    } 

    public  boolean doIsSelected(By locator) 
    {
     	boolean flag = false;
	    flag = getElement(locator).isSelected();
	    return flag;
    } 
    
    public  void waitForElementPresent(By locator)
    {
    	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    public  void waitForFrameAvailableAndSwitchToIt(By locator)
    {
    	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }
    
    public  void waitFor(By locator)
    {
    WebElement element = getElement(locator);
    	wait.until(ExpectedConditions.invisibilityOf(element));
    }
    
    
}
