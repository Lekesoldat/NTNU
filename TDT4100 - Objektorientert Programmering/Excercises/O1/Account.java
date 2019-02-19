/* 
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
*/
package stateandbehavior;

public class Account {
  // Instance variables
  private double balance;
  private double interestRate;
  
  // Public Methods
  public void deposit(double in) {
    if (in >= 0) {
      this.balance += in;      
    }
  }
  
  public void addInterest() {
    this.balance += this.balance * this.interestRate / 100;
  }
  
  public double getBalance() {
    return this.balance;
  }
  
  public double getInterestRate() {
    return this.interestRate;
  }

  public void setInterestRate(double rate) {
    this.interestRate = rate;
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Balance: " + this.balance + "\n");
    sb.append("Interest rate: " + this.interestRate + "\n");
    
    return sb.toString();
  }
  
  public static void main(String [] args) {
    Account a = new Account();
    a.deposit(100);
    a.setInterestRate(5);
    a.addInterest();
    a.getBalance();
    
    System.out.println(a);
  }
}
