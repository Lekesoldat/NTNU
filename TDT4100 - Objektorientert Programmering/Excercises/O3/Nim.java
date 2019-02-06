/* 
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
*/
package encapsulation;

import java.util.ArrayList;
import java.util.List;

public class Nim {	
	private List<Integer> piles;
	
	public Nim(int size) {
		this.piles = new ArrayList<Integer>() {{
			add(size);
			add(size);
			add(size);
		}};
	}
	
	public void removePieces(int number, int targetPile) {
		if (isGameOver()) {
			throw new IllegalStateException("The game is over.");
		}
		
		// Not smooth at all
		if (isValidMove(number, targetPile)) {
			this.piles.set(targetPile, this.piles.get(targetPile) - number);
		} else {
			throw new IllegalArgumentException("Not av alid move.");
		}
	}
	
	public boolean isValidMove(int number, int targetPile) {
		boolean valid = true;
		
		if (isGameOver()) {
			valid = false;
		}
				
		// Check valid pile.
		if (!(targetPile >= 0 && targetPile < this.piles.size())) {
			valid = false;
		}
		
		// Check valid remove
		if (!(number <= this.piles.get(targetPile)) || number < 1) {
			valid = false;
		}
		
		return valid;
	}
	
	public boolean isGameOver() {
		return this.piles.stream().anyMatch(p -> p == 0);
	}
	
	public int getPile(int targetPile) {
		if ((targetPile >= 0 && targetPile < this.piles.size())) {
			return this.piles.get(targetPile);
		} else {
			throw new IllegalArgumentException("Not a valid pile.");
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Piles: " + this.piles.toString());
		return sb.toString();
	}

	public static void main(String[] args) {
		Nim nim = new Nim(5);
		
		nim.removePieces(4, 2);
		System.out.println(nim.piles.toString());
	}
}