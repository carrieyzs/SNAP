
public class Game {
	private CyclicList<Player> players;
	private Player currentPlayer;
	private int currentPlayerIndex;
	
	public Game(CyclicList<Player> p) {
		players = p;
	}
	
	public void setPlayers(CyclicList<Player> p) {
		players = p;
		// get random current player index?
		currentPlayerIndex = 0;
	}
}
