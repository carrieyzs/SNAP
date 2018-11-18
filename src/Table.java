import java.awt.Color;
import java.awt.Graphics;

/**
 * Table acts like the 'board'. It keeps track of the cards being played 
 * and the current play.
 * 
 * @author Carrie
 */
public class Table extends GUI {
	private CyclicList<Player> players;
	private Player currentPlayer;
	private int currentPlayerIndex;

	/**
	 * Initialises the various aspects of the game. This includes:
	 * - getting no. of players (2-4)
	 * - getting the current player
	 * - setting up current game
	 */
	public Table() {
		players = new CyclicList<Player>();
		currentPlayerIndex = 0;
	}
	
	/**
	 * If the game is in play state, then the current game will be
	 * rendered.
	 */
	public void render(Graphics g) {
	
	}

	/**
	 * If the game is in start state, then the start screen is 
	 * displayed.
	 */
	@Override
	public void renderStart(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, CANVAS_SIZE, CANVAS_SIZE);
	}

	/**
	 * If the game is in end state, then the game over message will
	 * be displayed.
	 */
	@Override
	public void renderEnd(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new Table();
	}
}
