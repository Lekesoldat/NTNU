import java.util.*;

// Comparator
public class ComparatorComparableExample {
    public static void main(String[] args) {
        // Implementerer Comparable slik at den kan sorteres
        class Polse implements Comparable<Polse> {
            int lengde;
            public Polse(int lengde) {
                this.lengde = lengde;
            }

            @Override
            public int compareTo(Polse polse) {
                return this.lengde - polse.lengde;
            }

            @Override
            public String toString() {
                return String.format("Lengde: " + this.lengde);
            }
        }

        // Implementerer ikke Comparable, men har en tilhørende Comparator for sortering
        class Burger {
            int vekt;

            public Burger(int vekt) {
                this.vekt = vekt;
            }

            @Override
            public String toString() {
                return String.format("Vekt: " + this.vekt);
            }
        }

        // Verktøy for å sammenligne burgere
        class BurgerComparator implements Comparator<Burger> {
            @Override
            public int compare(Burger b1, Burger b2) {
                return b1.vekt - b2.vekt;
            }
        }

        class KlasseSomIkkeKanSorteres {
            int etTall;

            public KlasseSomIkkeKanSorteres(int tall) {
                this.etTall = tall;
            }
        }

        // Liste med standard-ting som implementerer comparable fra før
        List<Integer> tall = new ArrayList<>(Arrays.asList(1, 5, 4, 7, 5, 3, 2, 9));

        // Liste med noe som implementerer Comparable
        List<Polse> polser = new ArrayList<>(Arrays.asList(
                new Polse(0),
                new Polse(1),
                new Polse(2),
                new Polse(3),
                new Polse(4))
        );

        // Implementerer IKKE iterable, men har en tilhørende komparator
        List<Burger> burgere = new ArrayList<>(Arrays.asList(
                new Burger(0),
                new Burger(1),
                new Burger(2),
                new Burger(3),
                new Burger(4))
        );

        // Vil ikke kunne sorteres da vi ikke sier noe om hvordan man skal
        // sortere ting av typen 'KlasseSomIkkeKanSorteres'
        List<KlasseSomIkkeKanSorteres> klasser = new ArrayList<>(Arrays.asList(
                new KlasseSomIkkeKanSorteres(0),
                new KlasseSomIkkeKanSorteres(1),
                new KlasseSomIkkeKanSorteres(2),
                new KlasseSomIkkeKanSorteres(3),
                new KlasseSomIkkeKanSorteres(4))
        );


        // Returnerer [1, 2, 3, 4, 5, 5, 7, 9]
        Collections.sort(tall);

        // Sorterer på lengde
        Collections.sort(polser);

        // Sorterer på vekt
        Collections.sort(burgere, new BurgerComparator());

        // Gir følgende feilmelding:
        // 'sort in Collections cannot be applied.'
        // 'reason: no instance(s) type variable(s) T exist so that KlasseSomIkkeKanSorteres conforms to Comparable...'
        Collections.sort(klasser);
        }
}
