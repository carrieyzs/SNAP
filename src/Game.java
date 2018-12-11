
// add all this to plan!
// include javadocs
/**
 * This class involves all interactions/affiliations with the card game.
 * This includes the players involved, the players' play as well as 
 * ending/starting a game.
 * 
 * @author Carrie
 */
public class Game {
	private CyclicList<Player> players;
	private Player currentPlayer;
	private int currentPlayerIndex;
	private boolean isGameOver;
	
	/** Creates a game instance. */
	public Game() {
		
	}
	
	/**
	 * Sets the game status.
	 * @param flag
	 * 			indicates whether the game is over or not
	 */
	public void setGameOver(boolean flag) { isGameOver = flag; }
	
	/**
	 * Typically used to give new players to a game ()
	 * @param p
	 * 			sets players to the current game
	 */
	public void setPlayers(CyclicList<Player> p) {	// REMOVE ?
		players = p;
		currentPlayer = players.get(0);		// first player starts
	}
	
	/**
	 * 
	 * @param t
	 * 			Table to place the played card on
	 */
	public void playGame(Table t) {
		// start playing game from currentPlayerIndex
		// while game is not over
			// while integer < players.size()
			// all players play -- currentplayer.play; currentplayer = list.next()
			// each player set win with no. of cards in their hand
			// check player's card with their supposed rank -> checkslap()
			
	}
}
