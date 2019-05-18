package TheOffice;

import java.util.function.BinaryOperator;

public class Clerk implements Employee {
  private Printer printer;
  private int taskCount = 0;

  public Clerk(Printer printer) {
    this.printer = printer;
  }

  @Override
  public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
    taskCount++;
    return operation.apply(value1, value2);
  }

  @Override
  public void printDocument(String document) {
    this.printer.printDocument(document, this);
  }

  @Override
  public int getTaskCount() {
    return this.printer.getPrintHistory(this).size() + this.taskCount;
  }

  @Override
  public int getResourceCount() {
    return 1;
  }
}