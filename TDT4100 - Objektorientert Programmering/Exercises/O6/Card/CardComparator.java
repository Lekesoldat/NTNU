package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CardComparator implements Comparator<Card> {
  private boolean essStorst;
  private char trumf;

  public CardComparator(boolean essStorst, char trumf) {
    this.essStorst = essStorst;
    this.trumf = trumf;
  }

  @Override
  public int compare(Card c1, Card c2) {
    // Om en er trumf og den andre ikke -> returner trumf
    if (c1.getSuit() == trumf && c2.getSuit() != trumf) {
      return -1;
    } else if (c2.getSuit() == trumf && c1.getSuit() != trumf) {
      return 1;
    }
    // Ingen trumffordel -> sjekk tall
    if (c1.getSuit() == c2.getSuit() && essStorst) {
      // Dersom den ene er ess og andre ikke -> returner ess
      if (c1.getFace() == 1 && c2.getFace() != 1) {
        return 1;
      } else if (c2.getFace() == 1 && c1.getFace() != 1) {
        return -1;
      } else {
        return c1.compareTo(c2);
      }
    }

    // Vanlig sammenligning
    return c1.compareTo(c2);
  }

  public static void main(String[] args) {
    List<Card> l = new ArrayList<>();
		l.add(new Card('H', 10));
		l.add(new Card('S', 1));
    l.add(new Card('D', 13));
    l.add(new Card('D', 1));
    l.add(new Card('D', 4));
    l.add(new Card('D', 6));
    l.add(new Card('C', 3));
    
    Collections.sort(l, new CardComparator(true, 'D'));

    System.out.println(l);
  }
}
