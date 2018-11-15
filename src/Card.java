
public class Card {
	
	public enum Rank{
		ACE,
		ONE,
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING;
	}
	
	public enum Suit{
		HEARTS,
		SPADES,
		DIAMONDS,
		CLUBS;
	}

	public final Suit suit;
	public final Rank rank;
	
	public Card(Suit s, Rank r) {
		suit = s;
		rank = r;
	}
}
