package variables;

import utilities.RandomNumberGenrator;

public class RegisterUserDetailsPage {

	public static RandomNumberGenrator random = new RandomNumberGenrator();

	public static String createAnAccountExpectedText = "Create an account";
	public static String userFirstName = "Pravin" + random.generateSessionKey(4);
	public static String userLastName = "Kadam" + random.generateSessionKey(3);
	public static String userPassword = "123@Abc";
	public static String DOBDayValue = "10";
	public static String DOBMonthValue = "May ";
	public static String DOBYearValue = "1999";
	public static boolean IsSignUpForNewsLetter = true;
	public static String addressFirestName = userFirstName;
	public static String addressLastName = userLastName;
	public static String addressCompanyName = "Unicorn1 Systems";
	public static String addressLine1Name = "1999 Backer STreet , Po Box 26";
	public static String addressLine2Name = "Fountain garden";
	public static String addresCity = "Los Angeles";
	public static String addressState = "New York";
	public static String addressZipCode = "10026";
	public static String addressAdditionalInfo = "Please Send do the proceedings Asap";
	public static String addressHOmePhone = "+26262626262";
	public static String addressAliasAddress = "testDemo@gmail.com";
	public static String addressCountry = "United States";
	public static String MobilePhone = "+0266666666666";
	
}
