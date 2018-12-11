import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class that sets up the graphical representation of the game.
 * 
 * @author Carrie
 */
public abstract class GUI {
	// ABSTRACT METHODS:
	/** Renders the container based on the game state. */
	//public abstract void renderStart(Graphics g);
	public abstract void renderStart();
	public abstract void render();
	public abstract void renderEnd();
	
	// Constants
	protected static final int FRAME_SIZE = 800;
	protected static final int CANVAS_SIZE = 600;
	
	// JSwing fields
	protected JFrame frame;
	protected JPanel container;
	protected JComponent canvas;
	protected Graphics2D drawingArea;
	
	
	// Game related fields
	protected State currentState;
	protected Game game;

	/** Sets up the basic skeletal framework of the table. */
	public GUI() {
		frame = new JFrame("SNAP");
		container = new JPanel();
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
		currentState = State.START;
		canvas = new JComponent() {
			// assign the graphics object first, so it's accessible
			@Override
			public void paintComponent(Graphics g) {
				System.out.println("graphics assigned");
				drawingArea = (Graphics2D) g;
				
			}
		};
		renderStart();
		/*canvas.setPreferredSize(
				new Dimension(CANVAS_SIZE, CANVAS_SIZE));*/
		//container.add(canvas);
		container.setBorder(BorderFactory	// spacing between container and frame
				.createEmptyBorder(25, 10, 10, 10));
		container.setVisible(true);
		
		frame.setPreferredSize(new Dimension(FRAME_SIZE, FRAME_SIZE));
		
		frame.add(container);
		
		frame.pack();
		frame.setVisible(true);
	}

}
