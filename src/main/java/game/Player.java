package game;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private List<Card> hand;
	private int roundWins = 0;
	
	private Player() {}
	
	public static Player newPlayer(String name) {
		Player player = new Player();
		player.name = name;
		player.addCardToHand(new Card(Side.SKULL));
		
		for (int i=0; i<3; i++) {
			player.addCardToHand(new Card(Side.FLOWER));
		}
		
		return player;
	}
	
	public String name() {
		return this.name;
	}
	
	public void addWin() {
		this.roundWins++;
	}
	
	public int wins() {
		return this.roundWins;
	}
	
	public List<Card> hand() {
		return hand;
	}
	public void hand(List<Card> hand) {
		this.hand = hand;
	}
	private void addCardToHand(Card card) {
		if (this.hand == null) {
			hand = new ArrayList<Card>();
		}
		hand.add(card);
	}
	public void addCardToTable(Table table, Card card) {
		table.add(card);
	}
	public boolean playFlower(Table table) {
		return playCard(table, Side.FLOWER);
	}
	public boolean playSkull(Table table) {
		return playCard(table, Side.SKULL);
	}
	private boolean playCard(Table table, Side side) {
		Card card = new Card(side);
		if (hand.contains(card)) {
			hand.remove(hand.indexOf(card));
			addCardToTable(table, card);
			return true;
		}
		return false;
	}
}
