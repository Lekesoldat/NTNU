package app;

import java.util.List;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


public class RegistrationFormController {
	private EntryManager man = new EntryManager();
	
	@FXML
	private DatePicker dateStart;
	
	@FXML
	private TextField timeStart;
	
	@FXML
	private DatePicker dateEnd;
	
	@FXML
	private TextField timeEnd;
	
	@FXML
	private Button submitButton;
	
	@FXML
	protected void handleSubmitButtonAction(ActionEvent evt) {
		if (this.dateStart.getValue() == null) {
			AlertHelper.showAlert(Alert.AlertType.WARNING, "Date Warning!", "Must enter a start date.");
			return;
		}
		
		if (this.timeStart.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.WARNING, "Timestamp Warning!", "Must enter a timestamp!");
			return;
		}
		
		if (this.dateEnd.getValue() == null) {
			AlertHelper.showAlert(Alert.AlertType.WARNING, "Date Warning", "Must enter a end date.");
			return;
		}
		
		if (this.timeEnd.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.WARNING, "Timestamp Warning!", "Must enter a timestamp!");
			return;
		}
		
		AlertHelper.showAlert(Alert.AlertType.INFORMATION, "Entry submitted", "Submission complete!");
		man.addEntry(new SleepEntry(dateStart.getValue(), timeStart.getText(), dateEnd.getValue(), timeEnd.getText()));
	}
	
	@FXML
	protected void handleShowEntriesButtonAction(ActionEvent evt) {
		List<SleepEntry> entries = man.getEntries();
		
		String output = entries.stream()
						.map(SleepEntry::toString)
						.collect(Collectors.joining("\n\n"));
		
		AlertHelper.showAlert(Alert.AlertType.INFORMATION, "All entries.", output);
	}
}
