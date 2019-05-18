/* 
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
*/
package encapsulation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
  private String cCodes[] = { "ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw",
      "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs",
      "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr",
      "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es",
      "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn",
      "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im",
      "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr",
      "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me",
      "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my",
      "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg",
      "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb",
      "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy",
      "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua",
      "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm",
      "zw" };
  
  private String name, mail;
  private Date birthday;
  private char gender;

  public String getMail() {
    return mail;
  }

  public void setName(String s) {
    // RegEx matching nn nn
    if (s.matches("[A-Za-z]{2,} [A-Za-z]{2,}")) {
      this.name = s;
    } else {
      throw new IllegalArgumentException("Illegal name");
    }
  }

  public void setEmail(String e) {
    // General pattern for the email
    String pattern = "(\\w+)\\.(\\w+)@(\\w+)\\.([A-Za-z]{2,2})";
    Pattern pt = Pattern.compile(pattern);
    Matcher m = pt.matcher(e);
    
    // Look for matches
    if (!m.find()) {
      throw new IllegalArgumentException("Illegal mail");
    }
    
    // Check name matching
    String[] names = name.toLowerCase().split(" ");
    if (!(m.group(1).equals(names[0]) && m.group(2).equals(names[1]))) {
      throw new IllegalArgumentException("Names not matching.");
    }
    
    // Check country code
    if(Arrays.asList(this.cCodes).contains(m.group(4))) {
      this.mail = e;
    } else {
      throw new IllegalArgumentException("Illegal country code");
    }
  }
  
  public void setBirthday(Date d) {
    if (d.after(new Date())) {
      throw new IllegalArgumentException("You're not from the future!");
    } else {
      this.birthday = d;
    }
  }

  public void setGender(char g) {
    if (g != 'M' && g != 'F' && g != '\0') {
      throw new IllegalArgumentException("Illegal gender");
    } else {
      this.gender = g;
    }
  }

  public char getGender() {
    return gender;
  }

  public String getName() {
    return name;
  }

  public Date getBirthday() {
    return birthday;
  }

  public String getEmail() {
    return mail;
  }

  public static void main(String[] args) throws ParseException {
    Person magnus = new Person();
    magnus.setName("aa bb");
    magnus.setEmail("aa.bb@gmail.no");

    String pattern = "yyyy-MM-dd";
    SimpleDateFormat sp = new SimpleDateFormat(pattern);
    Date future = sp.parse("2018-09-09");

    magnus.setBirthday(future);
  }
}