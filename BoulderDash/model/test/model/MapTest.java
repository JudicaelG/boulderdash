package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapTest {
	
	private Map map;
	private BoulderDashModel boulderDashModel;
	private String path;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.map = new Map(boulderDashModel, path);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetWidth() {
		final int expected = 7;
		assertEquals(expected, this.map.getWidth());
	}

	@Test
	public void testGetHeight() {
		final int expected = 7;
		assertEquals(expected, this.map.getHeight());
	}


}
