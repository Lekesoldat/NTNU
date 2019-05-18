package app;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class ScreenManager {
	private HashMap<String, Pane> screenMap = new HashMap<>();
  private Group group = new Group();
  private Scene scene = new Scene(group);
  
  public ScreenManager add(String name, URL resource) throws IOException {
    FXMLLoader loader = new FXMLLoader(resource);
    Pane screen = loader.load();
    ScreenController controller = loader.getController();
    controller.setScreenManager(this);
    screenMap.put(name, screen);
    
    return this;
  }

  public ScreenManager removeScreen(String name) {
    screenMap.remove(name);
    return this;
  }

  public ScreenManager activate(String name) {
    ObservableList<Node> children = group.getChildren();
    children.clear();
    children.add(screenMap.get(name));
    return this;
  }
  
  public Scene getScene() {
    return scene;
  }
}
