/**
 * Enkeltrett, laksemousse, biffsnadder eller karamellpudding.
 */
public class Course extends MenuItem {

  public Course(String name, String description) {
      super(name, description); // Her kalles superklassens konstruktør, i dette tilfellet Object. Denne kan fjernes da kompilatoren legger den til uansett.
  }

  /*
    At alle feltene er public gjør at det ikke finnes noen form for inkapsling, - at feltene er final gjør at de ikke kan endres, så da er gyldig tilstand sikret. Her kan dog hvem som helst hente ut verdiene, og det er ikke i tråd med god inkapsling.

    Koden blir veldig kort og konsis her, men ingen implementasjonsteknikker skjules.
  */
}