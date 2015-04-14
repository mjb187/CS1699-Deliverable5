//Code written by Mike Byrne
//	mjb187@pitt.edu

//based on tests from Deliverable 2

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest 
{
	
	//test flags get set properly for getSugar() method
	@Test
	public void testGetSugar() 
	{
		Player p = new Player();
		
		assertTrue(p.getSugar());
	}
	
	/*-------------------------------------------------*/
	
	//test flags get set properly for getCream() method
	@Test
	public void testGetCream() 
	{
		Player p = new Player();
		
		assertTrue(p.getCream());
	}
		
	/*-------------------------------------------------*/
		
	//test flags get set properly for getCoffee() method
	@Test
	public void testGetCoffee()
	{
		Player p = new Player();
		
		assertTrue(p.getCoffee());
	}
	
	/*-------------------------------------------------*/
	
	//test that hasAllItems() method evaluates properly for no items
	//assumes that the getX() methods are working properly
	@Test
	public void testHasAllItems_noItems()
	{
		Player p = new Player();
		
		assertFalse("Player has no items", p.hasAllItems());
	}
	
	/*-------------------------------------------------*/
	
	//test that hasAllItems() method evaluates properly for one items
	//assumes that the getX() methods are working properly
	@Test
	public void testHasAllItems_oneItems()
	{
		Player p = new Player();
		
		p.getSugar();
		assertFalse("Player only has sugar", p.hasAllItems());
	}
	
	/*-------------------------------------------------*/
	
	//test that hasAllItems() method evaluates properly for two items
	//assumes that the getX() methods are working properly
	@Test
	public void testHasAllItems_twoItems()
	{
		Player p = new Player();
		
		p.getSugar();
		p.getCream();
		assertFalse("Player only has sugar and cream", p.hasAllItems());
	}
	
	/*-------------------------------------------------*/
	
	//test that hasAllItems() method evaluates properly for all items
	//assumes that the getX() methods are working properly
	@Test
	public void testHasAllItems_allItems()
	{
		Player p = new Player();
		
		p.getSugar();
		p.getCream();
		p.getCoffee();
		assertTrue("Player has all items", p.hasAllItems());
	}
	
	/*-------------------------------------------------*/
	
	//test that showInventory() method evaluates properly for no items
	//assumes that the getX() methods are working properly
	@Test
	public void testShowInventory_noItems()
	{
		Player p = new Player();
		
		assertTrue("Player has no items", p.showInventory() == 000);
	}
	
	/*-------------------------------------------------*/
	
	//test that showInventory() method evaluates properly for one items
	//assumes that the getX() methods are working properly
	@Test
	public void testShowInventory_oneItems()
	{
		Player p = new Player();
		
		p.getSugar();
		assertTrue("Player only has sugar", p.showInventory() == 1);
	}
	
	/*-------------------------------------------------*/
	
	//test that showInventory() method evaluates properly for two items
	//assumes that the getX() methods are working properly
	@Test
	public void testShowInventory_twoItems()
	{
		Player p = new Player();
		
		p.getSugar();
		p.getCream();
		assertTrue("Player only has sugar and cream", p.showInventory() == 11);
	}
	
	/*-------------------------------------------------*/
	
	//test that showInventory() method evaluates properly for all items
	//assumes that the getX() methods are working properly
	@Test
	public void testShowInventory_allItems()
	{
		Player p = new Player();
		
		p.getSugar();
		p.getCream();
		p.getCoffee();
		assertTrue("Player has all items", p.showInventory() == 111);
	}
	
	/*-------------------------------------------------*/
	
	//test that showDrink() method evaluates properly for no items
	//assumes that the getX() methods are working properly
	@Test
	public void testDrink_noItems()
	{
		Player p = new Player();
		
		assertTrue("Player has no items", p.drink() == 000);
	}
	
	/*-------------------------------------------------*/
	
	//test that showDrink() method evaluates properly for one items
	//assumes that the getX() methods are working properly
	@Test
	public void testDrink_oneItems()
	{
		Player p = new Player();
		
		p.getSugar();
		assertTrue("Player only has sugar", p.drink() == 1);
	}
	
	/*-------------------------------------------------*/
	
	//test that showDrink() method evaluates properly for two items
	//assumes that the getX() methods are working properly
	@Test
	public void testDrink_twoItems()
	{
		Player p = new Player();

		p.getSugar();
		p.getCream();
		assertTrue("Player only has sugar and cream", p.drink() == 11);
	}
	
	/*-------------------------------------------------*/
	
	//test that showDrink() method evaluates properly for all items
	//assumes that the getX() methods are working properly
	@Test
	public void testDrink_allItems()
	{
		Player p = new Player();
		
		p.getSugar();
		p.getCream();
		p.getCoffee();
		assertTrue("Player has all items", p.drink() == 111);
	}
}
