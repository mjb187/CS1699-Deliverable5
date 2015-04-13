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
	private int numrooms = 6;
	
	//test that generateRooms(int rooms) method returns the correct size array
	//the number 6 was chosen because it is hard-coded into the House class and is not subject to change
	@Test
	public void testGenerateRooms_arrayLength()
	{
		House h = new House(0);
		Room[] rooms = h.generateRooms(numrooms);
		
		assertEquals(numrooms, rooms.length);
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
	public void testGenerateRooms_startRoomNorthExit()
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
	
}