package app;

import javafx.scene.control.Alert;

public class AlertHelper {
  public static void showAlert(Alert.AlertType type, String title, String message) {
    Alert alert = new Alert(type);
    alert.setTitle(title);
    alert.setContentText(message);
    alert.show();
  }
}
