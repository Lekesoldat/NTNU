package patterns.observable;

/**
 * HighscoreListProgram
 */
public class HighscoreListProgram implements HighscoreListListener {

  @Override
  public void listChanged(HighscoreList list, int indexChanged) {
    System.out.println(String.format("List with index %d changed:\n" + list.getResults(), indexChanged));
  }

}