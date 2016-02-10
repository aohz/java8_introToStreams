package part1.basic;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Dish;

/**
 * Select the Dishes that have less than 400 calories, sort them according to
 * their calories and print them
 * 
 * @author AOHZ
 *
 */
public class StreamBasics {

	public static void main(String[] args) {		
		// Java 7
		System.out.println("======Java 7======");

		getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

		System.out.println("======Java 8======");

		// Java 8
		getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
	}

	public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
		// Filter the dishes
		List<Dish> lowCaloricDishes = new ArrayList<>();
		for (Dish d : dishes) {
			if (d.getCalories() < 400) {
				lowCaloricDishes.add(d);
			}
		}
		
		// Sort the dishes
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
			@Override
			public int compare(Dish d1, Dish d2) {
				return Integer.compare(d1.getCalories(), d2.getCalories());
			}
		});

		// Get the dishes names
		List<String> lowCaloricDishesName = new ArrayList<>();
		for (Dish d : lowCaloricDishes) {
			lowCaloricDishesName.add(d.getName());
		}
		return lowCaloricDishesName;
	}

	public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
		return dishes.stream()
				.filter(d -> d.getCalories() < 400)
				.sorted((d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories()))
				.map(d -> d.getName())
				.collect(toList());
	}
}
