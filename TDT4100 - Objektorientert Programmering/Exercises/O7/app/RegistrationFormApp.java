package app;

import javafx.application.Application;
import javafx.stage.Stage;

public class RegistrationFormApp extends Application {
  @Override
  public void start(final Stage primaryStage) throws Exception {
    EntryManager man = new EntryManager();

    new ScreenManager(primaryStage)
      .add("registration_form", RegistrationFormApp.class.getResource("registration_form.fxml"))
      .add("settings_panel", RegistrationFormApp.class.getResource("settings_panel.fxml"))
      .navigate("registration_form", man);

    primaryStage.setTitle("Sleep Tracker v1.0");
    primaryStage.show();
  }

  public static void main(final String[] args) {
    RegistrationFormApp.launch(args);
  }
}
