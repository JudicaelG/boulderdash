package projet.model.entities.characters;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projet.model.Handler;

public abstract class CharacterTest {
	
	abstract Character createCharacter(Handler handler, float x, float y, int width, int height);
	private Handler handler;
	Character character;

	@Before
	public void setUp() throws Exception {
		Character character = createCharacter(handler, 4, 4, 48, 48);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/*
	 * Test of speed
	 */
	@Test
	public void testGetSpeed() {
		final int expected = 48;
		assertEquals(expected, this.character.getSpeed());
	}
	
	/*
	 * Test of xmove
	 */
	@Test
	public void testGetxMove() {
		final float expected = 4;
		assertEquals(expected, 4, 5);
	}
	
	/*
	 * Test of ymove
	 */
	@Test
	public void testGetyMove() {
		final float expected = 4;
		assertEquals(expected, 4, 5);
	}

}
