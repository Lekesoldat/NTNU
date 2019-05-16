import java.util.Collection;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {
  Collection<Card> deck = new ArrayList<>();

  public Deck() {
    for (int i = 1; i < 14; i++) {
      deck.add(new Card('H', i));
    }

    for (int i = 1; i < 14; i++) {
      deck.add(new Card('S', i));
    }

    for (int i = 1; i < 14; i++) {
      deck.add(new Card('D', i));
    }

    for (int i = 1; i < 14; i++) {
      deck.add(new Card('C', i));
    }
  }

  public void taskOne() {
    System.out.println(deck.stream().filter(c -> (c.getSuit() == 'S')).map(c -> c.toString()).collect(Collectors.joining(", ")));
  }

  public List<Card> taskTwo() {
    return deck.stream().filter(c -> (c.getSuit() == 'H')).collect(Collectors.toList());
  }

  public List<Character> taskThree() {
    return deck.stream().map(Card::getSuit).collect(Collectors.toList());
  }

  public int taskFour() {
    return deck.stream().mapToInt(Card::getFace).reduce(0, (prev, curr) -> prev + curr);
  }

  public boolean taskFive() {
    return deck.stream().anyMatch(c -> (c.getSuit() == 'S' && c.getFace() == 12));
  }

  public boolean taskSix() {
    Collection<Card> flushHand = Arrays.asList(new Card('S', 1), new Card('S', 2), new Card('S', 3), new Card('S', 4), new Card('S', 5));
    return flushHand.stream().map(x -> x.getSuit()).distinct().count() == 1;
  }

  public boolean taskSeven() {
    return deck.stream().map(x->x.getSuit()).distinct().count() == 4;
  }

  public static void main(String[] args) {
    Deck deck = new Deck();

    // Task 1
    System.out.println("All spades: ");
    deck.taskOne();

    // Task 2
    System.out.println("\nAll hearts: " + deck.taskTwo());

    // Task 3
    System.out.println("\nAll card suits: " + deck.taskThree());

    // Task 4
    System.out.println("\nDeck summed: " + deck.taskFour());

    // Task 5
    System.out.println("\nQueen of Spades exists: " + deck.taskFive());

    // Task 6
    System.out.println("\nFlush hand: " + deck.taskSix());

    // Task 7
    System.out.println("\nAll colors represented: " + deck.taskSeven());
  }
}