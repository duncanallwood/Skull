package game;

import java.util.ArrayList;
import java.util.List;

public class PlaySkull {
	private List<Player> players;
	
	public static void main(String args[]) {
		if (args.length != 1) {
			System.out.println("Insufficient arguments supplied - no player number given");
		}
		
		PlaySkull skull = new PlaySkull(Integer.parseInt(args[0]));
	}
	
	private PlaySkull(int playerNo) {
		players = new ArrayList<Player>();
		createRandomlyNamedPlayers(playerNo);
	}
	
	private void createRandomlyNamedPlayers(int playerNo) {
		Names names = new Names();
		for(int i=0; i<playerNo; i++) {
			players.add(Player.newPlayer(names.name()));
		}
	}
	
	
}
