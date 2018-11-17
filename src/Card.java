
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
		HEART,
		SPADE,
		DIAMOND,
		CLUB;
	}

	public final Suit suit;
	public final Rank rank;
	
	public Card(Suit s, Rank r) {
		suit = s;
		rank = r;
	}
	
	/**
	 * Method to get a full deck of cards, already shuffled!
	 * @return
	 */
	public static CyclicList<Card> getDeck(){
		CyclicList<Card> list = new CyclicList<Card>();
		
		// get suit and rank of every card, and add to the list
		for (Suit s: Suit.values()) {
			for (Rank r: Rank.values()) {
				list.add(new Card(s, r));
			}
		}
		
		list.shuffle();
		return list;
	}
}
