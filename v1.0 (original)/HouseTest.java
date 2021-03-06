//package com.laboon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class HouseTest {
	
	House h = new House(6);
	int numrooms = 6;
	
	@Mock
	House mockHouse = mock(House.class);
	Room mockRoom = mock(Room.class);
	Player mockPlayer = mock(Player.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//setup code
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//setup code
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(mockHouse);
		MockitoAnnotations.initMocks(mockRoom);
		MockitoAnnotations.initMocks(mockPlayer);
	}

	@After
	public void tearDown() throws Exception {
		//setup code
	}
	
	//Test to verify that generateRooms(int rooms) method returns the correct size array
	//Passing the method a 6 should generate an array of length 6
	//The number 6 was chosen because it is hard-coded into the House class and is not subject to change
	@Test
	public void testGenerateRooms_arrayLength(){
		Room[] rooms = h.generateRooms(numrooms);
		assertEquals(numrooms, rooms.length);
	}
	
	//Test to verify that a room has coffee. Player class
	//will call the getCoffee() method. To create this test, the hard-coded value
	//of the number of rooms and knowledge of the generateRooms method were used to 
	//determine which room the coffee would be located in; that is how the room from
	//the array of Rooms was selected.
	@Test
	public void testLook_coffee(){
		
		//moveNorth increments House's private variable _currentRoom.
		//This variable is used in the look() method and serves as the index of the
		//array of Rooms generated by generateRooms that represents the room the Player is in.
		//Calling this method emulates player movement.
		h.moveNorth();
		h.moveNorth();
		
		h.look(mockPlayer);
		verify(mockPlayer).getCoffee();		
	}
	
	//Test to verify that a room has sugar. Player class
	//will call the getSugar() method. To create this test, the hard-coded value
	//of the number of rooms and knowledge of the generateRooms method were used to 
	//determine which room the sugar would be located in; that is how the room from
	//the array of Rooms was selected.
	@Test
	public void testLook_sugar(){
		
		//moveNorth increments House's private variable _currentRoom.
		//This variable is used in the look() method and serves as the index of the
		//array of Rooms generated by generateRooms that represents the room the Player is in.
		//Calling this method emulates player movement.
		h.moveNorth();
		h.moveNorth();
		h.moveNorth();
		h.moveNorth();
		h.moveNorth();
		
		h.look(mockPlayer);
		verify(mockPlayer).getSugar();		
	}
	
	//Test to verify that a room has cream. Player class
	//will call the getCream() method. To create this test, the hard-coded value
	//of the number of rooms and knowledge of the generateRooms method were used to 
	//determine which room the cream would be located in; that is how the room from
	//the array of Rooms was selected.
	@Test
	public void testLook_cream(){
		h.look(mockPlayer);
		verify(mockPlayer).getCream();		
	}
	
	//Test to verify that two rooms don't have the same description,
	//as per the game's requirements.
	@Test
	public void testDescriptionUniqueness(){
		Room[] rooms = h.generateRooms(numrooms);
		int j=1;
		for(int i=0; i<numrooms-1; i++){
			for(; j<numrooms-1; j++){
				assertNotEquals(rooms[i].getDescription(), rooms[j].getDescription());
			}
			j+=1;
		}
	}
	
	//Test to verify that a room description is not null.
	@Test
	public void testDescription_null(){
		Room[] rooms = h.generateRooms(numrooms);
		
		for(int i=0; i<numrooms; i++){
			assertNotNull(rooms[i].getDescription());
		}
	}

}
