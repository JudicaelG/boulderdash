package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameTest {
	
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

	@Test
	public void testGetWidth() {
		final int expected = 768;
		assertEquals(expected, this.game.getWidth());
	}

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

	@Test
	public void testGetCamera() {
		final Camera expected = camera;
		assertEquals(expected, this.game.getCamera());
	}

}
