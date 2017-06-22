package model.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Handler;

public abstract class EntityTest {
	
	abstract Entity createEntity(Handler handler, float x, float y, int width, int height);
	private Handler handler;
	private Entity entity;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Entity entity =  createEntity(handler, 4, 4, 4, 4);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetX() {
		final float expected = 4;
		assertEquals(expected, 4, 5);
	}

	@Test
	public void testGetY() {
		final float expected = 4;
		assertEquals(expected, 4, 5);
	}

	@Test
	public void testGetWidth() {
		final int expected = 4;
		assertEquals(expected, entity.getWidth(), 4);
	}

	@Test
	public void testGetHeight() {
		final int expected = 4;
		assertEquals(expected, entity.getHeight(), 4);
	}


}
