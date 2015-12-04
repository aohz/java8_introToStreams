package streamsbrownbag.aggregation;

import java.util.ArrayList;
import java.util.List;
import streamsbrownbag.model.Person;

public class SumAndAverage {

    public static void main(String args[]) {

        List<Person> people = new ArrayList<>();

        people.add(new Person("Joe", "Montana", 48));
        people.add(new Person("Mary", "Kay", 30));
        people.add(new Person("Mike", "Tyson", 73));

    }

}
