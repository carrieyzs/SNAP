import java.awt.Graphics;
import java.util.List;

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
	 * Sets the players into the current game, and distributes the cards to each.
	 * @param p
	 * 			sets players to the current game
	 */
	public void setPlayers(CyclicList<Player> p) {	
		players = p;
		currentPlayer = players.next();
		
		List<Card> deck = Card.getDeck();
		while (!deck.isEmpty()) {		// distributes the deck of cards to each player
			currentPlayer.addHand(deck.remove(0));
			currentPlayer = players.next();		// move on to the next player
		}
		
		currentPlayer = players.get(0);		// first player starts
	}
	
	/**
	 * Method proceeds with game plays, as well as rendering after each update.
	 * @param t
	 * 			Table to place the played card on
	 * @param g
	 * 			Graphics object to render state of the game
	 */
	public void playGame(Table t, Graphics g) {
		// start playing game from currentPlayerIndex
		// while game is not over
			// while integer < players.size()
			// all players play -- currentplayer.play; currentplayer = list.next()
			// each player set win with no. of cards in their hand
			// check player's card with their supposed rank -> checkslap()
		
		renderGame(g);
	}
	
	/**
	 * Method used to show the game after each update.
	 * @param g
	 * 			Graphics object to display game
	 */
	private void renderGame(Graphics g) {
		
	}
}
