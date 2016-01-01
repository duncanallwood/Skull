package game.data;

import java.util.HashMap;
import java.util.Map;

// Trying out ditching the "get" and "set" in favour of brevity... we'll see...
public class Game {
	Map<Integer, Player> players;
	Table table = new Table();
	
	private Game(int playerNumber) {
		players = new HashMap<Integer, Player>(playerNumber);
		Names names = new Names();
		for(int i=0; i<playerNumber; i++) {
			players.put(i, Player.newPlayer(names.name()));
		}
	}
	
	public static Game newGame(int playerNumber) {
		return new Game(playerNumber);
	}
	
	public Map<Integer, Player> players() {
		return players;
	}
	
	public Player playerAtPosition(int position) {
		return players.get(position);
	}
	
	public Table table() {
		return table;
	}
}
