/* 
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
*/
package app;

import java.time.Duration;
import java.time.LocalDateTime;
import javafx.scene.control.*;

public class SleepEntry {
	private LocalDateTime start;
	private LocalDateTime end;
	private double timeSlept;
	
	public SleepEntry(DatePicker dStart, TextField tStart, DatePicker dEnd, TextField tEnd) {
		this.start = dateValidation(dStart, tStart);
		this.end = dateValidation(dEnd, tEnd);
		
		if (!(start.isBefore(end))) {
			throw new IllegalArgumentException("End has to be before start.");
		}
		
		this.timeSlept = Duration.between(start, end).toMinutes();
	}
	
	private LocalDateTime dateValidation(DatePicker d, TextField t) {
		if (!(d.getValue().toString().matches("\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])"))) {
			return null;
		}
		
		String[] hhmm = this.validateTimeStamp(t).split(":");
		return d.getValue().atTime(Integer.parseInt(hhmm[0]), Integer.parseInt(hhmm[1]));
	}
	
	private String validateTimeStamp(TextField text) {
		if (!(text.getText().matches("(2[0-3]|[01][0-9]):[0-5][0-9]"))) {
			return null;
		}
		
		return text.getText();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("Start: \t %s/%s/%s %d:%d \n", start.getDayOfMonth(), start.getMonthValue(), start.getYear(), start.getHour(), start.getMinute()));
		sb.append(String.format("End: \t %s/%s/%s %d:%d \n", end.getDayOfMonth(), end.getMonthValue(), end.getYear(), end.getHour(), end.getMinute()));
		sb.append(String.format("Total hours slept: %.2f", this.timeSlept/60));
		
		return sb.toString();
	}
}
