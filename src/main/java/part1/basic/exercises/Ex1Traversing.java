package part1.basic.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import model.Person;

/**
 * Print the name of the people older than 65
 * 
 * @author AOHZ
 *
 */
public class Ex1Traversing {

	public static void main(String args[]) {

		List<Person> people = new ArrayList<>();

		people.add(new Person("Joe", "Darryl", 48));
		people.add(new Person("Mary", "Kay", 30));
		people.add(new Person("Mike", "Tyson", 73));

		Predicate<Person> pred = p -> p.getAge() > 65;

		// without Stream
		System.out.println("======Java without Streams======");
		printOldPeopleNamesWithoutStreams(people, pred);
		// Java 8
		System.out.println("======Java 8======");
		printOldPeopleNamesInJava8(people, pred);
	}

	private static void printOldPeopleNamesWithoutStreams(List<Person> people, Predicate<Person> pred) {

		// Without Streams
		people.forEach(p -> {
			if (pred.test(p)) {
				System.out.println(p.getName());
			}
		});
	}

	private static void printOldPeopleNamesInJava8(List<Person> people, Predicate<Person> pred) {

		// With Streams
	    // TODO implement similar functionality than in printOldPeopleNamesInJava7 method using streams
	}
}
