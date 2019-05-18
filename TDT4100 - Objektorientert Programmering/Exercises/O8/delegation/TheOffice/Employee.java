package TheOffice;

import java.util.function.BinaryOperator;

public interface Employee {
  double doCalculations(BinaryOperator<Double> operation, double value1, double value2);
  void printDocument(String document);
  int getTaskCount();
  int getResourceCount(); 
}