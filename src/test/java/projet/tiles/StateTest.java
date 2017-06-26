package projet.tiles;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import projet.game.Handler;
import projet.game.states.State;

public abstract class StateTest {
	
	abstract State createState(Handler handler);
	private Handler handler;
	private State state;
	
	@Before
	public void setUp() throws Exception {
		State state = createState(handler);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		final Handler expected = handler;
		assertEquals(expected, this.state.getState());
	}

}
