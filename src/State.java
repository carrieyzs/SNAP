
/**
 * Using enum to control game state.
 * 
 * @author Carrie
 */
public enum State {
	
	/**
	 * If the game is in the start state, next state is PLAY.
	 */
	START {
		@Override
		public State transition(Game g) {
			// necessary game modifications
			return PLAY;
		}
	}, 
	/**
	 * If the game is in play state, the next state is END.
	 */
	PLAY {
		@Override
		public State transition(Game g) {
			// necessary game modifications
			return END;
		}
	}, 
	/**
	 * If game is in end state, next state is START.
	 */
	END {
		@Override
		public State transition(Game g) {
			// necessary game modifications
			return START;
		}
	};
	
	/**
	 * Abstract method to transition state. Depending on the current
	 * state, the game will change depending on the next state.
	 * @param g
	 * @return
	 */
	public abstract State transition(Game g);
}
