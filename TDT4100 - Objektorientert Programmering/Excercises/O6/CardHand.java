package interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardHand implements CardContainer {
	private List<Card> hand = new ArrayList<Card>();

	@Override
	public Card getCard(int pos) {
		if (pos < 0 || pos > this.hand.size()) {
			throw new IllegalArgumentException("Card not in range.");
		} else {
			return this.hand.get(pos);
		}
	}
	
	@Override
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
	}

	@Override
	public int getCardCount() {
		return this.hand.size();
	}

	public void addCard(Card c) {
		this.hand.add(c);
	}

	public Card play(int n) {
		Card tmp = this.getCard(n);
		this.hand.remove(n);

		return tmp;
	}
}
