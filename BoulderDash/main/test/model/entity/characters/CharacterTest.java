package model.entity.characters;

import static org.junit.Assert.*;

import java.util.logging.Handler;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class CharacterTest {

	abstract Character createCharacter(Handler handler, float x, float y, int width, int height);
	private Handler handler;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Character character = createCharacter(handler, 4, 4, 4, 4);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSpeed() {
		final float expected = 4;
		assertEquals(expected, 4, 5);
	}

	@Test
	public void testGetxMove() {
		final float expected = 4;
		assertEquals(expected, 4, 5);
	}

	@Test
	public void testGetyMove() {
		final float expected = 4;
		assertEquals(expected, 4, 5);
	}

}
