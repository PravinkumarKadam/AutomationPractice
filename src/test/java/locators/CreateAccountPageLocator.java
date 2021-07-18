package locators;

import org.openqa.selenium.By;

public class CreateAccountPageLocator {
	//Locators - Create Account Page
	public  By CreateAnTestElement =  By.xpath("//div//form//h3[contains (text(),'Create an account')]");
	public  By maleGenderRadioBUttonElement = By.id("id_gender1");
	public  By userFirstNameTextBoxElement = By.id("customer_firstname");
	public  By userLastNameTextBoxElement = By.id("customer_lastname");
	public  By userPasswordTextBoxElement  = By.id("passwd");
	public  By DOBDayValueDropDownElement = By.id("days");
	public  By DOBMonthValueDropDownElement = By.id("months");
	public  By DOBYearValueDropDownElement =  By.id("years");
	public  By SignUpForNewsLetterCheckBoxElement = By.id("newsletter");
	public  By specialOfferEmailRecCheckBoxElement = By.id("optin");
	public  By addressFirestNameTextBoxElement= By.id("firstname");
	public  By addressLastNameTextBoxElement = By.id("lastname");
	public  By addressCompanyNameTextBoxElement = By.id("company");
	public  By addressLine1NameTextBoxElement = By.id("address1");
	public  By addressLine2NameTextBoxElement= By.id("address2");
	public  By addresCityTextBoxElement = By.id("city");
	public  By addressStateDropDownElement = By.id("id_state");
	public  By addressZipCodeTextBoxElement = By.id("postcode");
	public  By addressCountryDropDownElement =	By.id("id_country");
	public  By addressAdditionalInfoTextBoxElement = By.id("other");
	public  By addressHomePhoneTextBoxElement =  By.id("phone");
	public  By addressMobilePhoneTextBoxElement = By.id("phone_mobile");
	public  By addressAliasAddressTextBoxElement=  By.id("alias");
	public  By registerFormButtonElement = By.id("submitAccount");
}
