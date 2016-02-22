package part4.collect.solutions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import model.Trader;
import model.Transaction;

/**
 * - Collect Traders names into a List 
 * - Collect Traders names into a TreeSet
 * - Create a Map were the key is the transaction year and the value is the sum of the transacions for that year
 * 
 * @author AOHZ
 *
 */
public class SolEx1TransactionManagerSolution {

	public static void main(String... args) {
		List<Transaction> transactions = getTransactions();

		System.out.println("=====");
		// Collect trader names into a list
		List<String> list = transactions.stream().map((t) -> t.getTrader().getName()).collect(Collectors.toList());
		 
		list.forEach(System.out::println);

		System.out.println("=====");

		// Collect trader name into a TreeSet
		TreeSet<String> set = transactions.stream().map((t) -> t.getTrader().getName())
				.collect(Collectors.toCollection(TreeSet::new));
		
		set.forEach(System.out::println);
		
		System.out.println("=====");
		
		// Create a Map were: the key is the transaction year and the value the sum of the transacions for that year
		Collector<Transaction, ?, Map<Integer, Integer>> valuePerYearCollector = 
				Collectors.toMap(
						(Transaction t) -> t.getYear(), 
						(Transaction t) -> t.getValue(), 
						(Integer i1, Integer i2) -> i1 + i2);
		
		Map<Integer, Integer> valuePerYear = transactions.stream().collect(valuePerYearCollector);
		valuePerYear.forEach((key, value) -> System.out.println(key + "->" + value));
		
	
	}

	private static List<Transaction> getTransactions() {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		return Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));
	}
}
