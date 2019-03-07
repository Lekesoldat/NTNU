package patterns.delegation;

import java.io.OutputStream;
import java.io.PrintStream;

public class StreamLogger implements ILogger {
  private PrintStream stream;
  private String formatString = "%s: %s (%s)";

  public StreamLogger(OutputStream stream) {
    this.stream = new PrintStream(stream, true);
  }

  public void setFormatString(String formatString) {
    this.formatString = formatString;
  }

  @Override
  public void log(String severity, String message, Exception exception) {
    stream.format(formatString, severity, message, exception);
    stream.println();
  }
}