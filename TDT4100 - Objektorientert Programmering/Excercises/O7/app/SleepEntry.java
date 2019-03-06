package app;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SleepEntry {
  private LocalDateTime start;
  private LocalDateTime end;
  private double timeSlept;

  public SleepEntry(LocalDate dStart, String tStart, LocalDate dEnd, String tEnd) {
    this.start = createLocalDateTime(dStart, tStart);
    this.end = createLocalDateTime(dEnd, tEnd);

    if (!start.isBefore(end)) {
      throw new IllegalArgumentException("End has to be before start.");
    }

    this.timeSlept = Duration.between(start, end).toMinutes();
  }

  public SleepEntry(LocalDateTime start, LocalDateTime end, double timeSlept) {
    this.start = start;
    this.end = end;
    this.timeSlept = timeSlept;
  }

  public LocalDateTime getEnd() {
    return end;
  }

  public LocalDateTime getStart() {
    return start;
  }

  public double getTimeSlept() {
    return timeSlept;
  }

  public LocalDateTime createLocalDateTime(LocalDate d, String hhmm) {
    if (validateDate(d) == null || validateTimestamp(hhmm) == null) {
      throw new IllegalArgumentException("Invalid inputs");
    }

    String[] parts = this.validateTimestamp(hhmm).split(":");
    return d.atTime(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
  }

  private LocalDate validateDate(LocalDate d) {
    if (!d.toString().matches("\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])")) {
      return null;
    }

    return d;
  }

  private String validateTimestamp(String hhmm) {
    if (!hhmm.matches("(2[0-3]|[01][0-9]):[0-5][0-9]")) {
      return null;
    }

    return hhmm;
  }

  private String localDateTimeToString(LocalDateTime localDateTime) {
    return String.format(
      "%s/%s/%s %02d:%02d",
      localDateTime.getDayOfMonth(),
      localDateTime.getMonthValue(),
      localDateTime.getYear(),
      localDateTime.getHour(),
      localDateTime.getMinute()
    );
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append(String.format("Start: \t %s \n", localDateTimeToString(start)))
      .append(String.format("End: \t %s \n", localDateTimeToString(end)))
      .append(String.format("Total hours slept: %.2f", this.timeSlept/60))
      .toString();
  }
}
