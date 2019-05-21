public class Person {

      ... fields, constructors and methods for name ...

    /**
     * Adds a Course to this Person, if no Course is registered
     * for the same code, year and semester.
     * @param course
     * @return true if the course was added, false otherwise
     */
    public boolean addCourse(Course course) { ... }

    /**
     * Returns whether this Person has a Course with the given code.
     * @param code
     */
    public boolean hasCourse(String code) { ... }

    /**
     * Creates and adds an exam to this Person for the provided Course and
     * with the provided grade, but only if this Person has this Course and
     * no passing Exam is registered for that Course.
     * @param course
     * @param grade
     * @return the newly created and added Exam, or null
     */
    public Exam addExam(Course course, char grade) { ...  }

    /**
     * Gets the exam that was registered last for the provided course code.
     * This is the exam that counts for that course!
     * @param course
     */
    public Exam getLastExam(String code) { ... }

    /**
     * Returns true of this Person has passed the Course for the provided code.
     * @param code
     */
    public boolean hasPassed(String code) { ... }

    /**
     * Counts the credits this Person has earned.
     */
    public double countCredits() { ... }
}