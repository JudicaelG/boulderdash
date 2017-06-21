package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.entity.Alive;
import model.entity.Player;
//Test AliveManager

public class AliveManagerTest {

	private BoulderDashModel boulderDashModel;
	private Player player;
	private ArrayList<Alive> alive;
	private AliveManager aliveManager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.aliveManager = new AliveManager(boulderDashModel, player);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetHandler() {
		final BoulderDashModel expected = boulderDashModel;
		assertEquals(expected, this.aliveManager.getHandler());
	}

	@Test
	public void testGetPlayer() {
		final Player expected = player;
		assertEquals(expected, this.aliveManager.getPlayer());
	}
	
	@Test
	public void excepHandler()
	{
		try
		{
			new AliveManager(boulderDashModel, player);
		}
		catch (final Exception e)
		{
			final String expected = "BoulderDashModel out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void excepPlayer()
	{
		try
		{
			new AliveManager(boulderDashModel, player);
		}
		catch (final Exception e)
		{
			final String expected = "BoulderDashModel out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	

}
