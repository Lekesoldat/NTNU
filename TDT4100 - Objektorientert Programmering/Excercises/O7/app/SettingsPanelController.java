package app;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SettingsPanelController extends ScreenController<EntryManager> {
  @FXML
  private Button loadFileButton;

  @FXML
  private Button storeButton;

  @FXML
  protected void handleLoadDataButtonAction(ActionEvent evt) {
    try {
      data.readFile(new File("./entries.txt"));
      screenManager.navigate("registration_form", data);
    } catch (IOException e) {
      System.out.println("Failed to read from file.");
    }
  }

  @FXML
  protected void handleStoreDataButtonAction(ActionEvent evt) {
    try {
      data.writeFile(new File("./entries.txt"));
      screenManager.navigate("registration_form", data);
    } catch (IOException e) {
      System.out.println("Failed to write to file.");
    }
  }
}
