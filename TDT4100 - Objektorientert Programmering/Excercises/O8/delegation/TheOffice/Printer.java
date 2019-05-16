package TheOffice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {
  private Map<Employee, Collection<String>> printHistory = new HashMap<>();

  public void printDocument(String document, Employee employee) {
    System.out.println("Document:\n" + document);

    if (!printHistory.containsKey(employee)) {
      printHistory.put(employee, new ArrayList<String>());
    }

    this.printHistory.get(employee).add(document);
  }

  public List<String> getPrintHistory(Employee employee) {
    if (!printHistory.containsKey(employee)) {
      return Collections.emptyList();
    }

    return new ArrayList<>(printHistory.get(employee));
  }
}