package part5.optional.solution;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

/**
 * Implement the method getPersonNameNullSafe using optional. The implemented
 * method must pass all the tests.
 * 
 * @author aohz
 *
 */
public class SolEx1Optional {

	public String getPersonNameNullSafe(Person person) {
		// reimplement this method using Optional
		return Optional.ofNullable(person).map(Person::getName).orElse(null);
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
