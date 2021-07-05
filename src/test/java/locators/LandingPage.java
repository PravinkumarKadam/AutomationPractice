package locators;

import org.openqa.selenium.By;

public class LandingPage {
	
	public static By signInButtonElement = By.xpath("//div/a[@class=\"login\"]");
	public static By productCategoryList = By.xpath("//ul[@class=\"sf-menu clearfix menu-content sf-js-enabled sf-arrows\"]//li/a");
	public static By productCategoryList22222 = By.xpath("//ul[@class=\"sf-menu clearfix menu-content sf-js-enabled sf-arrows\"]/li");
	public static By landingPageLogoImage =By.xpath("//div//a//img[@class=\"logo img-responsive\"]");
	public static By titleOfHomePage = By.xpath("//title[contains(text(),'My Store')]");
}