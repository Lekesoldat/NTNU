package interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Card implements Comparable<Card> {
	private char suit;
	private int face;
	private static Map<Character, Integer> SUIT_RANK = new HashMap<>(){{

		// Switch order for CardComparator to work.....
    put('S', 1);
    put('H', 2);
    put('D', 3);
    put('C', 4);
	}};
	
	public Card(char suit, int face) {
		this.suit = validSuit(suit);
		this.face = validFace(face);
	}
	
	public int getFace() {
		return face;
	}
	
	public char getSuit() {
		return suit;
	}
	
	private char validSuit(char suit) {
		List<Character> suits = Arrays.asList('S', 'H', 'D', 'C');
		
		if (!suits.contains(suit)) {
			throw new IllegalArgumentException("That is not a suit.");
		} else {
			return suit;
		}
	}
	
	private int validFace(int number) {
		if (number < 1 || number > 13) {
			throw new IllegalArgumentException("Not a valid face.");
		} else {
			return number;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s%s", getSuit(), getFace());
	}

	@Override
	public int compareTo(Card otherCard) {
		int rank = SUIT_RANK.get(this.getSuit()) - SUIT_RANK.get(otherCard.getSuit());

		if (rank != 0) {
				return Math.max(-1, Math.min(1, rank));
		}

		return Integer.compare(getFace(), otherCard.getFace());
	}
	
	public static void main(String[] args) {
		// Skriv testkode som sorterer kort i en liste vha. Collections.sort og Comparable-logikken, så dere ser at det virker som forventet.
		List<Card> l = new ArrayList<>();
		l.add(new Card('H', 10));
		l.add(new Card('H', 13));
		l.add(new Card('S', 1));
		l.add(new Card('D', 13));
		l.add(new Card('C', 3));

		Collections.sort(l);

		System.out.println(l);
	}
}
