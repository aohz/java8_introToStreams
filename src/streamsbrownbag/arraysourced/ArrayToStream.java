package streamsbrownbag.arraysourced;

import java.util.Arrays;
import java.util.stream.Stream;
import streamsbrownbag.model.Person;

public class ArrayToStream {

    public static void main(String args[]) {

        // Arrays.stream
        int[] numbers = {2, 3, 5, 7, 11, 13};
        System.out.println("Sum is: "+Arrays.stream(numbers).sum());
        
        System.out.println();
        
        // Stream.of
        Stream<String> stream = Stream.of("Java 8", "Brown", "Bag", "Session");
        stream.map(String::toUpperCase).forEach(System.out::println);

        System.out.println();
        
        Person[] people = {
            new Person("Joe", "Montana", 48),
            new Person("Mary", "Kay", 30),
            new Person("Mike", "Tyson", 73)};

        Stream<Person> streamOf = Stream.of(people);
        streamOf.forEach(p -> System.out.println(p.getInfo()));
                
        System.out.println();
        
        Stream<Person> asStream = Arrays.stream(people);
        asStream.map(Person::getInfo).forEach(System.out::println);
        
        System.out.println();
        // Stream.empty
        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(System.out::println);
        
    }

}
