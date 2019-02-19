/* 
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
*/
package encapsulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardDeck {
  List<Card> deck = new ArrayList();
  
  public CardDeck(int n) {
    // Initialize the deck.
    for (int i = 1; i < n + 1; i++) {
      deck.add(new Card('S', i));
    }
    
    for (int i = 1; i < n + 1; i++) {
      deck.add(new Card('H', i));
    }
    
    for (int i = 1; i < n + 1; i++) {
      deck.add(new Card('D', i));
    }
    
    for (int i = 1; i < n + 1; i++) {
      deck.add(new Card('C', i));
    }
  }
  
  public int getCardCount() {
    return this.deck.size();
  }
  
  public Card getCard(int n) {
    if (n < 0 || n > this.deck.size()) {
      throw new IllegalArgumentException("Card not in range.");
    } else {
      return this.deck.get(n);
    }
  }
  
  public void shufflePerfectly() {
    Card[] newArray = new Card[this.deck.size()];
    for (int i = 0; i < this.deck.size() / 2; i++) {
      // Ganger med 2 og legger til 1 for annenhver gang
      
      // Forfra
      newArray[i * 2] = this.deck.get(i);
      
      // Fra bak midten
      newArray[i * 2 + 1] = this.deck.get(this.deck.size() / 2 + i);
    }
    
    this.deck = Arrays.asList(newArray);
  }
  
  public static void main(String[] args) {
    CardDeck cd = new CardDeck(13);
    System.out.println(cd.deck.toString());
    
    System.out.println(cd.getCard(51));
  }
}
