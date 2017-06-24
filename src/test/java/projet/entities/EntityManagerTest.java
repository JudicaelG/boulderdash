package projet.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projet.game.Handler;
import projet.entities.dynamic.Player;

public class EntityManagerTest {
	
	private EntityManager entityManager;
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	
	@Before
	public void setUp() throws Exception {
		this.entityManager = new EntityManager(handler, player);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	/*
	 * test of Handler
	 */
	@Test
	public void testGetHandler() {
		final Handler expected = handler;
		assertEquals(expected, this.entityManager.getHandler());
	}
	
	/*
	 * Test of player
	 */
	@Test
	public void testGetPlayer() {
		final Player expected = player;
		assertEquals(expected, this.entityManager.getPlayer());
	}
	
	/*
	 * Test of entities
	 */
	@Test
	public void testGetEntities() {
		final ArrayList<Entity> expected = entities;
		assertEquals(expected, this.entityManager.getEntities());
	}

}
