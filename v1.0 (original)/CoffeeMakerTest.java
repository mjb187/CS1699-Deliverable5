//Code written by Mike Byrne
//	mjb187@pitt.edu

//Not tested:
//	private int runGameLoop(Player p, House h, Game g)
//	public static void main(String[] args)

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class CoffeeMakerTest 
{
	
	@Before
	public void setUp() throws Exception 
	{
		//setup code
	}
	
	/*-------------------------------------------------*/

	@After
	public void tearDown() throws Exception 
	{
		//teardown code
	}
	
	/*-------------------------------------------------*/
	
	//test that the program will run with no arguments
	@Test
	public void testRunArgs_emptyString() 
	{
		CoffeeMaker test = new CoffeeMaker();
		int result = test.runArgs("");
		
		assertEquals(result, 0);
	}
	
	/*-------------------------------------------------*/
	
	//test that the function will accept the null character as an argument
	@Test
	public void testRunArgs_nullCharacter() 
	{
		CoffeeMaker test = new CoffeeMaker();
		int result = test.runArgs("\0");
		
		assertEquals(result, 0);
	}
	
	/*-------------------------------------------------*/
	
	//test that the function will accept a short string of english words
	@Test
	public void testRunArgs_reasonableString() 
	{
		CoffeeMaker test = new CoffeeMaker();
		int result = test.runArgs("Hello world");
		
		assertEquals(result, 0);
	}
	
	/*-------------------------------------------------*/
	
	//test that the function will accept a long string of jibberish (https://www.random.org/strings/)
	@Test
	public void testRunArgs_unreasonableString() 
	{
		CoffeeMaker test = new CoffeeMaker();
		int result = test.runArgs("mliy31lSSNkvsUVMqIy1fXWXPwjpUUHK8JB5zXbQoUp3IW95lg81wYll2CM3ZQK3SQ71I4HJonZ6Brax1aHC0H2FK1vjQbmhJcea4TluYIGsnKYFIUwepMr3xSU66LZx3W0836VBVUQgYCN5O4m04zpJdJKpNR5xYGacvSl7SjJfV9eip9M134aJk5QYaVDtU9k2gvbJ");
		
		assertEquals(result, 0);
	}
	
	/*-------------------------------------------------*/
	
	//test that the function will accept a string of special characters
	@Test
	public void testRunArgs_specialChars() 
	{
		CoffeeMaker test = new CoffeeMaker();
		int result = test.runArgs("!@#$%^&*()_+-={}[]|\\/?<>,.:;\"\'~`\"");
		
		assertEquals(result, 0);
	}
}
