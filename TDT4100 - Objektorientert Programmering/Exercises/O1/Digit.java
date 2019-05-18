package stateandbehavior;

public class Digit {
  private int base, value;

  public Digit(int base) {
    this.base = base;
    this.value = 0;
  }

  public int getValue() {
    return this.value;
  }

	public boolean increment() {
		value += 1;
		if (value == base) {
			value = 0;
			return true;
		}
		return false;
	}

  public int getBase() {
    return this.base;
  }

  @Override
  public String toString() {
    return String.valueOf("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(value));
  }

  public static void main(String[] args) {
    Digit digit = new Digit(16);
    
    for (int i = 0; i < 11; i++) {
      System.out.println(digit);
      digit.increment();
    }
  }
}