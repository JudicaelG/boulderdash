package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.entity.Alive;
import model.entity.Player;

public class AliveManagerTest {

	private static final BoulderDashModel boulderDashModel = null;
	private static final Player player = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetHandler() {
		final BoulderDashModel expected = boulderDashModel;
		final AliveManager aliveManager = new AliveManager(boulderDashModel, player);
		assertEquals(expected, aliveManager.getHandler());
	}

	@Test
	public void testGetPlayer() {
		final Player expected = player;
		final AliveManager aliveManager = new AliveManager(boulderDashModel, player);
		assertEquals(expected, aliveManager.getPlayer());
	}

	@Test
	public void testGetalive() {
		final ArrayList<Alive> expected = ArrayList<Alive> alive;
		final AliveManager aliveManager = new AliveManager(boulderDashModel, player);
		assertEquals(expected, aliveManager.getalive());
	}

}
