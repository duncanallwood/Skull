package game.data;

import java.util.LinkedList;
import java.util.List;

public class Bet {
	private int currentBet = 0;
	private boolean bettingStarted = false;
	private int currentBetByPlayerAtPosition = 0;
	private LinkedList<Pair<Integer,Integer>> pastBets = null;
	
	private static Bet bet = null;
	
	private Bet() {
		this.pastBets = new LinkedList<Pair<Integer, Integer>> ();
	}
	
	public static Bet newBet(int playerPosition, int betAmount) {
		if (bet == null)
			bet = new Bet();
		
		bet.currentBet(betAmount);
		bet.bettingStarted(true);
		bet.currentBetByPlayerAtPosition(playerPosition);
		bet.addPastBet(new Pair<Integer, Integer>(playerPosition, betAmount));
		
		return bet;
	}
	
	public static void resetBet() {
		bet = null;
	}
	
	public int currentBet() {
		return currentBet;
	}
	public void currentBet(int currentBet) {
		if (currentBet < this.currentBet)
			throw new BetException("New Bet amount (" + currentBet + ") not higher than existing Bet amount (" + this.currentBet + ").");
		this.currentBet = currentBet;
	}
	
	public boolean bettingStarted() {
		return bettingStarted;
	}
	public void bettingStarted(boolean bettingStarted) {
		this.bettingStarted = bettingStarted;
	}
	
	public int currentBetByPlayerAtPosition() {
		return currentBetByPlayerAtPosition;
	}
	public void currentBetByPlayerAtPosition(int currentBetByPlayerAtPosition) {
		this.currentBetByPlayerAtPosition = currentBetByPlayerAtPosition;
	}
	
	public List<Pair<Integer, Integer>> pastBets() {
		return pastBets;
	}
	public void pastBets(LinkedList<Pair<Integer, Integer>> pastBets) {
		this.pastBets = pastBets;
	}
	public boolean addPastBet(Pair<Integer, Integer> bet) {
		return pastBets.add(bet);
	}
}
