package locators;

import org.openqa.selenium.By;

public class LandingPageLocator {
	
	public  By signInButtonElement = By.xpath("//div/a[@class=\"login\"]");
	public  By productCategoryList = By.xpath("//ul[@class=\"sf-menu clearfix menu-content sf-js-enabled sf-arrows\"]//li/a");
	public  By productCategoryList22222 = By.xpath("//ul[@class=\"sf-menu clearfix menu-content sf-js-enabled sf-arrows\"]/li");
	public  By landingPageLogoImage =By.xpath("//div//a//img[@class=\"logo img-responsive\"]");
	public  By titleOfHomePage = By.xpath("//title[contains(text(),'My Store')]");
}