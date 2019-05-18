/* 
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
*/
package stateandbehavior;

public class UpOrDownCounter {
  private int counter;
  private int end;
  private boolean up;
  
  
  public UpOrDownCounter(int start, int end) {
    if (start == end) {
      throw new IllegalArgumentException("Start and end cannot be the same.");
    }
    
    if (start < end) {
      this.up = true;
    }
    
    this.counter = start;
    this.end = end;
  }
  
  public int getCounter() {
    return this.counter;
  }
  
  public boolean count() {
    if (this.counter < this.end) {
      this.counter++;
    } else if (this.counter > this.end) {
      this.counter--;
    }
    
    return !(this.counter == this.end);
  }
  
  public static void main(String[] args) {
    UpOrDownCounter counter = new UpOrDownCounter(5, 3);
    System.out.println(counter.getCounter());
    System.out.println(counter.count());
    
    System.out.println(counter.getCounter());
    System.out.println(counter.count());
    
    System.out.println(counter.getCounter());
    System.out.println(counter.count());
    
    System.out.println(counter.getCounter());
    System.out.println(counter.count());
    
    System.out.println(counter.getCounter());
    System.out.println(counter.count());
    
    System.out.println(counter.getCounter());
  }
}
