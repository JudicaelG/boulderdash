package projet.model.entities;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projet.model.Game;
import projet.model.Handler;

public abstract class EntityTest {

	abstract Entity createEntity(Handler handler, float x, float y, int width, int height);
	private Handler handler;
	private Entity entity;
	private Rectangle bounds;
	
	@Before
	public void setUp() throws Exception {
		Entity entity =  createEntity(handler, 4, 4, 48, 48);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/*
	 * get of getx
	 */
	@Test
	public void testGetX() {
		final float expected = 4;
		assertEquals(expected, 4, 5);
	}
	
	/*
	 *  test of gety
	 */
	@Test
	public void testGetY() {
		final float expected = 4;
		assertEquals(expected, 4, 5);
	}
	
	/*
	 *  test of width
	 */
	@Test
	public void testGetWidth() {
		final int expected = 48;
		assertEquals(expected, this.entity.getWidth());
	}
	
	/*
	 *  test of Height
	 */
	@Test
	public void testGetHeight() {
		final int expected = 48;
		assertEquals(expected, this.entity.getHeight());
	}
	
	/*
	 *  Test of health
	 */
	@Test
	public void testGetHealth() {
		final int expected = 10;
		assertEquals(expected, this.entity.getHealth());
	}
	
	/*
	 * Test of bounds
	 */
	@Test
	public void testGetCollisionBounds() {
		final Rectangle expected = bounds;
		assertEquals(expected, this.entity.getCollisionBounds(4, 4));
	}
	
	/*
	 *  Test max range of width of entity
	 */
	@Test
	public void excepWidthMaxRange()
	{
		try
		{
			createEntity(handler, 4, 4, 48, 48);
			fail("Schould throw exception when width > 768");
		}
		catch(final Exception e)
		{
			final String expected = "width out range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	/*
	 *  Test min range of width of entity
	 */
	@Test
	public void excepWidthMinRange()
	{
		try
		{
			createEntity(handler, 4, 4, 48, 48);
			fail("Schould throw exception when width < 100");
		}
		catch(final Exception e)
		{
			final String expected = "width out range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	/*
	 *  Test max range of height of frame
	 */
	@Test
	public void excepHeighthMaxRange()
	{
		try
		{
			createEntity(handler, 4, 4, 48, 48);
			fail("Schould throw exception when width > 768");
		}
		catch(final Exception e)
		{
			final String expected = "width out range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	
	/*
	 *  Test min range of height of frame
	 */
	@Test
	public void excepHeighthMinRange()
	{
		try
		{
			createEntity(handler, 4, 4, 48, 48);
			fail("Schould throw exception when width > 100");
		}
		catch(final Exception e)
		{
			final String expected = "width out range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	/*
	 * Test max range of health
	 */
	@Test
	public void excepHealthMaxRange()
	{
		try
		{
			createEntity(handler, 4, 4, 48, 48);
			fail("Schould throw exception when width > 10");
		}
		catch(final Exception e)
		{
			final String expected = "width out range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	/*
	 * Test min range of health
	 */
	@Test
	public void excepHealthMinRange()
	{
		try
		{
			createEntity(handler, 4, 4, 48, 48);
			fail("Schould throw exception when width < 0");
		}
		catch(final Exception e)
		{
			final String expected = "width out range";
			assertEquals(expected, e.getMessage());
		}
	}
}
