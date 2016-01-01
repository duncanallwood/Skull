package game.data;

public class Card {
	private Side side;

	public Card(Side side) {
		this.side = side;
	}

	public Side side() {
		return side;
	}

	public void side(Side side) {
		this.side = side;
	}
	
	public boolean equals(Object o) {
		if (o == null)
			return false;
		Card other = (Card) o;
		if (this.side() == other.side())
			return true;
		return false;
	}
}
