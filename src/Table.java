
public class Table extends GUI {
	private CyclicList<Player> players;
	private Player currentPlayer, nextPlayer;

	/**
	 * Initialises the various aspects of the game. This includes:
	 * - getting no. of players (2-4) // single player for now...
	 * - getting the current player
	 * - getting the next player
	 * - setting up current game
	 */
	public Table() {
		players = new CyclicList<Player>();
	}
}
