package variables;

import utilities.RandomNumberGenrator;

public class RegisterUserDetailsPagevariables {

	public  RandomNumberGenrator random = new RandomNumberGenrator();

	public  String createAnAccountExpectedText = "Create an account";
	public  String userFirstName = "Pravin" + random.generateSessionKey(4);
	public  String userLastName = "Kadam" + random.generateSessionKey(3);
	public  String userPassword = "123@Abc";
	public  String DOBDayValue = "10";
	public  String DOBMonthValue = "May ";
	public  String DOBYearValue = "1999";
	public  boolean IsSignUpForNewsLetter = true;
	public  String addressFirestName = userFirstName;
	public  String addressLastName = userLastName;
	public  String addressCompanyName = "Unicorn1 Systems";
	public  String addressLine1Name = "1999 Backer STreet , Po Box 26";
	public  String addressLine2Name = "Fountain garden";
	public  String addresCity = "Los Angeles";
	public  String addressState = "New York";
	public  String addressZipCode = "10026";
	public  String addressAdditionalInfo = "Please Send do the proceedings Asap";
	public  String addressHOmePhone = "+26262626262";
	public  String addressAliasAddress = "testDemo@gmail.com";
	public  String addressCountry = "United States";
	public  String MobilePhone = "+0266666666666";
	
}
