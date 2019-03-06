package app;

public abstract class ScreenController<T> {
  public ScreenManager screenManager;
  public T data;

  public void setScreenManager(ScreenManager screenManager) {
    this.screenManager = screenManager;
  }

  public void setData(T data) {
    this.data = data;
  }
}
