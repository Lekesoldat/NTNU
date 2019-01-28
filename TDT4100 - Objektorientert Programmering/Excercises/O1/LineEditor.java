/* 
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
*/
package stateandbehavior;

public class LineEditor {
	private String text = "";
	private int insertionIndex = 0;
	private StringBuilder sb;
	
	public void left() {
		if (this.insertionIndex > 0) {
			this.insertionIndex--;
		}
	}
	
	public void right() {
		if (this.insertionIndex < text.length()) {
			this.insertionIndex++;
		}
	}
	
	public void insertString(String a) {
		sb = new StringBuilder(text);
		sb.insert(this.insertionIndex, a);
		this.text = sb.toString();
		
		this.insertionIndex += a.length();
	}
	
	public void deleteLeft() {
		if (this.insertionIndex > 0) {
			StringBuilder sb = new StringBuilder(text);
			sb.deleteCharAt(insertionIndex - 1);
			text = sb.toString();
			
			this.insertionIndex--;
		}
	}
	
	public void deleteRight() {
		if (this.insertionIndex < text.length()) {
			sb = new StringBuilder(text);
			sb.deleteCharAt(insertionIndex);
			text = sb.toString();
		}
	}
	
	public String getText() {
		return this.text;
	}
	
	
	public void setText(String s) {
		this.text = s;
	}
	
	public int getInsertionIndex() {
		return this.insertionIndex;
	}
	
	public void setInsertionIndex(int i) {
		this.insertionIndex = i;
	}
	
	@Override
	public String toString() {
		sb = new StringBuilder(text);
		sb.insert(insertionIndex, '|');
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		LineEditor le = new LineEditor();
		le.setText("Kjip Oppgavetekst..");
		le.setInsertionIndex(7);
		System.out.println(le);
	}
}
