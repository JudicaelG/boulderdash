package tiles;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import projet.entities.EntityManager;
import projet.game.Handler;
import projet.game.World;

import javax.swing.text.html.parser.Entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class WorldTest {

	private World world;
	private Handler handler;
	private String patch;
	private EntityManager entityManager;
	private Entity entity;
	
	@Before
	public void setUp() throws Exception {
		this.world = new World (handler, patch);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetEntities() {
		final Entity expected = entity;
		assertEquals(expected, this.world.getEntities());
	}
	
	/*
	 *  Test of width of frame
	 */
	
	@Test
	public void testGetWidth() {
		final int expected = 768;
		assertEquals(expected, this.world.getWidth());
	}
	
	/*
	 *  Test of height of frame
	 */
	
	@Test
	public void testGetHeight() {
		final int expected = 768;
		assertEquals(expected, this.world.getHeight());
	}
	
	/*
	 * Test of tiles
	 */
	@Test
	public void testGetTiles() {
		final int expected = 1;
		assertEquals(expected, this.world.getTiles());
	}
	
	/*
	 * Test of EntityManager
	 */
	@Test
	public void testGetEntityManager() {
		final EntityManager expected = entityManager;
		assertEquals(expected, this.world.getEntityManager());
	}
	
	/*
	 * Test of tile
	 */
	@Test
	public void testGetTile() {
		final int expected = 1;
		assertEquals(expected, this.world.getTile(1, 1));
	}
	
	/*
	 *  Test max range of width of frame
	 */
	@Test
	public void excepWidthMaxRange()
	{
		try
		{
			new World (handler, patch);
			fail("Should throw exception when width > 768");
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
			new World (handler, patch);
			fail("Should throw exception when width < 100");
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
			new World (handler, patch);
			fail("Should throw exception when width > 768");
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
			new World (handler, patch);
			fail("Should throw exception when width > 100");
		}
		catch(final Exception e)
		{
			final String expected = "width out range";
			assertEquals(expected, e.getMessage());
		}
	}

}
