package model.Tile;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TileTest {
	
	private Tile tile;
	private BufferedImage texture;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.tile = new Tile(texture, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetId() {
		final int expected = 1;
		assertEquals(expected, this.tile.getId());
	}

}
