package patterns.observable;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableList {
  private List<Object> list = new ArrayList<>();
  private List<ObservableListListener> listeners = new ArrayList<>();

  public abstract boolean acceptsElement(Object obj);
  
  private void validIndex(int pos, int d) {
    if (pos < 0 || pos + d > list.size()) {
      throw new IndexOutOfBoundsException(pos + " is not in range.");
    }
  }

  protected Object getElement(int n) {
    return list.get(n);
  }

  protected void addElement(int pos, Object obj) {
    if (!acceptsElement(obj)) {
      throw new IllegalArgumentException(obj + " is not a valid argument");
    }

    validIndex(pos, 0);
    list.add(pos, obj);
    notifyListeners(pos);
  }

  protected void addElement(Object element) {
		addElement(list.size(), element);
	}

  protected void removeElement(int pos) {
		validIndex(pos, 1);
		list.remove(pos);
		notifyListeners(pos);
	}

  protected void notifyListeners(int pos) {
    for (ObservableListListener listener : listeners) {
      listener.listChanged(this, pos);
    }
  }

  public int size() {
    return list.size();
  }

  public void addObservableListListener(ObservableListListener listListener) {
		if (!listeners.contains(listListener)) {
			listeners.add(listListener);
		}
  }
  
  public void removeObservableListListener(ObservableListListener listListener) {
		listeners.remove(listListener);
	}
}