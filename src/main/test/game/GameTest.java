package game;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {
	@Test
	public void testNew4PlayerGameContains4PlayersAnd1Table() {
		testNewXPlayerGameContainsXPlayersAnd1Table(4);
	}
	
	@Test
	public void testNew8PlayerGameContains8PlayersAnd1Table() {
		testNewXPlayerGameContainsXPlayersAnd1Table(8);
	}
	
	private void testNewXPlayerGameContainsXPlayersAnd1Table(int x) {
		int gameSize = x;
		
		Game game = Game.newGame(gameSize);
		Map<Integer, Player> players = game.players();
		
		Assert.assertEquals(gameSize, players.size());
		Assert.assertNotNull(game.table());
	}
}
