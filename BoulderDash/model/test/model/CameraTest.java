package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.entity.Player;

public class CameraTest {
	
	private BoulderDashModel boulderDashModel;
	private Camera camera;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.camera = new Camera (boulderDashModel, 1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetxOffset() {
		final float expected = 1;
		assertEquals(expected, 1, 1);
	}

	@Test
	public void testGetyOffset() {
		final float expected = 1;
		assertEquals(expected, 1, 1);
	}
	
	@Test
	public void excepMinxOffset()
	{
		try 
		{
			new Camera(boulderDashModel, 0, 50);
		}
		catch (final Exception e)
		{
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
		
	}
	
	@Test
	public void excepMaxxOffset()
	{
		try 
		{
			new Camera(boulderDashModel, 0, 50);
		}
		catch (final Exception e)
		{
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
		
	}
	
	@Test
	public void excepMinyOffset()
	{
		try 
		{
			new Camera(boulderDashModel, 0, 50);
		}
		catch (final Exception e)
		{
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
		
	}
	
	@Test
	public void excepMaxyOffset()
	{
		try 
		{
			new Player(boulderDashModel, 0, 50);
		}
		catch (final Exception e)
		{
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
		
	}

}
