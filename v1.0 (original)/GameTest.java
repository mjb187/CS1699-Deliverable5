//package com.laboon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class GameTest {
	
	Game g;
	
	@Mock
	House mockHouse = mock(House.class);
	Player mockPlayer = mock(Player.class);
	
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(output));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(mockHouse);
		MockitoAnnotations.initMocks(mockPlayer);
	
	}

	@After
	public void tearDown() throws Exception {
	}

	//When doSomething() is called with an argument of "N" (case insensitive),
	//House should execute its moveNorth() method
	@Test
	public void testMoveNorth() {
		g = new Game(mockPlayer, mockHouse);
		g.doSomething("N");
		g.doSomething("n");
		verify(mockHouse, times(2)).moveNorth();
	}

	//When doSomething() is called with an argument of "S" (case insensitive),
	//House should execute its moveSouth() method
	@Test
	public void testMoveSouth(){
		g = new Game(mockPlayer, mockHouse);
		g.doSomething("S");
		g.doSomething("s");
		verify(mockHouse, times(2)).moveSouth();
	}
	
	//When doSomething() is called with an argument of "L" (case insensitive),
	//House should execute its look(player) method
	@Test
	public void testLook(){
		g = new Game(mockPlayer, mockHouse);
		g.doSomething("L");
		g.doSomething("l");
		verify(mockHouse, times(2)).look(mockPlayer);
	}
	
	//When doSomething() is called with an argument of "I" (case insensitive),
	//Player should execute its showInventory() method
	@Test
	public void testShowInventory(){
		g = new Game(mockPlayer, mockHouse);
		g.doSomething("I");
		g.doSomething("i");
		verify(mockPlayer, times(2)).showInventory();
	}
	
	//When doSomething() is called with an argument of "D" (case insensitive),
	//Player should execute its drink() method
	@Test
	public void testDrink(){
		g = new Game(mockPlayer, mockHouse);
		g.doSomething("D");
		g.doSomething("d");
		verify(mockPlayer, times(2)).drink();
	}
	
	//When doSomething() is called with an argument of "H" (case insensitive),
	//Player should execute its help method as defined in the requirements
	//commands should be recognized by the program
	@Test
	public void testHelp(){
		//flush stream
		output.toString();
		
		g = new Game(mockPlayer, mockHouse);
		
		g.doSomething("H");
		assertNotEquals("What?", output.toString().trim());
		
		g.doSomething("h");
		assertNotEquals("What?", output.toString().trim());
		
	}
	
	//When doSomething() is called with an invalid argument (www.random.org/strings),
	//No interaction with House or Player should occur
	@Test
	public void testdoSomething_badInput(){
		g = new Game(mockPlayer, mockHouse);
		g.doSomething("nBeNnYHyugFBSxpRyAz3");
		verifyZeroInteractions(mockPlayer);
		verifyZeroInteractions(mockHouse);
	}
	
	//When doSomething() is called with an empty input,
	//No interaction with House or Player should occur
	@Test
	public void testdoSomething_emptyString(){
		g = new Game(mockPlayer, mockHouse);
		g.doSomething("");
		verifyZeroInteractions(mockPlayer);
		verifyZeroInteractions(mockHouse);
	}
	
	//When doSomething() is called with a non-ascii argument,
	//No interaction with House or Player should occur
	@Test
	public void testDoSomething_nonASCII(){
		g = new Game(mockPlayer, mockHouse);
		g.doSomething("¥");
		verifyZeroInteractions(mockPlayer);
		verifyZeroInteractions(mockHouse);
	}

}
