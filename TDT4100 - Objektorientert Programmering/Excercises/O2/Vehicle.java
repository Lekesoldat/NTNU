/* 
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
*/
package encapsulation;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vehicle {
  private char vType, fType;
  private String reg;
  
  public Vehicle(char v, char f, String r) {
    this.vType = this.evaluateVehicle(v);
    this.fType = this.evaluateFuel(v, f);
    this.reg = this.evaluateReg(v, f, r);
  }
  
  private char evaluateVehicle(char v) {
    if (v != 'C' && v != 'M') {
      throw new IllegalArgumentException("Not a legal vehicle.");
    } else {
      return v;
    }
  }
  
  private char evaluateFuel(char v, char f) {
    List fuels = Arrays.asList('H', 'D', 'E', 'G'); 
    // Check valid fuels
    if (!fuels.contains(f)) {
      throw new IllegalArgumentException("Illegal fuel type.");
    }
    
    // Check hydrogen compatability
    if (v != 'C' && f == 'H') {
      throw new IllegalArgumentException("Only cars can run on hydrogen.");
    }
    
    return f;
  }
  
  private String evaluateReg(char v, char f, String s) {
    List<String> el = Arrays.asList("EL", "EK");
    
    Pattern pattern = Pattern.compile("^([A-Z]{2,2})([0-9]{4,5})$");
    Matcher m = pattern.matcher(s);
    
    
    // Check legal standard input
    if (!m.find()) {
      throw new IllegalArgumentException("Not a valid registration number.");
    }
    
    // Check length and vehicle type
    if ((m.group(2).length() > 4 && v == 'M') || (m.group(2).length() < 5 && v == 'C')) {
      throw new IllegalArgumentException("Number length not maching vehicle.");
    }
    
    // Check if hydrogen car has wrong reg
    if ((f == 'H' && !m.group(1).equals("HY")) || (f != 'H' && m.group(1).equals("HY"))) {
      throw new IllegalArgumentException("HY: Wrong combination of fuel and letters");
    }
    
    // Check if el car has wrong reg
    if ((f == 'E' && !el.contains(m.group(1)) || (f != 'E' && el.contains(m.group(1))))) {
      throw new IllegalArgumentException("EL: Wrong combination of fuel and letters");
    }
    
    return s;
  }
  
  public char getFuelType() {
    return this.fType;
  }
  
  public char getVehicleType() {
    return this.vType;
  }
  
  public String getRegistrationNumber() {
    return this.reg;
  }
  
  public void setRegistrationNumber(String s) {
    this.reg = this.evaluateReg(this.vType, this.fType, s);
  }
  
  public static void main(String[] args) {
    Vehicle bike = new Vehicle('C', 'G', "AB12345");
  }
}
