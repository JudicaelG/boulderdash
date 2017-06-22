package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.KeyManager;
import view.Camera;

public class HandlerTest {
	
	private Handler handler;
	private Game game;
	private World world;
	private KeyManager keyManager;
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


	@Test
	public void testGetWidth() {
		final int expected = 4;
		assertEquals(expected, this.game.getWidth());
	}

	@Test
	public void testGetHeight() {
		final int expected = 4;
		assertEquals(expected, this.game.getWidth());
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
