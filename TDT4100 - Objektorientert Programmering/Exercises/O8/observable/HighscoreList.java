package patterns.observable;

import java.util.ArrayList;
import java.util.List;

/**
 * HighscoreList
 */
public class HighscoreList {
  private List<Integer> results;
  private List<HighscoreListListener> listeners;
  private int maxSize;

  public HighscoreList(int maxSize) {
    results = new ArrayList<Integer>(maxSize);
    listeners = new ArrayList<HighscoreListListener>();
    this.maxSize = maxSize;
  }

  public int size() {
    return results.size();
  }

  public int getElement(int result) {
    return results.get(result);
  }

  public void addResult(int newResult) {
    // Save index for notifier
    int indexChanged = 0;
    boolean added = false;
      
    // If the list is empty
    if (results.isEmpty()) {
      results.add(newResult);
      notify(this, indexChanged);
      return;
    }

    // Check if the element should be fit in the list
    for (int i = 0; i < results.size(); i++) {
      // If better score
      if (newResult < results.get(i)) {
        indexChanged = i;
        results.add(i, newResult);
        added = true;
        break;
      }
    }

    // If not fit in the list, append
    if (!added) {
      indexChanged = results.size();
      results.add(newResult);
    }

    // Too big list
    if (results.size() > this.maxSize) {
      results.remove(results.size() -1);
    }

    // When the index == size(), it is out of bounds
    if (indexChanged != results.size()) {
      notify(this, indexChanged);
    }
  }

  public void addHighscoreListListener(HighscoreListListener newListener) {
    this.listeners.add(newListener);
  }

  public void removeHighscoreListListener(HighscoreListListener listener) {
    this.listeners.remove(listener);
  }

  public List<Integer> getResults() {
    return results;
  }

  public List<HighscoreListListener> getListeners() {
    return listeners;
  }

  public void notify(HighscoreList l, int index) {
    for (HighscoreListListener listener : l.getListeners()) {
      listener.listChanged(l, index);
    }
  }

  public static void main(String[] args) {
    HighscoreList l = new HighscoreList(10);
    l.addHighscoreListListener(new HighscoreListProgram());

    // Syv resultater
    l.addResult(3);
    l.addResult(4);
    l.addResult(92);
    l.addResult(65);
    l.addResult(69);
    l.addResult(95);
  }
}