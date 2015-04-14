//package com.laboon;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {

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
		//setup code
	}

	@After
	public void tearDown() throws Exception {
		//setup code
	}
	
	//Test for the hasAllItems() method
	//The method should return false because the player has no items
	@Test
	public void testHasAllItems_noItems() {
		Player p = new Player();
		
		assertFalse("Player has no items", p.hasAllItems());
		
		p.getSugar();
		assertFalse("Player only has sugar", p.hasAllItems());
		
		p.getCream();
		assertFalse("Player only has sugar and cream", p.hasAllItems());
		
		p.getCoffee();
		assertTrue("Player has all items", p.hasAllItems());
		
	}
	
	//Test for the hasAllItems() method
	//The method should return false because the player has one item
	@Test
	public void testHasAllItems_oneItem() {
		Player p = new Player();
		
		p.getSugar();
		
		assertFalse("Player has one item", p.hasAllItems());
		
	}
	
	//Test for the hasAllItems() method
	//The method should return false because the player has two items
	@Test
	public void testHasAllItems_twoItems() {
		Player p = new Player();
		
		p.getSugar();
		
		p.getCream();
		
		assertFalse("Player has two items", p.hasAllItems());
		
	}
	
	//Test for the hasAllItems() method
	//The method should return true because the player has all items
	@Test
	public void testHasAllItems_threeItems() {
		Player p = new Player();
		
		p.getSugar();
		
		p.getCream();
		
		p.getCoffee();
		
		assertTrue("Player has all items", p.hasAllItems());
		
	}
	
	//Test for the drink() method
	//Should return TRUE after getSugar(), getCream(), and getCoffee() methods have run and drink() is called
	@Test
	public void testDrink(){
		Player p = new Player();
		
		assertFalse("Player has no items at all, and should lose", p.drink());
		
		p.getSugar();
		assertFalse("Player has one item, and should lose", p.drink());
		
		p.getCream();
		assertFalse("Player has two items, and should lose", p.drink());
		
		p.getCoffee();
		assertTrue("Player has all three items, and should win", p.drink());
	}

}
