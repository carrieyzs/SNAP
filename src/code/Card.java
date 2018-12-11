package code;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A Card consists of a Suit and a Rank. 
 * This class overrides Object's equals method, as well as provides
 * its own natural ordering.
 * 
 * @author Carrie
 */
public class Card implements Comparable<Card>{
	
	/**
	 * Rank of the cards in ascending order.
	 */
	public enum Rank{
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
		KING,
		ACE;
	}
	
	/**
	 * Suit of the cards, by convention, in ascending order.
	 */
	public enum Suit{
		CLUBS,
		DIAMONDS,
		HEARTS,
		SPADES;
	}
	
	//================================================================================

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
	public static List<Card> getDeck(){
		List<Card> list = new ArrayList<Card>();
		
		// get suit and rank of every card, and add to the list
		for (Suit s: Suit.values()) {
			for (Rank r: Rank.values()) {
				list.add(new Card(s, r));
			}
		}
		
		Collections.shuffle(list);
		return list;
	}
	
	/**
	 * Overrides Object's equals method. A card is equal to another
	 * card, essentially, if their suits and ranks are the same.
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;
		if (o.getClass() != getClass()) return false;
		
		Card other = (Card) o;
		if (other.hashCode() != hashCode()) return false;
		
		return ((other.suit.equals(suit)) && (other.rank.equals(rank)));
	}
	
	/**
	 * Based on Java's object contract, overriding Object.equals() 
	 * means that Object.hashCode() must also be overridden.
	 */
	@Override
	public int hashCode() {
		int result = 1;
		
		result = 31 * result + rank.hashCode();
		result = 31 * result + suit.hashCode();
		
		return result;
	}

	/**
	 * Typically, a card is compared to another based on both suit 
	 * and rank. But in this case, we customize it so that just the
	 * rank of the cards are comparable. We compare them in the 
	 * position that they appear in the Rank enum, which orders them
	 * in ascending order.
	 * @param
	 * 		card to compare this card with
	 * @return
	 * 		1 - if this card is greater than argument, 
	 * 		0 - if this card equal to argument, 
	 * 		-1 - if this card is less than argument
	 */
	@Override
	public int compareTo(Card o) {
		if (rank.ordinal() < o.rank.ordinal()) 
			return -1;
		else if (rank.ordinal() == o.rank.ordinal()) 
			return 0;
		
		return 1;
	}
}
