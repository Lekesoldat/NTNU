package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistrationFormApp extends Application {
  @Override
  public void start(final Stage primaryStage) throws Exception {
    Scene scene = new ScreenManager()
      .add("registration_form", RegistrationFormApp.class.getResource("registration_form.fxml"))
      .add("Chess", RegistrationFormApp.class.getResource("Chess.fxml"))
      .activate("registration_form")
      .getScene();
    
    primaryStage.setTitle("Sleep Tracker v1.0");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(final String[] args) {
    RegistrationFormApp.launch(args);
  }
}