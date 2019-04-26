package ExpenseTracker;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import org.sk.PrettyTable;

public class ExpenseManager {
  private Collection<Expense> expenses = new ArrayList<>();

  public void addExpense(Expense e) {
    if (e == null) {
      throw new IllegalArgumentException("Expense cannot be null");
    }

    expenses.add(e);
  }

  public void removeExpense(Expense e) {
    expenses.removeIf(x -> (x.getExpenseID() == e.getExpenseID()));
  }

  public void removeExpense(int id) {
    expenses.removeIf(x -> x.getExpenseID() == id);
  }

  public Collection<Expense> getExpenses() {
    return expenses;
  }

  public void writeToFile(File file) {
    try (PrintWriter pw = new PrintWriter(file)) {
      expenses.forEach(x -> pw.println(
        String.format(
          "%d,%s,%s,%s",
          x.getExpenseID(),
          x.getTitle(),
          x.getPriceAsString(),
          x.getDescription()
        ))
      );
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  public void readFile(File file) {
    try (Scanner sc = new Scanner(file)) {
      expenses.clear();
      sc.useDelimiter(",|\n");
      while (sc.hasNext()) {
        // Skip ID
        sc.next();
        expenses.add(new Expense(sc.next(), Double.parseDouble(sc.next()), sc.next()));
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  public PrettyTable showData() {
    PrettyTable pt = new PrettyTable("ID", "Title", "Price", "Description");
    expenses.forEach(
      x -> pt.addRow(String.valueOf(x.getExpenseID()), x.getTitle(), x.getPriceAsString() + " kr", x.getDescription())
    );

    Double total = expenses.stream().mapToDouble(Expense::getPrice).sum();
    pt.addRow("", "","","");
    
    pt.addRow("Total", "", "", total.toString() + "kr");

    return pt;
  }
}