//Code written by Mike Byrne
//	mjb187@pitt.edu

//Not tested:
//	public void helpMenu()

//based on tests from Deliverable 2

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class GameTest 
{
	@Mock
	Player mockPlayer = Mockito.mock(Player.class);
	House mockHouse = Mockito.mock(House.class);

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(mockPlayer);
		MockitoAnnotations.initMocks(mockHouse);
	}
	
	//test that doSomething() recognizes 'N' input and returns correct value
	@Test
	public void testDoSomething_north()
	{
		Game g = new Game(mockPlayer, mockHouse);
		
		int r1 = g.doSomething("N");
		int r2 = g.doSomething("n");
		
		Mockito.verify(mockHouse, Mockito.times(2)).moveNorth();
		assertTrue("uppercase", r1 == 0);
		assertTrue("lowercase", r2 == 0);
	}
	
	/*-------------------------------------------------*/
	
	//test that doSomething() recognizes 'S' input and returns correct value
	@Test
	public void testDoSomething_south()
	{
		Game g = new Game(mockPlayer, mockHouse);
		
		int r1 = g.doSomething("S");
		int r2 = g.doSomething("s");
		
		Mockito.verify(mockHouse, Mockito.times(2)).moveSouth();
		assertTrue("uppercase", r1 == 0);
		assertTrue("lowercase", r2 == 0);
	}
	
	/*-------------------------------------------------*/
	
	//test that doSomething() recognizes 'L' input and returns correct value
	@Test
	public void testDoSomething_look()
	{
		Game g = new Game(mockPlayer, mockHouse);
		
		int r1 = g.doSomething("L");
		int r2 = g.doSomething("l");
		
		Mockito.verify(mockHouse, Mockito.times(2)).look(mockPlayer);
		assertTrue("uppercase", r1 == 0);
		assertTrue("lowercase", r2 == 0);
	}
	
	/*-------------------------------------------------*/
	
	//test that doSomething() recognizes 'I' input and returns correct value
	@Test
	public void testDoSomething_inventory()
	{
		Game g = new Game(mockPlayer, mockHouse);
		
		int r1 = g.doSomething("I");
		int r2 = g.doSomething("i");
		
		Mockito.verify(mockPlayer, Mockito.times(2)).showInventory();
		assertTrue("uppercase", r1 == 0);
		assertTrue("lowercase", r2 == 0);
	}
	
	/*-------------------------------------------------*/
	
	//test that doSomething() recognizes 'H' input and returns correct value
	@Test
	public void testDoSomething_help()
	{
		Game g = Mockito.spy(new Game(mockPlayer, mockHouse));
		
		int r1 = g.doSomething("H");
		int r2 = g.doSomething("h");
		
		Mockito.verify(g, Mockito.times(2)).helpMenu();
		assertTrue("uppercase", r1 == 0);
		assertTrue("lowercase", r2 == 0);
	}
	
	/*-------------------------------------------------*/
	
	//test that doSomething() recognizes 'D' input and returns correct value (-1 because the mock does not meet win conditions)
	@Test
	public void testDoSomething_drinkFail()
	{
		Game g = new Game(mockPlayer, mockHouse);
		
		int r1 = g.doSomething("D");
		int r2 = g.doSomething("d");
		
		Mockito.verify(mockPlayer, Mockito.times(2)).drink();
		assertTrue("uppercase", r1 == -1);
		assertTrue("lowercase", r2 == -1);
	}
	
	/*-------------------------------------------------*/
	
	//test that doSomething() recognizes 'D' input and returns correct value (1 because the mock does meet win conditions)
	//assumes the Player.getX() methods are working properly
	@Test
	public void testDoSomething_drinkWin()
	{
		Player p = Mockito.spy(new Player());
		Game g = new Game(p, mockHouse);
		
		p.getCoffee();
		p.getCream();
		p.getSugar();
		
		int r1 = g.doSomething("D");
		int r2 = g.doSomething("d");
		
		Mockito.verify(p, Mockito.times(2)).drink();
		assertTrue("uppercase", r1 == 1);
		assertTrue("lowercase", r2 == 1);
	}
	
	/*-------------------------------------------------*/
	
	//test that doSomething() recognizes invalid input and returns correct value
	@Test
	public void testDoSomething_invalid()
	{
		Game g = new Game(mockPlayer, mockHouse);
		
		int r1 = g.doSomething("X");
		int r2 = g.doSomething("!");
		int r3 = g.doSomething("4");
		int r4 = g.doSomething("\u0007");
		int r5 = g.doSomething("test");
		
		Mockito.verifyZeroInteractions(mockHouse);
		Mockito.verifyZeroInteractions(mockPlayer);
		assertTrue("letter", r1 == 0);
		assertTrue("symbol", r2 == 0);
		assertTrue("number", r3 == 0);
		assertTrue("bell",   r4 == 0);
		assertTrue("string", r5 == 0);
	}
	
	/*-------------------------------------------------*/
	
	//test that run() recognizes a lose condition
	@Test
	public void testRun_lose()
	{
		Player p = Mockito.spy(new Player());
		House h = Mockito.spy(new House(6));
		Game g = Mockito.spy(new Game(p, h));
		
		ByteArrayInputStream in = new ByteArrayInputStream("D\n".getBytes());
		System.setIn(in);
		
		int condition = g.run();
		
		Mockito.verify(g, Mockito.times(1)).doSomething("D");
		Mockito.verify(p, Mockito.times(1)).drink();
		assertTrue(condition == 1);
	}
	
	/*-------------------------------------------------*/
	
	//test that run() recognizes a win condition
	@Test
	public void testRun_win()
	{
		Player p = Mockito.spy(new Player());
		House h = Mockito.spy(new House(6));
		Game g = Mockito.spy(new Game(p, h));
		
		ByteArrayInputStream in = new ByteArrayInputStream("L\nN\nN\nL\nN\nN\nN\nL\nD\n".getBytes());
		System.setIn(in);
		
		int condition = g.run();
		
		Mockito.verify(g, Mockito.times(3)).doSomething("L");
		Mockito.verify(g, Mockito.times(5)).doSomething("N");
		Mockito.verify(g, Mockito.times(1)).doSomething("D");
		
		Mockito.verify(h, Mockito.times(3)).look(p);
		Mockito.verify(h, Mockito.times(5)).moveNorth();
		
		Mockito.verify(p, Mockito.times(1)).getCream();
		Mockito.verify(p, Mockito.times(1)).getSugar();
		Mockito.verify(p, Mockito.times(1)).getCoffee();
		Mockito.verify(p, Mockito.times(1)).drink();
		
		assertTrue(condition == 0);
	}
}
