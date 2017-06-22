package model.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Handler;
import model.entity.characters.Player;

public class EntityManagerTest {

	private EntityManager entityManager;
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.entityManager = new EntityManager(handler, player);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetHandler() {
		final Handler expected = handler;
		assertEquals(expected, this.entityManager.getHandler());
	}

	@Test
	public void testGetPlayer() {
		final Player expected = player;
		assertEquals(expected, this.entityManager.getPlayer());
	}


}
