package app;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ScreenManager {
  private HashMap<String, Screen<?>> screenMap = new HashMap<>();
  private Stage stage;

  public ScreenManager(Stage stage) {
    this.stage = stage;
  }

  public ScreenManager add(String name, URL resource) throws IOException {
    FXMLLoader loader = new FXMLLoader(resource);
    Pane pane = loader.load();
    ScreenController<?> controller = loader.getController();
    controller.setScreenManager(this);
    Screen<?> screen = new Screen<>(new Scene(pane), controller);
    screenMap.put(name, screen);
    return this;
  }

  public ScreenManager removeScreen(String name) {
    screenMap.remove(name);
    return this;
  }

  public ScreenManager navigate(String name) {
    Screen<?> screen = screenMap.get(name);
    stage.setScene(screen.getScene());
    return this;
  }

  @SuppressWarnings("unchecked")
  public <T> ScreenManager navigate(String name, T data) {
    Screen<T> screen = (Screen<T>)screenMap.get(name);
    stage.setScene(screen.getScene());
    screen.getController().setData(data);
    return this;
  }
}
