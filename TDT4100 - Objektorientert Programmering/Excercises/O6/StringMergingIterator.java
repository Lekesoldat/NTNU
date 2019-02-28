package debugging;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringMergingIterator implements Iterator<String> {

	private Iterator<String> first;
	private Iterator<String> second;
	private boolean turnSwitch;

	public StringMergingIterator(Iterator<String> first, Iterator<String> second){
		this.first = first;
		this.second = second;
		this.turnSwitch = true;
	}

	@Override
	public boolean hasNext() {
		return first.hasNext() || second.hasNext();
	}

	@Override
	public String next() {
		
		if(! hasNext()){ throw new NoSuchElementException(); }

		String result = null;
		
		if (first.hasNext() && turnSwitch) {
			result = first.next();
			turnSwitch = false;
		} else if (second.hasNext()) {
			result = second.next();
			turnSwitch = true;
		}
		
		/*
		Jallakode som ikke funker
		
		if(!first.hasNext()){
			result = first.next();
		} 
		// Fjerner ! foran statement
		else if(!second.hasNext()){
			result = second.next();
		} 
		else {
			if(turnSwitch){
				result = first.next();
				turnSwitch = false;
			}
			if(!turnSwitch){
				result = second.next();
				turnSwitch = true;
			}
		}
		*/
		return result;
	}
}
