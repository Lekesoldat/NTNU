package patterns.delegation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class FilteringLogger implements ILogger {

  private Collection<String> severities;
  private ILogger logger;

  public FilteringLogger(ILogger logger, String... severities) {
    this.severities = new ArrayList<String>(Arrays.asList(severities));
    this.logger = logger;
  }

  public boolean isLogging(String severity) {
    return severities.contains(severity);
  }

  public void setIsLogging(String severity, boolean value) {
    // If not logging
		if (! value) {
      severities.remove(severity);
    
    // If logging and not already logging
		} else if (! isLogging(severity)) {
			severities.add(severity);
		}
  }

  @Override
  public void log(String severity, String message, Exception exception) {
    if (isLogging(severity)) {
      logger.log(severity, message, exception);
    }
  }
}