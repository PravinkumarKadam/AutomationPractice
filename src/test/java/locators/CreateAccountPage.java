package locators;

import org.openqa.selenium.By;

public class CreateAccountPage {
	//Locators - Create Account Page
	public static By CreateAnTestElement =  By.xpath("//div//form//h3[contains (text(),'Create an account')]");
	public static By maleGenderRadioBUttonElement = By.id("id_gender1");
	public static By userFirstNameTextBoxElement = By.id("customer_firstname");
	public static By userLastNameTextBoxElement = By.id("customer_lastname");
	public static By userPasswordTextBoxElement  = By.id("passwd");
	public static By DOBDayValueDropDownElement = By.id("days");
	public static By DOBMonthValueDropDownElement = By.id("months");
	public static By DOBYearValueDropDownElement =  By.id("years");
	public static By SignUpForNewsLetterCheckBoxElement = By.id("newsletter");
	public static By specialOfferEmailRecCheckBoxElement = By.id("optin");
	public static By addressFirestNameTextBoxElement= By.id("firstname");
	public static By addressLastNameTextBoxElement = By.id("lastname");
	public static By addressCompanyNameTextBoxElement = By.id("company");
	public static By addressLine1NameTextBoxElement = By.id("address1");
	public static By addressLine2NameTextBoxElement= By.id("address2");
	public static By addresCityTextBoxElement = By.id("city");
	public static By addressStateDropDownElement = By.id("id_state");
	public static By addressZipCodeTextBoxElement = By.id("postcode");
	public static By addressCountryDropDownElement =	By.id("id_country");
	public static By addressAdditionalInfoTextBoxElement = By.id("other");
	public static By addressHomePhoneTextBoxElement =  By.id("phone");
	public static By addressMobilePhoneTextBoxElement = By.id("phone_mobile");
	public static By addressAliasAddressTextBoxElement=  By.id("alias");
	public static By registerFormButtonElement = By.id("submitAccount");
}
