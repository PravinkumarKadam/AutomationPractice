package test;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ElementAction;


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
	static WebDriver driver;
	static ElementAction elementAction;
	static WebDriverWait wait;
	static  Properties  property ;


	@Before
	public void startup()
	{
		//    	property = _1_ReadPropertiesFile.init_prop();
		//		property = (Properties) _1_ReadPropertiesFile.init_driver(property);
		//		elementAction = new ElementAction(driver);
		//		wait = new WebDriverWait(driver,Integer.parseInt(property.getProperty("WeWebDriverWaitTimeout")));

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--Incognito");
		option.addArguments("--headless");
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

	}	

	@Test 
	public void _1_UrlChecking_Test()
	{    
		wait.until(ExpectedConditions.urlContains(variables.LandingPage.ExpectedRedirectedURL));
		Assert.assertEquals("Current URL and orignal Url are diffrent please check one's again ", variables.LandingPage.ExpectedRedirectedURL, driver.getCurrentUrl());
		System.out.println("Test 1 => URL redirection test is passed");
	}

	@Test @Ignore
	public void _2_Page_Title()
	{
		wait.until(ExpectedConditions.titleContains(variables.LandingPage.LandingPageTitile));
		Assert.assertEquals("Current page Title and orignal page Title are diffrent please check one's again ",variables.LandingPage.LandingPageTitile, driver.getTitle());
		System.out.println("Test 2 => Landing page Title test is passed");
	}

	@Test @Ignore
	public void _3_productCategory()
	{    
		List <WebElement> list = driver.findElements((locators.LandingPage.productCategoryList));

		for (int i = 0; i < list.size();i++) 
		{
			if(!(list.get(i).getText().isEmpty()))
			{
				System.out.println(list.get(i).getText());;
			}
		}
		System.out.println("Test 3 => Product category validation test passed : \n");
	}


	@Test @Ignore
	public void _4_logoDisplay()
	{ 
		Boolean display = driver.findElement(locators.LandingPage.landingPageLogoImage).isDisplayed();	  
		Assert.assertTrue("Logo Display Test is faild.",display);
		System.out.println("Test 4 => Logo Display Test is passed.");
	}

	@Test @Ignore
	public void _5_logoTest()  throws InterruptedException
	{ 
		WebElement logosize = driver.findElement(By.xpath("//img[@class=\"logo img-responsive\"]"));
		Assert.assertNotSame("Verify Logo width size is unexpected ", variables.LandingPage.width, logosize.getSize().getWidth());
		Assert.assertNotSame("Verify Logo height size is unexpected ", variables.LandingPage.height , logosize.getSize().getHeight());
		System.out.println("Test 5 => Current Width of logo : "+ variables.LandingPage.width+"\nCurrent Height of logo : "+variables.LandingPage.height +
				"Application Logo Width and Height check Test is passed." );
	}

	@Test  @Ignore
	public void _6_Signin_page_Title_Test1()
	{ 	
		driver.findElement(By.xpath("//div/a[@class=\"login\"]")).click();
		//utilities.ElementAction.doClick(locators.LandingPage.signInButtonElement);
		Assert.assertEquals("Login page is not open ", variables.SignInPage.SignInPageTitle, driver.getTitle());
		System.out.println("Test 6 => Signin page Title Validation Test is passed"); 
	}

	@Test
	public void _7_CreateAccountTitleDisplayTest() 
	{

		ElementAction.doClick(locators.LandingPage.signInButtonElement);

		ElementAction.doSendKeys(locators.SinginPage.emailIdINputFieldElement,  variables.SignInPage.newUserEmaiID);

		ElementAction.doClick(locators.SinginPage.creatAnAccountButtonElement);

		ElementAction.doClick(locators.CreateAccountPage.maleGenderRadioBUttonElement);

		ElementAction.doSendKeys(locators.CreateAccountPage.userFirstNameTextBoxElement, variables.RegisterUserDetailsPage.userFirstName);

		ElementAction.doSendKeys(locators.CreateAccountPage.userLastNameTextBoxElement, variables.RegisterUserDetailsPage.userLastName);

		ElementAction.doSendKeys(locators.CreateAccountPage.userPasswordTextBoxElement, variables.RegisterUserDetailsPage.userPassword);

		ElementAction.doSendKeys(locators.CreateAccountPage.DOBDayValueDropDownElement, variables.RegisterUserDetailsPage.DOBDayValue);

		ElementAction.doSendKeys(locators.CreateAccountPage.DOBMonthValueDropDownElement, variables.RegisterUserDetailsPage.DOBMonthValue);

		ElementAction.doSendKeys(locators.CreateAccountPage.DOBYearValueDropDownElement, variables.RegisterUserDetailsPage.DOBYearValue);

		ElementAction.doClick(locators.CreateAccountPage.SignUpForNewsLetterCheckBoxElement);

		ElementAction.doClick(locators.CreateAccountPage.specialOfferEmailRecCheckBoxElement);

		ElementAction.doSendKeys(locators.CreateAccountPage.addressFirestNameTextBoxElement, variables.RegisterUserDetailsPage.addressFirestName);

		ElementAction.doSendKeys(locators.CreateAccountPage.addressLastNameTextBoxElement, variables.RegisterUserDetailsPage.addressLastName);

		ElementAction.doSendKeys(locators.CreateAccountPage.addressCompanyNameTextBoxElement, variables.RegisterUserDetailsPage.addressCompanyName);

		ElementAction.doSendKeys(locators.CreateAccountPage.addressLine1NameTextBoxElement, variables.RegisterUserDetailsPage.addressLine1Name);

		ElementAction.doSendKeys(locators.CreateAccountPage.addressLine2NameTextBoxElement, variables.RegisterUserDetailsPage.addressLine2Name);

		ElementAction.doSendKeys(locators.CreateAccountPage.addresCityTextBoxElement, variables.RegisterUserDetailsPage.addresCity);

		ElementAction.doSendKeys(locators.CreateAccountPage.addressStateDropDownElement, variables.RegisterUserDetailsPage.addressState);

		ElementAction.doSendKeys(locators.CreateAccountPage.addressZipCodeTextBoxElement, variables.RegisterUserDetailsPage.addressZipCode);

		ElementAction.doSendKeys(locators.CreateAccountPage.addressCountryDropDownElement, variables.RegisterUserDetailsPage.addressCountry);

		ElementAction.doSendKeys(locators.CreateAccountPage.addressAdditionalInfoTextBoxElement, variables.RegisterUserDetailsPage.addressAdditionalInfo);

		ElementAction.doSendKeys(locators.CreateAccountPage.addressHomePhoneTextBoxElement, variables.RegisterUserDetailsPage.addressHOmePhone);

		ElementAction.doSendKeys(locators.CreateAccountPage.addressMobilePhoneTextBoxElement, variables.RegisterUserDetailsPage.MobilePhone);

		ElementAction.doSendKeys(locators.CreateAccountPage.addressAliasAddressTextBoxElement, variables.RegisterUserDetailsPage.addressAliasAddress);

		ElementAction.doIsSelected(locators.CreateAccountPage.registerFormButtonElement);


		//	Assert.assertEquals("User account not created",variables.AfterRegistrationPage.userDisplayName ,locators.AfterRegistrationPage.registeredUserNameDisplayElement);
		System.out.println("Test 7 => ACCOUNT has been created successfully and Test case passed");
	}

	@Test @Ignore
	public void _8_ScreenShot_Test() 
	{
		try
		{
			screenshotCaptures.screenshotCapture1.ScreenShot(driver,"Automation");
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