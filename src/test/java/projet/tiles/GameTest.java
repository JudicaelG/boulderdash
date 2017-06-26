package projet.tiles;


import junit.framework.TestCase;
import org.junit.*;
import projet.game.Game;
import projet.view.Camera;

import javax.net.ssl.KeyManager;

public class GameTest extends TestCase {
	
	private Game game;
	private Camera camera;
	private KeyManager keyManager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.game = new Game("BoulderDash", 768, 768);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/*
	 *  Test of width of frame
	 */
	
	@Test
	public void testGetWidth() {
		final int expected = 768;
		assertEquals(expected, this.game.getWidth());
	}
	
	/*
	 *  Test of height of frame
	 */
	
	@Test
	public void testGetHeight() {
		final int expected = 768;
		assertEquals(expected, this.game.getHeight());
	}

	@Test
	public void testGetKeyManager() {
		final KeyManager expected = keyManager;
		assertEquals(expected, this.game.getKeyManager());
	}
	
	/*
	 *  Test of Camera
	 */
	
	@Test
	public void testGetCamera() {
		final Camera expected = camera;
		assertEquals(expected, this.game.getCamera());
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
