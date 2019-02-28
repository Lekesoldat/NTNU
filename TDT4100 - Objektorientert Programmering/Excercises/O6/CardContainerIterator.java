package interfaces;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card> {
  private CardContainer container;
  private int index;

  public CardContainerIterator(CardContainer c) {
    this.container = c;
  }

  @Override
  public boolean hasNext() {
    return index < container.getCardCount();
  }

  @Override
  public Card next() {
    return container.getCard(index++);
  }

  public static void main(String[] args) {
    CardContainerIterator it = new CardContainerIterator(new CardDeck(13)); 
  }
}