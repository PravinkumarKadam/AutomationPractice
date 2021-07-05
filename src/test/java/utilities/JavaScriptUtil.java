package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

	static WebDriver driver;
	
    public JavaScriptUtil(WebDriver driver) 
	 {
		this.driver = driver;
	 }
	
    public static void scrollPageDown(WebDriver driver,WebElement element) 
     {
         JavascriptExecutor js = ((JavascriptExecutor)driver);
         js.executeScript("arguments[0].scrollIntoView(true);",element); 	     
     }

    public void flash(WebElement element)
     { 
    	 JavascriptExecutor js = ((JavascriptExecutor)driver);
         String bgcolor = element.getCssValue("backgroundColor");
         for(int i = 0 ; i<20; i++)
         {
        	 changeColor("rgb(0,200,0)",element);
        	 changeColor(bgcolor, element);
         }
     }
  
    private void changeColor(String color, WebElement element)
     {
    	 JavascriptExecutor js = ((JavascriptExecutor)driver);
         js.executeScript("arguments[0].style.backgroundColor = '"+ color +"'", element);
        try 
          {
	         Thread.sleep(200);
          }
        catch(InterruptedException e) 
          {
            e.printStackTrace();
          }
     }
 
    public static void drawBorder(WebElement element)
    {
      JavascriptExecutor js = ((JavascriptExecutor) driver);
      js.executeScript("arguments[0].style.border ='3px solid red'",element); 	            
    }

    public static void genaratAlert(String massage)
    {
      JavascriptExecutor js = ((JavascriptExecutor) driver);
      js.executeScript("alert('"+ massage +"')"); 	            
    }

    public static void  ClickElementByJS(WebElement element)
    {
      JavascriptExecutor js = ((JavascriptExecutor)driver);
      js.executeScript("arguments[0].click();", element);	 
    }


    public static void  refreshBrowserByJS()
    {
      JavascriptExecutor js = ((JavascriptExecutor)driver);
      js.executeScript("history.go(0)");	 
    }

    public static String  getTiltleByJS()
    {
      JavascriptExecutor js = ((JavascriptExecutor)driver);
      String title = js.executeScript("return document.title;").toString();	 
      return title;
    }

    public static String  getPageInnerText()
    {
      JavascriptExecutor js = ((JavascriptExecutor)driver);
      String pageText = js.executeScript("return document.documentElement.innerText;").toString();	 
      return pageText;
    }

    public static void scrolPageDown() 
    {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("window.scrollTO(0,document.body.scrollHeight)"); 	     
    }

    public static String getBrowserInfo() 
    {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        String uAgent=  js.executeScript("return navigator.userAgent;").toString(); 	     
        return uAgent;
    }
    
    public static void sendKeyUsingJSSwithID(String id, String value)
    {
  	   JavascriptExecutor js = ((JavascriptExecutor)driver);
      js.executeScript("document.getElementById('"+id+"').value='"+value+"'"); 	            
    }
    
    public static void sendKeyUsingJSSwithName(String name, String value)
    {
  	   JavascriptExecutor js = ((JavascriptExecutor)driver);
      js.executeScript("document.getElementById('"+name+"').value='"+value+"'"); 	            
    }
    
    public static void selectValueByCSSJavaScript(String elementCSSValue, String valueToBeEnter)
    {
  	   JavascriptExecutor js = ((JavascriptExecutor)driver);
      js.executeScript("document.getElementById('"+elementCSSValue+"').value='"+valueToBeEnter+"'"); 	            
    }
    
    
    public static void  checkPageIsReady()
    {
      JavascriptExecutor js = ((JavascriptExecutor)driver);
      if(js.executeScript("return document.readyState").toString().equals("complete"));	 
     System.out.println("Page is loaded");
      return ;
    }
    
 
} 





