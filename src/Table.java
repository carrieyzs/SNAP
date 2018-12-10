import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/**
 * Table acts like the 'board'. It keeps track of the cards being played 
 * and the current play.
 * 
 * @author Carrie
 */
public class Table extends GUI {
	//private CyclicList<Player> players;
	//private Player currentPlayer;
	//private int currentPlayerIndex;

	/**
	 * Initialises the various aspects of the game. This includes:
	 * - getting no. of players (2-4)
	 * - getting the current player
	 * - setting up current game
	 */
	public Table() {
		game = new Game(new CyclicList<Player>());	//might need changing later on...
		//players = new CyclicList<Player>();
		//currentPlayerIndex = 0;
	}
	
	/**
	 * Sets up the game, by allowing the user to determine no. of
	 * players and then setting up players' cards.
	 * Then it displays the ongoing game.
	 */
	private void setUpGame() {	// include in plan..
		CyclicList<Player> players = new CyclicList<Player>();
		
		// get user name
		String playername = (String) JOptionPane.showInputDialog(
				frame, "Enter your name: ");
		
		// create the player instance for user
		players.add(new Player(new RealPlayerStrategy(playername)));
		
		// get no. of players
		String[] noOfPlayers = {"2", "3", "4"};
		String userInput = (String) JOptionPane.showInputDialog(
				frame, "Select no. of players:", "Players", JOptionPane.QUESTION_MESSAGE,
				null, noOfPlayers, noOfPlayers[0]);
		
		// add the rest of the players
		int np = Integer.parseInt(userInput);
		for (int i=1; i<np; i++)	
			players.add(new Player(new SimulatedPlayerStrategy("Player "+i)));
		
		game.setPlayers(players); 	// add players to game
		// render play state
	}
	
	/**
	 * If the game is in play state, then the current game will be
	 * rendered.
	 * It will render the ongoing game as long as the game isn't 
	 * finished.
	 */
	public void render() {
		// play game -> this method will render the game while it's not over
		// transition state -> if it reaches here, the game is not played anymore
	}

	/**
	 * If the game is in start state, then the start screen is 
	 * displayed.
	 */
//	@Override
//	public void renderStart() {
//		g.setColor(Color.GRAY);
//		g.fillRect(0, 0, CANVAS_SIZE, CANVAS_SIZE);
//	}
	
	/**
	 * Displays the starting screen of the game. This includes the
	 * instructions of the game play as well as the start button.
	 * When the user decides to play, the game state transitions to
	 * the next state.
	 */
	public void renderStart() {		
		container.setPreferredSize(
				new Dimension(CANVAS_SIZE, CANVAS_SIZE));
		container.setLayout(new GridBagLayout());
		
		// text that describes how the game works
		GridBagConstraints cc = new GridBagConstraints();
		cc.gridx = 1;
		cc.gridy = 0;
		JTextPane instructions = new JTextPane();
		instructions.setEditable(false);
		instructions.setPreferredSize(new Dimension(500, 250));
		String desc = "Aim: Get rid of all the cards in your hand.\n\n"
				+ "The first one to empty their hand does not need to continue "
				+ "with the game. The rest of the players may go ahead, "
				+ "and try to complete the aim of the game.\n\n"
				+ "The game goes around the table, starting from a"
				+ " player chosen at random. The cards on your hand "
				+ "are facedown. As the play goes around, each player"
				+ " speaks out the possible rank of the card -- starting from ACE --"
				+ " in ascending order.\n\n"
				+ "When your rank and the actual card's rank match,"
				+ " everyone on the table will place their hand on "
				+ "the cards played. The cards go to the one whose hand is on "
				+ "top, thus increasing the player's hand.";
		instructions.setText(desc);
		//TODO: style text pane HERE
		container.add(instructions, cc);
		
		// button that initiates the game
		JButton start = new JButton("START");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentState = currentState.transition(game);
				setUpGame();
			}
		});
		start.setPreferredSize(new Dimension(200, 50));
		start.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 2;
		
		container.setBackground(Color.GREEN.darker());
		container.add(start, c);
	}

	/**
	 * If the game is in end state, then the game over message will
	 * be displayed.
	 */
	@Override
	public void renderEnd() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new Table();
	}

}
