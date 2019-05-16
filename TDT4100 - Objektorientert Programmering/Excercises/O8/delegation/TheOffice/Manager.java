package TheOffice;

import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
  private List<Employee> employees;
  private int taskCount = 0;

  public Manager(List<Employee> employees) {
    if (employees.isEmpty()) {
      throw new IllegalArgumentException("Must have employees.");
    } 
    this.employees = employees;
  }

  public Employee getSuitedEmployee() {
    return employees.get(taskCount++ % employees.size());
  }

  @Override
  public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
    return this.getSuitedEmployee().doCalculations(operation, value1, value2);
  }

  @Override
  public void printDocument(String document) {
    this.getSuitedEmployee().printDocument(document);
  }

  @Override
  public int getTaskCount() {
    return this.taskCount;
  }

  @Override
  public int getResourceCount() {
    return employees.stream().mapToInt(Employee::getResourceCount).reduce(1, Integer::sum);
  }
}