package projet.model;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TileTest {

	private Tile tile;
	private BufferedImage texture;
	
	@Before
	public void setUp() throws Exception {
		this.tile = new Tile(texture, 1);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/*
	 * * Test id
	 */
	@Test
	public void testGetId() {
		final int expected = 1;
		assertEquals(expected, this.tile.getId());
	}
	
	/*
	 * exception if id < 0
	 */
	@Test
	public void excepMinGetId ()
	{
		try
		{
			new Tile(texture, 1);
			fail("Should throw exception when id < 0");
		}
		catch(final Exception e)
		{
			final String expected = "Id out range";
			assertEquals(expected, e.getMessage());
		}
	}

}
