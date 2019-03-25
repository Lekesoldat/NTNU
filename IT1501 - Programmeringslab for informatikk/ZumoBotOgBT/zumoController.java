import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import plab.serial.PLabSerial;

public class zumoController {
	private PLabSerial serialConnection = new PLabSerial();
	@FXML
	private TextField serialPortNameField;

	@FXML
	private Button button;

	@FXML
	void initialize() {
		String portName;
		if (serialConnection.openPLabPort()) {
			portName = serialConnection.getOpenPortName();
		} else {
			portName = "No PLab BT device found.";
		}
		;
		serialPortNameField.setText(portName);
		serialConnection.addListener(this, "messageReceived");
	}

	public void buttonPressed() {
		if (button.getText().equals("Lys på")) {
			button.setText("Lys av");
			button.setTextFill(Color.RED);
			turnOff();

		} else {
			button.setText("Lys på");
			button.setTextFill(Color.GREEN);
			turnOn();
		}

	}

	public void turnOff() {
		serialConnection.sendMessage("#buttonPressedOff", 0);
	}

	public void turnOn() {
		serialConnection.sendMessage("#buttonPressedOn", 0);
	}
}
