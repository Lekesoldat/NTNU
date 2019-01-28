/* 
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
*/
package stateandbehavior;

public class Location {
	// Instance variables
	private int x;
	private int y;
	
	public Location() {
		
	}
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Public methods
	public void up() {
		this.y -= 1;
	}

	public void down() {
		this.y += 1;
	}
	
	public void left() {
		this.x -= 1;
	}
	
	public void right() {
		this.x += 1;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	@Override
	public String toString() {
		return String.format("(%d, %d)", this.x, this.y);
	}
	
	public static void main(String[] args) {
		Location coord = new Location(10, 10);
		coord.down();
		coord.right();
		coord.up();
		coord.left();
		
		System.out.println(coord);
	}
}
