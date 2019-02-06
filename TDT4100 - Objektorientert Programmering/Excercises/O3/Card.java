/* 
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
*/
package encapsulation;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Card {
	private char suit;
	private int face;
	
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
}
