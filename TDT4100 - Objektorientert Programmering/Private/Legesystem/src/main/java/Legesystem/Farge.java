package Legesystem;

/**
 * For å printe med farger
 */
public class Farge {
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_BLACK = "\u001B[30m";
  private static final String ANSI_RED = "\u001B[31m";
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_YELLOW = "\u001B[33m";
  private static final String ANSI_BLUE = "\u001B[34m";
  private static final String ANSI_PURPLE = "\u001B[35m";
  private static final String ANSI_CYAN = "\u001B[36m";
  private static final String ANSI_WHITE = "\u001B[37m";

  public static String groenn(Object input) {
    return ANSI_GREEN + input.toString() + ANSI_RESET;
  }

  public static String rod(Object input) {
    return ANSI_RED + input.toString() + ANSI_RESET;
  }

  public static String gul(Object input) {
    return ANSI_YELLOW + input.toString() + ANSI_RESET;
  }

  public static String blaa(Object input) {
    return ANSI_BLUE + input.toString() + ANSI_RESET;
  }

  public static String hvit(Object input) {
    return ANSI_WHITE + input.toString() + ANSI_RESET;
  }
}