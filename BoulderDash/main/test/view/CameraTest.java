package view;

import static org.junit.Assert.*;

import java.util.logging.Handler;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CameraTest {
	
	private Camera camera;
	private model.Handler handler;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.camera = new Camera(handler, 4, 4);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetxOffset() {
		final float expected = 4;
		assertEquals(expected, 4, 5);
	}

	@Test
	public void testGetyOffset() {
		final float expected = 4;
		assertEquals(expected, 4, 5);
	}

}
