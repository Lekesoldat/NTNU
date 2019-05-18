package interfaces;

import java.util.Comparator;

/**
 * NamedComparator
 */
public class NamedComparator implements Comparator<Named> {

  @Override
  public int compare(Named n1, Named n2) {
    if (!n1.getFamilyName().equals(n2.getFamilyName())) {
      return n1.getFamilyName().compareTo(n2.getFamilyName());
    }

    return n1.getGivenName().compareTo(n2.getGivenName());
  } 
}