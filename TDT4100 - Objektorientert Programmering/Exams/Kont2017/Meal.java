import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Represents a set of (pre-defined) Courses that are ordered as a whole
 */
public class Meal extends MenuItem implements Iterable<Course> {
  /*
  Her ivertas 1) Sikring av gyldig tilstand og 2) Skjuling av implementasjonsdetaljer. Alt hentes ut gjennom predefinerte metoder.
  */

  private Collection<Course> courses = new ArrayList<>();

  public Meal(String name, String description, Course[] courses) {
    super(name, description);
    /*
    Her brukes 'this', - dersom dette ikke ble brukt ville name referert til argumentet i funksjonen, og ikke instansvariablen.
    Ville da blitt Course[] courses = ArrayList<Course>(); som ikke lar seg gjøre.
    */
    this.courses = Arrays.asList(courses);

    // Mulig implementasjon av asList()
    // public <T> List<T> asList(T .. a){ return new ArrayList<>(a) }
  }

  public Collection<Course> getCourses() {
  return this.courses;
  }

  public void addCourse(Course course) {
    if (!courses.contains(course)) {
      courses.add(course);
    }
  }

  public void removeCourse(Course course) {
    courses.remove(course);
  }

  @Override
  public Iterator<Course> iterator() {
    return courses.iterator();
  }

  /**
   * Finds a Course satisfying the provided Predicate.
   * @param test
   * @return the first Course satisfying the provided Predicate, otherwise null.
   */
  public Course findCourse(Predicate<Course> test) {
    for (Course c : courses) {
      if (test.test(c)) {
        return c;
      }
    }
    return null;
  }
}