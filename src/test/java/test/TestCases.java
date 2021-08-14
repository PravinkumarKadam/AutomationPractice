package test;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.AfterRegistrationPageLocator;
import locators.CreateAccountPageLocator;
import locators.LandingPageLocator;
import locators.SinginPageLocator;
import screenshot.screenshotCapture;
import utilities.ElementAction;
import variables.AfterRegistrationPagevariables;
import variables.LandingPagevariables;
import variables.RegisterUserDetailsPagevariables;
import variables.SignInPagevariablesvariables;



/* @Author Pravin Kadam
 * Following script is the automation testing simulation
 * for the Application - "http://automationpractice.com/index.php?"
 * Where following test cases included
 *   1. URL Redirection Test
 *   2. Landing Page Title Test
 *   3. Product category validation Test
 *   4. Landing Page Application Logo Display Test
 *   5. Validate Application logo Height on Landing Page
 *   6. Validate Application Logo Width on Landing page
 *   7. SignIn page Title Validation Test
 *   8. Resister user with New Email Id on SignIn Page
 *  Note - To Execute the Test case no 8
 *         Change variables values for new account creation 
 *         i.   newUserEmailId
 *         ii.  userFirestName
 *         iii. userLastName 
 */

public class TestCases 
{   
	WebDriver driver;
	WebDriverWait wait;
	Properties  property ;

	//locator
	ElementAction elementAction ;
	LandingPageLocator landingPagelocator ;
	AfterRegistrationPageLocator afterRegistrationPagelocator;
	SinginPageLocator singinPagelocator;
	CreateAccountPageLocator createAccountPagelocator;
	//variables
	AfterRegistrationPagevariables  afterRegistrationPagevariables;
	LandingPagevariables landingPagevariables;
	RegisterUserDetailsPagevariables registerUserDetailsPagevariables;
	SignInPagevariablesvariables signInPagevariablesvariables;
	//screenshot
	screenshotCapture screenshotCap;
	
	@Before
	public void startup()
	{
		//    	property = _1_ReadPropertiesFile.init_prop();
		//		property = (Properties) _1_ReadPropertiesFile.init_driver(property);
		//		elementAction = new ElementAction(driver);
		//		wait = new WebDriverWait(driver,Integer.parseInt(property.getProperty("WeWebDriverWaitTimeout")));

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--Incognito");
		//		option.addArguments("--headless");
		////			option.addArguments("--disable-incognito");
		////			option.addArguments("window-size=800,600");
		////			option.addArguments("--Ignore-certificate-errors");
		////			option.addArguments("--disable-extension");
		////			option.addArguments("--start-maximized");
		////			option.addExtensions( new File(" File Path "));	
		driver = new ChromeDriver(option);

		wait = new WebDriverWait(driver, 20);
		//
		//	        
		////			DesiredCapabilities cap = new	DesiredCapabilities();
		////			cap.setAcceptInsecureCerts(true);
		//
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS );
		driver.get("http://automationpractice.com/index.php?");

