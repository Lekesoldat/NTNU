package app;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntryManager implements FileManager {
  List<SleepEntry> entries;

  public EntryManager() {
    this.entries = new ArrayList<SleepEntry>();
  }

  public void addEntry(SleepEntry e) {
    this.entries.add(e);
  }

  public List<SleepEntry> getEntries() {
    return this.entries;
  }

  public void listEntries() {
    entries.forEach(System.out::println);
  }

  @Override
  public void readFile(File file) throws IOException {
    try (Scanner scanner = new Scanner(file)) {
      entries.clear();

      while (scanner.hasNext()) {
        LocalDateTime startDate = LocalDateTime.parse(scanner.next());
        LocalDateTime endDate = LocalDateTime.parse(scanner.next());
        double timeSlept = scanner.nextDouble();
        entries.add(new SleepEntry(startDate, endDate, timeSlept));
      }
    }
  }

  @Override
  public void writeFile(File file) throws IOException {
    try (PrintWriter printWriter = new PrintWriter(file)) {
      for (SleepEntry entry : entries) {
        printWriter.println(
          String.format(
            "%s %s %f",
            entry.getStart().toString(),
            entry.getEnd().toString(),
            entry.getTimeSlept()
          )
        );
      }
    }
  }
}
