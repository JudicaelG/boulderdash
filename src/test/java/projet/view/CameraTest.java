package projet.view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projet.model.Handler;

public class CameraTest {
	
	private Camera camera;
	private Handler handler;
	
	@Before
	public void setUp() throws Exception {
		this.camera = new Camera(handler, 4, 4);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/*
	 * Test of xoffset
	 */
	@Test
	public void testGetxOffset() {
		final float expected = 4;
		assertEquals(expected, 4, 5);
	}
	
	/*
	 * Test of yoffset
	 */
	@Test
	public void testGetyOffset() {
		final float expected = 4;
		assertEquals(expected, 4, 5);
	}

}
