package model;

import static org.junit.Assert.*;

import java.awt.Canvas;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DisplayTest {

	private Display display;
	private JFrame frame;
	private Canvas canvas;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.display = new Display("BoulderDash", 768, 768);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCanvas() {
		final Canvas expected = canvas;
		assertEquals(expected, this.display.getCanvas());
	}

	@Test
	public void testGetFrame() {
		final JFrame expected = frame;
		assertEquals(expected, this.display.getFrame());
		
	}
	
	@Test
	public void excepCanvasMinRange()
	{
		try
		{
			new Display ("Boulderdash", 400, 768);
			//fail("Schould throw exception when Canvas < 400");
		}
		catch(final Exception e)
		{
			final String expected = "Canvas out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void excepCanvasMaxRange()
	{
		try
		{
			new Display ("Boulderdash", 400, 768);
			//fail("Schould throw exception when Canvas > 768");
		}
		catch(final Exception e)
		{
			final String expected = "Canvas out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void excepFrameMinRange()
	{
		try
		{
			new Display ("Boulderdash", 400, 768);
			//fail("Schould throw exception when Frame < 400");
		}
		catch(final Exception e)
		{
			final String expected = "Frame out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void excepFrameMaxRange()
	{
		try
		{
			new Display ("Boulderdash", 400, 768);
			//fail("Schould throw exception when Frame > 768");
		}
		catch(final Exception e)
		{
			final String expected = "Frame out of range";
			assertEquals(expected, e.getMessage());
		}
	}

}
