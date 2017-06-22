package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class StateTest {
	
	abstract State createState(Handler handler);
	private Handler handler;
	private State state;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		State state = createState(handler);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetState() {
		final Handler expected = handler;
		assertEquals(expected, this.state.getState());
	}

}

