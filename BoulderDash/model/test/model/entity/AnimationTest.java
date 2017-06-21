package model.entity;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnimationTest {
	
	private Animation animation;
	private BufferedImage[] frames;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.animation = new Animation(1, frames);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCurrentFrame() {
		final BufferedImage[] expected = frames;
		assertEquals(expected, this.animation.getCurrentFrame());
	}

}
