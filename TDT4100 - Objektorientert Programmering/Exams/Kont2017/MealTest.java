import java.util.Iterator;

import junit.framework.TestCase;

public class MealTest extends TestCase {

	private Course c1, c2;
	private Meal meal;

	@Override
	protected void setUp() throws Exception {
		c1 = new Course("c1", "c1");
		c2 = new Course("c2", "c2");
		meal = new Meal("test", "test", new Course[]{ c1, c2});
	}
	
	/**
	 * Tests Meal's iterator() method
	 */
	public void testIterator() {
		Iterator<Course> it = meal.iterator();
		assertTrue(it.hasNext());
		assertEquals(c1, it.next());
		assertTrue(it.hasNext());
		assertEquals(c2, it.next());
		assertFalse(it.hasNext());
	}
	
	/**
	 * Tests Meal's findCourse(Prediate) method
	 */
	public void testFindCourse() {
		assertEquals(c1, meal.findCourse(course -> course.getName().equals("c1")));
	}
}