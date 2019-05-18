package patterns.delegation;

import java.util.HashMap;
import java.util.Map;

public class DistributingLogger implements ILogger {
  private Map<String, ILogger> loggers;

  public DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger) {
    this.loggers = new HashMap<String, ILogger>();

    loggers.put(ILogger.ERROR, errorLogger);
    loggers.put(ILogger.WARNING, warningLogger);
    loggers.put(ILogger.INFO, infoLogger);
  }

  public void setLogger(String severity, ILogger logger) {
    loggers.put(severity, logger);
  }

  @Override
  public void log(String severity, String message, Exception exception) {
    ILogger logger = loggers.get(severity);

    if (logger != null) {
      logger.log(severity, message, exception);
    }
  }
}