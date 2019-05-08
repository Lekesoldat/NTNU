import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class Relation2 implements Relation {
   private Relation rel1;
   private Relation rel2;

   public Relation2(Relation rel1, Relation rel2) {
      this.rel1 = rel1;
      this.rel2 = rel2;
   }

   @Override
   public Collection<Person> getRelativesOf(Person person) {
      List<Person> parents = new ArrayList<>(rel1.getRelativesOf(person));
      List<Person> aunts = new ArrayList<>();

      for (Person parent : parents) {
         aunts.addAll(rel2.getRelativesOf(parent));
      }
      return aunts;
   }
}