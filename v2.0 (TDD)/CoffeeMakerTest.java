//Code written by Mike Byrne
//	mjb187@pitt.edu

//Not tested:
//	public static void main(String[] args) 

//based on tests from Deliverable 2

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class CoffeeMakerTest 
{
	//test that runArgs() always returns the same value
	@Test
	public void testRunArgs()
	{
		CoffeeMaker cm = new CoffeeMaker();
		
		int r1 = cm.runArgs("X");
		int r2 = cm.runArgs("!");
		int r3 = cm.runArgs("4");
		int r4 = cm.runArgs("\u0007");
		int r5 = cm.runArgs("test");
		int r6 = cm.runArgs("jlkjahdsfglkjashdflakjsdhflakjsdhalskjdfhalskdfjhalsdkjfhasldkfjhasdlkfjhasdlkjhadslfjhasldkjhaslkjfhaslkjhasdjfhasljhasdlkjfhalkjfhalkjfhasdjfhalsdkjhalsdjfhalskjfalsdkjhaldskfhaldskhasdlkjhasfa");
		
		assertTrue("letter", r1 == -1);
		assertTrue("symbol", r2 == -1);
		assertTrue("number", r3 == -1);
		assertTrue("bell",   r4 == -1);
		assertTrue("string", r5 == -1);
		assertTrue("long",   r6 == -1);	
	}
	
	/*-------------------------------------------------*/
	
	//test that runGameLoop() returns correct value on lose condition
	@Test
	public void testRunGameLoop_lose()
	{
		CoffeeMaker cm = new CoffeeMaker();
		
		Player p = Mockito.spy(new Player());
		House h = Mockito.spy(new House(6));
		Game g = Mockito.spy(new Game(p, h));
		
		ByteArrayInputStream in = new ByteArrayInputStream("D\n".getBytes());
		System.setIn(in);
		
		int condition = cm.runGameLoop(p, h, g);
		
		Mockito.verify(g, Mockito.times(1)).run();
		Mockito.verify(g, Mockito.times(1)).doSomething("D");
		Mockito.verify(p, Mockito.times(1)).drink();
		assertTrue(condition == 1);
	}
	
	/*-------------------------------------------------*/
	
	//test that runGameLoop() returns correct value on win condition
	@Test
	public void testRunGameLoop_win()
	{
		CoffeeMaker cm = new CoffeeMaker();
		
		Player p = Mockito.spy(new Player());
		House h = Mockito.spy(new House(6));
		Game g = Mockito.spy(new Game(p, h));
		
		ByteArrayInputStream in = new ByteArrayInputStream("L\nN\nN\nL\nN\nN\nN\nL\nD\n".getBytes());
		System.setIn(in);
		
		int condition = cm.runGameLoop(p, h, g);
		
		Mockito.verify(g, Mockito.times(1)).run();
		
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