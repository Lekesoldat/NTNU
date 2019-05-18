/* 
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
*/
package encapsulation;

public class Account {
  private double balance;
  private double interestRate;
  
  public Account(double b, double i) {
    if(b < 0 || i < 0) {
      throw new IllegalArgumentException("Cannot be negative");
    }
    this.balance = b;
    this.interestRate = i;
  }
  
  public double getBalance() {
    return this.balance;
  }
  
  public double getInterestRate() {
    return this.interestRate;
  }
  
  public void setInterestRate(double i) {
    if (i < 0) {
      throw new IllegalArgumentException("Interest rate cannot be negative.");
    }
    this.interestRate = i;
  }
  
  public void deposit(double in) {
    if (in < 0) {
      throw new IllegalArgumentException("Deposit must be positive.");
    }
    this.balance += in;
  }
  
  public void withdraw(double out) {
    if (this.balance - out < 0 || out < 0) {
      throw new IllegalArgumentException("Invalid input");
    }
    this.balance -= out;
  }
  
  public void addInterest() {
    this.balance += this.balance * this.getInterestRate() / 100;
  }
}
