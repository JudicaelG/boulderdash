package model;

import static org.junit.Assert.*;

import javax.swing.text.html.parser.Entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.entity.EntityManager;

public class WorldTest {
	
	private World world;
	private Handler handler;
	private String patch;
	private EntityManager entityManager;
	private Entity entity;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

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

	@Test
	public void testGetWidth() {
		final int expected = 4;
		assertEquals(expected, this.world.getWidth());
	}

	@Test
	public void testGetHeight() {
		final int expected = 4;
		assertEquals(expected, this.world.getHeight());
	}

	@Test
	public void testGetTiles() {
		final int expected = 4;
		assertEquals(expected, this.world.getTiles());
	}

	@Test
	public void testGetEntityManager() {
		final EntityManager expected = entityManager;
		assertEquals(expected, this.world.getEntityManager());
	}

	@Test
	public void testGetTile() {
		final int expected = 4;
		assertEquals(expected, this.world.getTile(4, 4));
	}

}
