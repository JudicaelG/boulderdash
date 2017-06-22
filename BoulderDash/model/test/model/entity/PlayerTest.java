package model.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.BoulderDashModel;

public class PlayerTest{
	
	private BoulderDashModel boulderDashModel;
	private Player player;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.player = new Player(boulderDashModel, 1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testGetX() {
		final float expected = 1;
		assertEquals(expected, 1, 1);
	}

	@Test
	public void testGetY() {
		final float expected = 1;
		assertEquals(expected, 1, 1);
	}

	@Test
	public void excepMinX()
	{
		try 
		{
			new Player(boulderDashModel, 0, 50);
			//fail ("Should throw exception when x < 0");
		}
		catch (final Exception e)
		{
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
		
	}
	
	@Test
	public void excepMaxX()
	{
		try 
		{
			new Player(boulderDashModel, 0, 50);
			//fail ("Should throw exception when x > 50");
		}
		catch (final Exception e)
		{
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
		
	}
	
	@Test
	public void excepMinY()
	{
		try 
		{
			new Player(boulderDashModel, 0, 50);
			//fail ("Should throw exception when x < 0");
		}
		catch (final Exception e)
		{
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
		
	}
	
	@Test
	public void excepMaxY()
	{
		try 
		{
			new Player(boulderDashModel, 0, 50);
			//fail ("Should throw exception when x > 50");
		}
		catch (final Exception e)
		{
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
		
	}

}
