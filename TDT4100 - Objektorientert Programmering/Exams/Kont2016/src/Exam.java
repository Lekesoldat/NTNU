public class Exam {

      ... fields and methods for course and grade ...

    /**
     * Initialises an Exam, by setting the course and grade.
     * The grade can only be set to one of the characters 'A'-'F'.
     * @throws IllegalArgumentException if the grade is not legal
     */
    public Exam(...) { ... }

    /**
     * Tells whether this Exam has a result that is a passing grade.
     */
    public boolean isPass() { ... }
}