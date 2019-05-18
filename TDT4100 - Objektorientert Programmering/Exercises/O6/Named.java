package interfaces;

public interface Named {
  void setGivenName(String s);
  String getGivenName();
  
  void setFamilyName(String s);
  String getFamilyName();

  void setFullName(String s);
  String getFullName();
}