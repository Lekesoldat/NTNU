package app;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class WriteToFileTest extends junit.framework.TestCase {
  EntryManager man = new EntryManager();

  LocalDate dStart = LocalDate.of(2019, 03, 14);
  String tStart = "02:00";
  LocalDate dEnd = LocalDate.of(2019, 03, 14);
  String tEnd = "09:45";

  LocalDateTime start = dStart.atTime(02, 00);
  LocalDateTime end = dEnd.atTime(9, 45);
  SleepEntry entry = new SleepEntry(dStart, tStart, dEnd, tEnd);

  public void testWriteToFile() {
    man.addEntry(entry);

    try {
      man.writeFile(new File("./testing.txt"));
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  public void testReadFromFile() {
    try {
      man.readFile(new File("./testing.txt"));
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }
}