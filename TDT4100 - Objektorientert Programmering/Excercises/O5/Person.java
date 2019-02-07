/* 
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
*/

package objectstructures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
	private String name;
	private char gender;
	private Person mother;
	private Person father;
	private List<Person> children = new ArrayList<Person>();
	
	public Person(String name, char gender) {
		if (!(gender == 'M' || gender == 'F')) {
			throw new IllegalArgumentException("Illegal gender.");
		}
		
		this.gender = gender;	
		this.name = name;
	}
	
	/////////////////////////////////////////
	//               Getters               //
	/////////////////////////////////////////
	public String getName() {
		return this.name;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public Person getMother() {
		return this.mother;
	}
	
	public Person getFather() {
		return this.father;
	}
	
	public int getChildCount() {
		return this.children.size();
	}
	
	public Person getChild(int n) {
		if (n < 0 || n > this.children.size() - 1) {
			throw new IllegalArgumentException("Child not in range.");
		}
		
		return this.children.get(n);
	}
	
	/////////////////////////////////////////
	//               Setters               //
	/////////////////////////////////////////
	public void addChild(Person c) {
		if (this.children.contains(c)) {
			return;
		}
		
		this.children.add(c);
		
		if (this.gender == 'F') {
			if (c.mother != null) {
				c.mother.removeChild(c);				
			}
			c.mother = this;
		} else {
			if (c.father != null) {
				c.father.removeChild(c);				
			}
			c.father = this;
		}
	}
	
	public void setMother(Person m) {
		if (m == this) {
			throw new IllegalArgumentException("You cannot be your own mother.");
		}
		
		if (m == null) {
			if (this.mother != null) {
				this.mother.removeChild(this);
			}
			
		} else if (m.gender != 'F') {
			throw new IllegalArgumentException("A mother is a female. Even in 2019");
			
		} else {
			if (this.mother != null) {
				this.mother.removeChild(this);
			}
			m.addChild(this);
			this.mother = m;			
		}
	}
	
	public void setFather(Person f) {
		if (f == this) {
			throw new IllegalArgumentException("You cannot be your own father.");
		}
		
		if (f == null) {
			if (this.father != null) {
				this.father.removeChild(this);
			}
		} else if (f.gender != 'M') {
			throw new IllegalArgumentException("A father is a male. Even in 2019");
			
		} else {
			if (this.father != null) {
				this.father.removeChild(this);
			}
			
			f.addChild(this);
			this.father = f;			
		}
	}
	
	public void removeChild(Person c) {
		if (!this.children.contains(c)) {
			throw new IllegalArgumentException(c.getName() + "is not " + this.getName() + "'s child.");
		}
		
		// Remove child from children
		this.children.remove(c);
		
		// Reset mother
		if (this.gender == 'F') {
			c.mother = null;	
		}
		
		// Reset father
		if (this.gender == 'M') {
			c.father = null;
		}
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
			.append(String.format("Name: \t\t %s \n", this.name))
			.append(String.format("Gender: \t %s \n", this.gender))
			.append(String.format("Mother: \t %s \n", mother == null ? "null" : this.mother.getName()))
			.append(String.format("Father: \t %s \n", father == null ? "null" : this.father.getName()))
			.append(String.format("Children: \t %s \n", children.stream().map(Person::getName).collect(Collectors.joining(", "))))
			.toString();
	}
	
	public static void main(String[] args) {
		Person hallvard = new Person("Hallvard", 'M');
		Person marit = new Person("Marit", 'F');
		Person jens = new Person("Jens", 'M');
		Person torkel = new Person("Torkel", 'M');
		Person jorunn = new Person("Jorunn", 'F');
		
		jens.setMother(marit);
		jens.setFather(hallvard);
		
		System.out.println(hallvard);
		System.out.println(marit);
		System.out.println(jens);
		
		jens.setFather(null);
		jens.setMother(null);
		
		System.out.println(hallvard);
		System.out.println(marit);
		System.out.println(jens);
		System.out.println(torkel);
		System.out.println(jorunn);
	}
}
