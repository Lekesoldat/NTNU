/* 
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
*/
package app;

import java.util.ArrayList;
import java.util.List;

public class EntryManager {
	List<SleepEntry> entries;
	
	public EntryManager() {
		this.entries = new ArrayList<SleepEntry>();
	}
	
	public void addEntry(SleepEntry e) {
		this.entries.add(e);
	}
	
	public List<SleepEntry> getEntries() {
		return this.entries;
	}
	
	public void listEntries() {
		entries.forEach((entry) -> {
			System.out.println(entry);
		});
	}
}
