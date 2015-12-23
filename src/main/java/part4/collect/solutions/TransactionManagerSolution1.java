package part4.collect.solutions;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import model.Trader;
import model.Transaction;

public class TransactionManagerSolution1 {

	public static void main(String... args) {
		List<Transaction> transactions = getTransactions();
		
		System.out.println("=====");
		// Accumulate trader names into a list
		List<String> list = transactions.stream().map((t) -> t.getTrader().getName()).collect(Collectors.toList());
		
		list.forEach(System.out::println);
		
		System.out.println("=====");
				
		// Accumulate trader name into a TreeSet		
		TreeSet<String> set = transactions.stream().map(
				(t) -> t.getTrader().getName()).collect(Collectors.toCollection(TreeSet::new));
				
		set.forEach(System.out::println);
	}

	private static List<Transaction> getTransactions() {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		return Arrays.asList(
				new Transaction(brian, 2011, 300), 
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), 
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));
	}
}
