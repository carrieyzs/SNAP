import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Class that sets up the graphical representation of the game.
 * 
 * @author Carrie
 */
public abstract class GUI {
	// JSwing fields
	protected JFrame frame;
	protected JComponent container;
	
	
	// Game related fields
	protected State currentState;
	protected Game game;

	/**
	 * Sets up the basic skeletal framework of the table.
	 */
	public GUI() {
		init();
	}
	
	/**
	 * Sets up the framework of the table. This includes the
	 * frame, and various components, panels, buttons, etc.
	 * All user response is handled and delegated to the
	 * Table class.
	 * Also sets up game state (initially at start state).
	 */
	private void init() {
		
	}
}
