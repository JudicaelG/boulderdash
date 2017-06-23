package projet.model;

import static org.junit.Assert.*;

import javax.net.ssl.KeyManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import projet.view.Camera;

public class HandlerTest {

	private Handler handler;
	private KeyManager keyManager;
	private Game game;
	private World world;
	private Camera camera;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.handler = new Handler(game);
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * test of width of frame
	 */
	@Test
	public void testGetWidth() {
		final int expected = 768;
		assertEquals(expected, this.handler.getWidth());
	}
	
	/*
	 * test of width of frame
	 */
	
	@Test
	public void testGetHeight() {
		final int expected = 768;
		assertEquals(expected, this.handler.getWidth());
	}
	
	/*
	 * test keyManager
	 */
	@Test
	public void testGetKeyManager() {
		final KeyManager expected = keyManager;
		assertEquals(expected, this.handler.getKeyManager());
	}
	
	/*
	 * test Camera
	 */
	@Test
	public void testGetCamera() {
		final Camera expected = camera;
		assertEquals(expected, this.handler.getCamera());
	}
	
	/*
	 * test world
	 */
	@Test
	public void testGetWolrd()
	{
		final World expected = world;
		assertEquals(expected, this.handler.getWorld());	
	}
	
	/*
	 *  Test max range of width of frame
	 */
	@Test
	public void excepWidthMaxRange()
	{
		try
		{
			new Game("BoulderDash", 768, 768);
			fail("Schould throw exception when width > 768");
		}
		catch(final Exception e)
		{
			final String expected = "width out range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	/*
	 *  Test min range of width of frame
	 */
	@Test
	public void excepWidthMinRange()
	{
		try
		{
			new Game("BoulderDash", 768, 768);
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
			new Game("BoulderDash", 768, 768);
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
			new Game("BoulderDash", 768, 768);
			fail("Schould throw exception when width > 100");
		}
		catch(final Exception e)
		{
			final String expected = "width out range";
			assertEquals(expected, e.getMessage());
		}
	}
}
