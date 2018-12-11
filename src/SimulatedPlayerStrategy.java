import java.util.ArrayList;
import java.util.List;

public class SimulatedPlayerStrategy implements PlayerStrategy {
	private String name;
	private List<Card> hand;
	
	public SimulatedPlayerStrategy(String name) {
		this.name = name;
		hand = new ArrayList<Card>();
	}

	@Override
	public void playCard(Table t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasMatch() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPlayerHand(Card c) {
		hand.add(c);
	}
}
