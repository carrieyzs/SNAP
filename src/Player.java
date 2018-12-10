
/**
 * The Player class handles the current player as well as simulated
 * players. The class keeps track of player's
 * - hand (cards the player has)
 * - the counter (what the player says when it's player's turn)
 * 
 * @author Carrie
 */
public class Player {
	private PlayerStrategy player;

	/**
	 * Creates a new player given the respective instance of the strategy.
	 */
	public Player(PlayerStrategy p) {
		player = p;
	}
	
	public void play(Table t) {
		
	}
	
	public boolean match() {
		return player.hasMatch();
	}
	
//	public Rank speak() {
//		
//	}
}
