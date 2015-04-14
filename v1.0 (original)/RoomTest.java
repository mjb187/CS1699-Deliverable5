//Code written by Mike Byrne
//	mjb187@pitt.edu

//Not tested:
//	private String getAdjective()
//	private String getNoun()
//	private String generateDescription()

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RoomTest 
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

	//check that a room with all three items in it will be properly verified
	@Test
	public void testHasItem_allTrue() 
	{
		Room testRoom = new Room(true, true, true, false, false);
		boolean result = testRoom.hasItem();
		
		assertTrue(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a room with two items in it will be properly verified
	@Test
	public void testHasItem_twoTrue() 
	{
		Room testRoom = new Room(true, true, false, false, false);
		boolean result = testRoom.hasItem();
		
		assertTrue(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a room with only one item in it will be properly verified
	@Test
	public void testHasItem_oneTrue() 
	{
		Room testRoom = new Room(true, false, false, false, false);
		boolean result = testRoom.hasItem();
		
		assertTrue(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a room with no items in it will be properly verified
	@Test
	public void testHasItem_allFalse() 
	{
		Room testRoom = new Room(false, false, false, false, false);
		boolean result = testRoom.hasItem();
		
		assertFalse(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a room with sugar is properly validated
	@Test
	public void testHasSugar_true() 
	{
		Room testRoom = new Room(false, false, true, false, false);
		boolean result = testRoom.hasSugar();
		
		assertTrue(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a room without sugar is properly validated
	@Test
	public void testHasSugar_false() 
	{
		Room testRoom = new Room(false, false, false, false, false);
		boolean result = testRoom.hasSugar();
		
		assertFalse(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a room with cream is properly validated
	@Test
	public void testHasCream_true() 
	{
		Room testRoom = new Room(false, true, false, false, false);
		boolean result = testRoom.hasCream();
		
		assertTrue(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a room without cream is properly validated
	@Test
	public void testHasCream_false() 
	{
		Room testRoom = new Room(false, false, false, false, false);
		boolean result = testRoom.hasCream();
		
		assertFalse(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a room with coffee is properly validated
	@Test
	public void testHasCoffee_true() 
	{
		Room testRoom = new Room(true, false, false, false, false);
		boolean result = testRoom.hasCoffee();
		
		assertTrue(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a room without coffee is properly validated
	@Test
	public void testHasCoffee_false() 
	{
		Room testRoom = new Room(false, false, false, false, false);
		boolean result = testRoom.hasCoffee();
		
		assertFalse(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a room with a north exit is properly validated
	@Test
	public void testNorthExit_true() 
	{
		Room testRoom = new Room(false, false, false, true, false);
		boolean result = testRoom.northExit();
		
		assertTrue(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a room without a north exit is properly validated
	@Test
	public void testNorthExit_false() 
	{
		Room testRoom = new Room(false, false, false, false, false);
		boolean result = testRoom.northExit();
		
		assertFalse(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a room with both exits is properly validated
	@Test
	public void testNorthExit_both() 
	{
		Room testRoom = new Room(false, false, false, true, true);
		boolean result = testRoom.northExit();
		
		assertTrue(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a room with a south exit is properly validated
	@Test
	public void testSouthExit_true() 
	{
		Room testRoom = new Room(false, false, false, false, true);
		boolean result = testRoom.southExit();
		
		assertTrue(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a room without a south exit is properly validated
	@Test
	public void testSouthExit_false() 
	{
		Room testRoom = new Room(false, false, false, false, false);
		boolean result = testRoom.southExit();
		
		assertFalse(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a room with both exits is properly validated
	@Test
	public void testSouthExit_both() 
	{
		Room testRoom = new Room(false, false, false, true, true);
		boolean result = testRoom.southExit();
		
		assertTrue(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that a Room is given a description
	@Test
	public void testGetDescription_notNull() 
	{
		Room testRoom = new Room(false, false, false, false, false);
		String result = testRoom.getDescription();
		
		assertNotNull(result);
	}
	
	/*-------------------------------------------------*/
	
	//check that two different rooms with the same features are given different descriptions
	@Test
	public void testGetDescription_twoSimilarRooms() 
	{
		Room testRoom1 = new Room(false, true, false, false, true);
		String result1 = testRoom1.getDescription();
		
		Room testRoom2 = new Room(false, true, false, false, true);
		String result2 = testRoom2.getDescription();
		
		assertNotEquals(result1, result2);
	}
	
	/*-------------------------------------------------*/
	
	//check that two different rooms with different features are given different descriptions
	@Test
	public void testGetDescription_twoDifferentRooms() 
	{
		Room testRoom1 = new Room(false, false, false, false, false);
		String result1 = testRoom1.getDescription();
		
		Room testRoom2 = new Room(true, true, true, true, true);
		String result2 = testRoom2.getDescription();
		
		assertNotEquals(result1, result2);
	}
	
	/*-------------------------------------------------*/
	
	//check that two Rooms have different descriptions even after all the adjectives and nouns have been exhausted
	@Test
	public void testGetDescription_samePseudorandomValue() 
	{
		Room testRoom1 = new Room(false, false, false, false, false);
		String result1 = testRoom1.getDescription();
		
		Room testRoom2 = null;
		for(int i = 0; i < 324; i++)
			testRoom2 = new Room(false, false, false, false, false);
		String result2 = testRoom2.getDescription();
		
		assertNotEquals(result1, result2);
	}
	
	/*-------------------------------------------------*/
	
	//test that incrementing the internal pseudorandom pointer to an absurd amount doesn't create any issues
	@Test
	public void testGetDescription_largeIncrement() 
	{
		Room testRoom = null;
		for(int i = 0; i < Integer.MAX_VALUE + 1; i++)
			testRoom = new Room(false, false, false, false, false);
		assertNotNull(testRoom);
		
		String result = testRoom.getDescription();
		assertNotNull(result);
	}

}
