
// add all this to plan!
// include javadocs
public class Game {
	private CyclicList<Player> players;
	private Player currentPlayer;
	private int currentPlayerIndex;
	private boolean isGameOver;
	
	public Game(CyclicList<Player> p) {
		players = p;
	}
	
	public void setGameOver(boolean flag) { isGameOver = flag; }
	
	public void setPlayers(CyclicList<Player> p) {
		players = p;
		// get random current player index?
		//currentPlayerIndex = 0;
		currentPlayer = players.get(0);		// first player starts
	}
	
	public void playGame() {
		// start playing game from currentPlayerIndex
		// while game is not over
			// while integer < players.size()
			// all players play -- currentplayer.play; currentplayer = list.next()
			// each player set win with no. of cards in their hand
			// check player's card with their supposed rank -> checkslap()
			
	}
}
