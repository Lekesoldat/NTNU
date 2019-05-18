/* 
READ THE DISCLAIMER AT https://github.com/Lekesoldat/NTNU/blob/master/README.md before proceeding.
Written by Magnus L. Holtet.
*/
package objectstructures;

public class Partner {
  private String name;
  private Partner partner;
  
  public Partner(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public Partner getPartner() {
    return partner;
  }
  
  public void setPartner(Partner partner) {
    // If you have a partner
    if (this.partner != null) {
      
      // Remove you from your partner
      this.partner.partner = null;
      
      // Remove the partner from you
      this.partner = null;
    }
    
    if (partner != null) {
      // If the new partner has a partner from before
      if (partner.partner != null) {
        // Remove previous partners
        partner.partner.setPartner(null);
      }
      
      partner.partner = this;
      this.partner = partner;
    }
  }
  
  @Override
  public String toString() {
    return new StringBuilder()
        .append(String.format("Name: %s\n", this.name))
        .append(String.format("Partner: %s\n", this.partner == null ? "No partner." : this.partner.getName()))
        .toString();
  }
  
  public static void main(String[] args) {
    Partner andreas = new Partner("Andreas");
    Partner magnus = new Partner("Magnus");
    Partner sigurd = new Partner("Sigurd");
    
    andreas.setPartner(magnus);
    sigurd.setPartner(magnus);
  }
}
