package patterns.observable;

/**
 * HighscoreListListener
 */
public interface HighscoreListListener {

  void listChanged(HighscoreList list, int indexChanged);
}