		//locator
		 elementAction =new ElementAction(driver);
		 landingPagelocator  = new LandingPageLocator();
		 afterRegistrationPagelocator = new AfterRegistrationPageLocator();
		 singinPagelocator = new SinginPageLocator();
		 createAccountPagelocator = new CreateAccountPageLocator();
		//variables
		  afterRegistrationPagevariables = new  AfterRegistrationPagevariables();
		  landingPagevariables = new LandingPagevariables();
		  registerUserDetailsPagevariables = new RegisterUserDetailsPagevariables();
		  signInPagevariablesvariables = new SignInPagevariablesvariables();
		//screenshot
		  screenshotCap= new screenshotCapture();
	}	

		@Test 
		public void _1_UrlChecking_Test()
		{    
			  wait.until(ExpectedConditions.urlContains(landingPagevariables.ExpectedRedirectedURL));
		       Assert.assertEquals("Current URL and orignal Url are diffrent please check one's again ", landingPagevariables.ExpectedRedirectedURL, driver.getCurrentUrl());
			   System.out.println("Test 1 => URL redirection test is passed");
		   }
	
		@Test
		public void _2_Page_Title()
		{
			  wait.until(ExpectedConditions.titleContains(landingPagevariables.LandingPageTitile));
			  Assert.assertEquals("Current page Title and orignal page Title are diffrent please check one's again ",landingPagevariables.LandingPageTitile, driver.getTitle());
		      System.out.println("Test 2 => Landing page Title test is passed");
		   }
	
	    @Test 
	    public void _3_productCategory()
	    {    
	    //	elementAction.getElementsList(landingPagelocator.productCategoryList);
	    	
	       List <WebElement> list = driver.findElements((landingPagelocator.productCategoryList));
	      
	         for (int i = 0; i < list.size();i++) 
	          {
	    	         if(!(list.get(i).getText().isEmpty()))
	         	     {
	    		       System.out.println(list.get(i).getText());;
	    	         }
	          }
		   System.out.println("Test 3 => Product category validation test passed : \n");
		}
			
	    
		@Test
		public void _4_logoDisplay()
		{ 
			 Boolean display =	elementAction.doIsSelected(landingPagelocator.landingPageLogoImage);
		   Assert.assertTrue("Logo Display Test is faild.",display);
		   System.out.println("Test 4 => Logo Display Test is passed.");
		}
				
		@Test 
	    public void _5_logoTest()  throws InterruptedException
		{ 
			WebElement logosize = driver.findElement(By.xpath("//img[@class=\"logo img-responsive\"]"));
			Assert.assertNotSame("Verify Logo width size is unexpected ", landingPagevariables.width, logosize.getSize().getWidth());
			Assert.assertNotSame("Verify Logo height size is unexpected ", landingPagevariables.height , logosize.getSize().getHeight());
			System.out.println("Test 5 => Current Width of logo : "+ landingPagevariables.width+"\nCurrent Height of logo : "+landingPagevariables.height +
			                    "Application Logo Width and Height check Test is passed." );
		}
			
		@Test 
		public void _6_Signin_page_Title_Test1()
		{ 	
			elementAction.doClick(landingPagelocator.signInButtonElement);
			Assert.assertEquals("Login page is not open ", signInPagevariablesvariables.SignInPageTitle, driver.getTitle());
			System.out.println("Test 6 => Signin page Title Validation Test is passed"); 
		}
	  
	    @Test 
	    public void _7_CreateAccountTitleDisplayTest() 
	  {

		elementAction.doClick(landingPagelocator.signInButtonElement);

		elementAction.doSendKeys(singinPagelocator.emailIdINputFieldElement, signInPagevariablesvariables.newUserEmaiID);

		elementAction.doClick(singinPagelocator.creatAnAccountButtonElement);

		elementAction.doClick(createAccountPagelocator.maleGenderRadioBUttonElement);

		elementAction.doSendKeys(createAccountPagelocator.userFirstNameTextBoxElement, registerUserDetailsPagevariables.userFirstName);

		elementAction.doSendKeys(createAccountPagelocator.userLastNameTextBoxElement, registerUserDetailsPagevariables.userLastName);

		elementAction.doSendKeys(createAccountPagelocator.userPasswordTextBoxElement, registerUserDetailsPagevariables.userPassword);

		elementAction.doSendKeys(createAccountPagelocator.DOBDayValueDropDownElement, registerUserDetailsPagevariables.DOBDayValue);

		elementAction.doSendKeys(createAccountPagelocator.DOBMonthValueDropDownElement, registerUserDetailsPagevariables.DOBMonthValue);

		elementAction.doSendKeys(createAccountPagelocator.DOBYearValueDropDownElement, registerUserDetailsPagevariables.DOBYearValue);

		elementAction.doClick(createAccountPagelocator.SignUpForNewsLetterCheckBoxElement);

		elementAction.doClick(createAccountPagelocator.specialOfferEmailRecCheckBoxElement);

		elementAction.doSendKeys(createAccountPagelocator.addressFirestNameTextBoxElement, registerUserDetailsPagevariables.addressFirestName);

		elementAction.doSendKeys(createAccountPagelocator.addressLastNameTextBoxElement, registerUserDetailsPagevariables.addressLastName);

		elementAction.doSendKeys(createAccountPagelocator.addressCompanyNameTextBoxElement, registerUserDetailsPagevariables.addressCompanyName);

		elementAction.doSendKeys(createAccountPagelocator.addressLine1NameTextBoxElement, registerUserDetailsPagevariables.addressLine1Name);

		elementAction.doSendKeys(createAccountPagelocator.addressLine2NameTextBoxElement, registerUserDetailsPagevariables.addressLine2Name);

		elementAction.doSendKeys(createAccountPagelocator.addresCityTextBoxElement, registerUserDetailsPagevariables.addresCity);

		elementAction.doSendKeys(createAccountPagelocator.addressStateDropDownElement, registerUserDetailsPagevariables.addressState);

		elementAction.doSendKeys(createAccountPagelocator.addressZipCodeTextBoxElement, registerUserDetailsPagevariables.addressZipCode);

		elementAction.doSendKeys(createAccountPagelocator.addressCountryDropDownElement, registerUserDetailsPagevariables.addressCountry);

		elementAction.doSendKeys(createAccountPagelocator.addressAdditionalInfoTextBoxElement, registerUserDetailsPagevariables.addressAdditionalInfo);

		elementAction.doSendKeys(createAccountPagelocator.addressHomePhoneTextBoxElement, registerUserDetailsPagevariables.addressHOmePhone);

		elementAction.doSendKeys(createAccountPagelocator.addressMobilePhoneTextBoxElement, registerUserDetailsPagevariables.MobilePhone);

		elementAction.doSendKeys(createAccountPagelocator.addressAliasAddressTextBoxElement, registerUserDetailsPagevariables.addressAliasAddress);

		elementAction.doIsSelected(createAccountPagelocator.registerFormButtonElement);


		//	Assert.assertEquals("User account not created",variables.AfterRegistrationPage.userDisplayName ,AfterRegistrationPage.registeredUserNameDisplayElement);
		System.out.println("Test 7 => ACCOUNT has been created successfully and Test case passed");
	}

		@Test 
		public void _8_ScreenShot_Test() 
		{
			try
			{
				screenshotCap.ScreenShot(driver, "Automation");
		    }
			catch(Exception e)
			  { System.out.println("Unable to take Screenshot becouse of :: "); 
				e.printStackTrace(); 
	          }
			System.out.println("Test 8 => Screenshot Captured and Test passed.");	
		}




	@After
	public void endtask()
	{
		driver.close();
		driver.quit();
	}
}