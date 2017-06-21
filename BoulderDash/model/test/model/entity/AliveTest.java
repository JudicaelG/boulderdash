package model.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import model.BoulderDashModel;

public abstract class AliveTest{

	abstract Alive createAlive(BoulderDashModel boulderDashModel, float x, float y, int width, int height);
	private BoulderDashModel boulderDashModel;
	private Alive alive;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Alive alive = createAlive(boulderDashModel, 4, 4, 4, 4);
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
		assertEquals(expected, alive.getWidth(), 4);
	}

	@Test
	public void testGetHeight() {
		final int expected = 4;
		assertEquals(expected, this.alive.getHeight(), 4);
	}

}
