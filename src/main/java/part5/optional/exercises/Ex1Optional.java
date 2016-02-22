package part5.optional.exercises;

import org.junit.Assert;
import org.junit.Test;

/**
 * Implement the method getPersonNameNullSafe using optional. 
 * The implemented method must pass all the tests.
 * 
 * @author aohz
 *
 */
public class Ex1Optional {

	public String getPersonNameNullSafe(Person person) {	
		// TODO: reimplement this method using Optional
		String name = null;
		if(person != null){
			name = person.getName();
		}
		return name;
	}

	@Test
	public void test_getPersonNameNullSafe_NoNulls() {
		Person person = new Person("Juan");
		Assert.assertEquals("Juan", getPersonNameNullSafe(person));
	}

	@Test
	public void test_getPersonNameNullSafe_NullPerson() {
		Person person = null;
		Assert.assertNull(getPersonNameNullSafe(person));
	}

	@Test
	public void test_getPersonNameNullSafe_NullName() {
		Person person = new Person(null);
		Assert.assertNull(getPersonNameNullSafe(person));
	}
}

class Person {

	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
