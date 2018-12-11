import java.util.ArrayList;

public interface PlayerStrategy {

	public void playCard(Table t);
	public boolean hasMatch();
//	public Rank getRank();
	public void addPlayerHand(ArrayList<Card> cards);
}
