/* 
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
*/
package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistrationFormApp extends Application{

	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("Sleep Tracker v1.0");
		primaryStage.setScene(new Scene(FXMLLoader.load(RegistrationFormApp.class.getResource("registration_form.fxml"))));
		primaryStage.show();
	}

	public static void main(final String[] args) {
		RegistrationFormApp.launch(args);
	}
}