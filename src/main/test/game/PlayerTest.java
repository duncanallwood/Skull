package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

public class PlayerTest {
	@Test
	public void confirmFourCardsInHand() {
		Player player = Player.newPlayer("Jimbob");
		
		assertEquals(player.hand().size(), 4);
	}
	
	@Test
	public void confirmThreeFlowersAndOneSkull() {
		Player player = Player.newPlayer("Horatio");
		List<Card> hand = player.hand();
		
		testNoOfSkullsAndFlowers(hand, 1, 3);
	}
	
	private void testNoOfSkullsAndFlowers(List<Card> cards, int skull, int flower) {
		int skulls = 0;
		int flowers = 0;
		
		for (Card card : cards) {
			if (card.side() == Side.SKULL) {
				skulls++;
			} else if (card.side() == Side.FLOWER) {
				flowers++;
			}
		}
		
		assertEquals(skulls, skull);
		assertEquals(flowers, flower);
	}
	
	@Test
	public void confirmNewTableHasNoCards() {
		Game game = Game.newGame(1);
		
		assertNull(game.table().cards);
	}
	
	@Test
	public void testPlaySkullPutsSkullFromHandToTable() {
		Game game = Game.newGame(1);
		Player player = game.playerAtPosition(0);
		
		player.playSkull(game.table());
		
		testNoOfSkullsAndFlowers(player.hand(), 0, 3);
		testNoOfSkullsAndFlowers(game.table().cards, 1, 0);
	}
	
	@Test
	public void testPlayFlowerPutsFlowerFromHandToTable() {
		Game game = Game.newGame(1);
		Player player = game.playerAtPosition(0);

		player.playFlower(game.table());
		
		testNoOfSkullsAndFlowers(player.hand(), 1, 2);
		testNoOfSkullsAndFlowers(game.table().cards, 0, 1);
	}
}
