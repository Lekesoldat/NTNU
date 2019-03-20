package app;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SleepEntryTest extends junit.framework.TestCase {
  LocalDate dStart = LocalDate.of(2019, 03, 14);
  String tStart = "02:00";
  LocalDate dEnd = LocalDate.of(2019, 03, 14);
  String tEnd = "09:45";

  LocalDateTime start = dStart.atTime(02, 00);
  LocalDateTime end = dEnd.atTime(9, 45);
  SleepEntry entry = new SleepEntry(dStart, tStart, dEnd, tEnd);

  public void testTimeSlept() {
    assertEquals(465.0, entry.getTimeSlept());
  }

  public void testGetStart() {
    assertEquals(start, entry.getStart());
  }

  public void testGetEnd() {
    assertEquals(end, entry.getEnd());
  }

  public void testCreateLocalDateTime() {
    assertEquals(start, entry.createLocalDateTime(dStart, tStart));
    assertEquals(end, entry.createLocalDateTime(dEnd, tEnd));
  }
}