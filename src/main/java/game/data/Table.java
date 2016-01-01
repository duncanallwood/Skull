package game.data;

import java.util.LinkedList;

public class Table {
	LinkedList<Card> cards;
	
	Table() {}
	
	public Card lastCard() {
		return cards.peekLast();
	}
	
	public void add(Card card) {
		if (cards == null) {
			cards = new LinkedList<Card>();
		}
		cards.add(card);
	}
}
