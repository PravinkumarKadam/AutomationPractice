package utilities;

import java.util.Random;

public class RandomNumberGenrator {

	public int randomNumberGengerator_000()
	{
		Random rand = new Random();
		int random_interger = rand.nextInt(9999);
			return random_interger;				
	}

  public int randomNumberGengerator_0()
  {
	  Random rand = new Random();
	  int random_interger = rand.nextInt(9);
		return random_interger;	
  }
	public String randomStringGenerator()
	{ 
		Random rand = new Random();
		String randomName = "" ; 
		
		for (int i = 0; i<10 ; i++)
		{
			char characterRandom = (char)(rand.nextInt());
			if(rand.nextBoolean()) 
			{
				characterRandom = Character.toUpperCase(characterRandom);
			randomName = randomName + characterRandom ;
			}
		}
	return randomName;
	}

//----------------------------------------------------------------------------------------------	

	public static String generateSessionKey(int length){

	    String result = new String();
	    Random r = new Random(); 

		String alphabet = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"); // 9

	    int n = alphabet.length();

	    for (int i=0; i<length; i++)
	        result = result + alphabet.charAt(r.nextInt(n));

	    return result;
	}
	
	
}
