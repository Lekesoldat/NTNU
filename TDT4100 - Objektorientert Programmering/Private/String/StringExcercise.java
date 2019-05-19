public class StringExcercise {
  public static void main(String[] args) {
    // 1. Write a Java program to get the character at the given index within the String.
    String string1 = "Java Exercises!";
    System.out.println(String.format(
        "1: %s\nThe character at position 0 is: %s",
        string1,
        string1.charAt(0)
    ));

    System.out.println();

    // 2. Write a Java program to get the character (Unicode code point) at the given index within the String. 
    String string2 = "w3resource.com";
    System.out.println(
      String.format(
        "2: %s\nCharacter (unicode point) at 0 = %s",
        string2,
        string2.codePointAt(0)
    ));

    System.out.println();
    
    // 3. Write a Java program to get the character (Unicode code point) before the specified index within the String.
    String string3 = "w3resource.com";
    System.out.println(
      String.format(
        "3: %s\nCharacter (unicode point) before 1 = %s",
        string3,
        string3.codePointBefore(1)
    ));

    System.out.println();

    // 4. Write a java program to count a number of Unicode code points in the specified text range of a String.
    String string4 = "w3rsource.com";
    System.out.println(
      String.format(
        "4: %s\nCodepoint count from 0 to end = %d",
        string4,
        string4.codePointCount(0, string4.length())
    ));

    System.out.println();

    // 5. Write a java program to compare two strings lexicographically.
    String comp1 = "This is Exercise 1";
    String comp2 = "This is Exercise 2";
    System.out.println("5: " + comp1 + " is " + ((comp1.compareTo(comp2) > 0) ? "greater" : "less") + " than " + comp2);

    System.out.println();

    // 6. Write a java program to compare two strings lexicographically, ignoring case differences.
    String comp3 = "This is exercise 1";
    String comp4 = "This is Exercise 1";
    System.out.println("6: " + comp3 + " is " + ((comp3.compareToIgnoreCase(comp4) == 0) ? "equal" : "not equal") + " to " + comp4);

    System.out.println();

    // 7. Write a Java program to concatenate a given string to the end of another string.
    String string7 = "PHP Exercises and";
    String string8 = "Python Exercises";
    System.out.println("8: " + string7 + " " + string8);

    System.out.println();

    // 8. Write a Java program to test if a given string contains the specified sequence of char values.
    String string9 = "PHP Exercises and Python Exercises";
    System.out.println(String.format("8: %s contains 'and' -> %s", string9, string9.contains("and")));
  }
}