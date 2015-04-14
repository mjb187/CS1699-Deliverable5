//Code written by Mike Byrne
//	mjb187@pitt.edu

//based on tests from Deliverable 2

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.*;

public class HouseTest 
{
	@Mock
	Player mockPlayer = Mockito.mock(Player.class);

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(mockPlayer);
	}
	
	private int numrooms = 6;
	
	//test that getHouseInfo() returns the proper values
	@Test
	public void testGetHouseInfo()
	{
		House h = new House(numrooms);

		assertEquals(numrooms, h.getHouseInfo());
	}
	
	/*-------------------------------------------------*/
	
	//test that generateRooms(int rooms) method returns the correct size array
	//the number 6 was chosen because it is the program's default value
	@Test
	public void testGenerateRooms_arrayLength()
	{
		House h = new House(0);
		Room[] rooms = h.generateRooms(numrooms);
		
		assertEquals(numrooms, rooms.length);
	}
	
	/*-------------------------------------------------*/
	
	//test that generateRooms(int rooms) method properly handles being passed argument zero
	//program should default to using the value 6
	//assumes getHouseInfo() method is working properly
	@Test
	public void testConstructor_zero()
	{
		House h = new House(0);
		
		assertEquals(6, h.getHouseInfo());
	}
	
	/*-------------------------------------------------*/
	
	//test that generateRooms(int rooms) method properly handles being passed a negative argument
	//program should default to using the value 6
	//assumes getHouseInfo() method is working properly
	@Test
	public void testConstructor_negative()
	{
		House h = new House(-10);
		
		assertEquals(6, h.getHouseInfo());
	}
	
	/*-------------------------------------------------*/
	
	//test that generateRooms(int rooms) method properly handles being passed a large integer (max_value causes OutOfMemory Exception)
	//assumes getHouseInfo() method is working properly
	@Test
	public void testConstructor_largeValue()
	{
		House h = new House(10000);
		
		assertEquals(10000, h.getHouseInfo());
	}
	
	/*-------------------------------------------------*/
	
	//test that start room has no South exit
	//assumes Room.southExit() method is working properly
	@Test
	public void testGenerateRooms_startRoomSouthExit()
	{
		House h = new House(0);
		Room[] rooms = h.generateRooms(numrooms);
		
		assertFalse(rooms[0].southExit());
	}
	
	/*-------------------------------------------------*/
	
	//test that end room has no North exit
	//assumes Room.southExit() method is working properly
	@Test
	public void testGenerateRooms_endRoomNorthExit()
	{
		House h = new House(0);
		Room[] rooms = h.generateRooms(numrooms);
		
		assertFalse(rooms[numrooms-1].northExit());
	}
	
	/*-------------------------------------------------*/
	
	//test that the getCurrentRoom() method returns the proper value
	@Test
	public void testGetCurrentRoom_initial() 
	{
		House h = new House(numrooms);
		
		assertTrue(h.getCurrentRoom() == 0);
	}
	
	/*-------------------------------------------------*/
	
	//test that the moveNorth() method returns the proper value
	//assumes getCurrentRoom() method is working properly
	@Test
	public void testMoveNorth_baseCase() 
	{
		House h = new House(numrooms);
		int before, after;
		
		before = h.getCurrentRoom();
		after = h.moveNorth();
		
		assertTrue("before and after are different", before != after);
		assertTrue("before and after are off by one", before+1 == after);
	}
	
	/*-------------------------------------------------*/
	
	//test that the moveNorth() method returns the proper value for the room without a door
	//assumes getCurrentRoom() method is working properly
	@Test
	public void testMoveNorth_edgeCaseEndRoom() 
	{
		House h = new House(numrooms);
		int before, after;
		
		//move into room[5]
		for(int i = 0; i < numrooms-1; i++)
		{
			h.moveNorth();
		}
		
		before = h.getCurrentRoom();
		after = h.moveNorth();
		
		assertTrue(before == after);
	}
	
	/*-------------------------------------------------*/
	
	//test that the moveNorth() method returns the proper value
	//assumes getCurrentRoom() method is working properly
	@Test
	public void testMoveSouth_baseCase() 
	{
		House h = new House(numrooms);
		int before, after;
		
		//move off starting room (cannot move south from here, theoretically)
		h.moveNorth();
		
		before = h.getCurrentRoom();
		after = h.moveSouth();
		
		assertTrue("before and after are different", before != after);
		assertTrue("before and after are off by one", before-1 == after);
	}
	
	/*-------------------------------------------------*/
	
	//test that the moveNorth() method returns the proper value for the room without a door
	//assumes getCurrentRoom() method is working properly
	@Test
	public void testMoveSouth_edgeCaseStartRoom() 
	{
		House h = new House(numrooms);
		int before, after;
		
		before = h.getCurrentRoom();
		after = h.moveSouth();
		
		assertTrue(before == after);
	}
	
	/*-------------------------------------------------*/
	
	//test that the movement methods work properly for a single room house
	//assumes getCurrentRoom() method is working properly
	@Test
	public void testMovement_singleRoom() 
	{
		House h = new House(1);
		int before, north, south;
		
		before = h.getCurrentRoom();
		north = h.moveNorth();
		south = h.moveSouth();
		
		assertTrue("before and north are equal", before == north);
		assertTrue("before and south are equal", before == south);
	}
	
	/*-------------------------------------------------*/
	
	//test that no two rooms have the same description
	//assumes generateRooms() method is working properly
	//assumes Room.getDescription() method is working properly
	@Test
	public void testDescriptionUniqueness(){
		House h = new House(0);
		Room[] rooms = h.generateRooms(numrooms);

		for(int i=0; i<numrooms-1; i++){
			for(int j=i+1; j<numrooms-1; j++){
				assertNotEquals(rooms[i].getDescription(), rooms[j].getDescription());
			}
		}
	}
	
	/*-------------------------------------------------*/
	
	//test that no room description is null.
	//assumes generateRooms() method is working properly
	//assumes Room.getDescription() method is working properly
	@Test
	public void testDescription_null(){
		House h = new House(0);
		Room[] rooms = h.generateRooms(numrooms);
		
		for(int i=0; i<numrooms; i++){
			assertNotNull(rooms[i].getDescription());
		}
	}
	
	/*-------------------------------------------------*/
	
	//verify that the cream item is obtained in room[0]
	@Test
	public void testLook_cream()
	{
		House h = new House(numrooms);
	
		h.look(mockPlayer);
		
		Mockito.verify(mockPlayer).getCream();	
		assertTrue(0 == h.getCurrentRoom());
	}
	
	/*-------------------------------------------------*/
	
	//verify that the coffee item is obtained in room[2]
	//assumes moveNorth() method is working properly (needed to navigate player to that room)
	@Test
	public void testLook_coffee()
	{
		House h = new House(numrooms);
		
		h.moveNorth();
		h.moveNorth();
		h.look(mockPlayer);
		
		Mockito.verify(mockPlayer).getCoffee();	
		assertTrue(2 == h.getCurrentRoom());
	}
	
	/*-------------------------------------------------*/
	
	//verify that the coffee item is obtained in room[numrooms-1]
	//assumes moveNorth() method is working properly (needed to navigate player to that room)
	@Test
	public void testLook_sugar()
	{
		House h = new House(numrooms);
		
		h.moveNorth();
		h.moveNorth();
		h.moveNorth();
		h.moveNorth();
		h.moveNorth();
		h.look(mockPlayer);
		
		Mockito.verify(mockPlayer).getSugar();	
		assertTrue(numrooms-1 == h.getCurrentRoom());
	}
	
	/*-------------------------------------------------*/
	
	//verify that no item is obtained in room[1]
	//assumes moveNorth() method is working properly (needed to navigate player to that room)
	@Test
	public void testLook_noItems()
	{
		House h = new House(numrooms);
		
		h.moveNorth();

		h.look(mockPlayer);
		
		Mockito.verify(mockPlayer, Mockito.never()).getCream();	
		Mockito.verify(mockPlayer, Mockito.never()).getCoffee();	
		Mockito.verify(mockPlayer, Mockito.never()).getSugar();	
		assertTrue(1 == h.getCurrentRoom());
	}
	
}