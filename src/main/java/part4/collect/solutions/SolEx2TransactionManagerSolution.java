package part4.collect.solutions;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import model.Trader;
import model.Transaction;
/**
 * - Print the sum of the transactions amounts made by each Trader Return and
 * - print a Set containing the years of the transactions made by each trader
 * 
 * @author AOHZ
 *
 */
public class SolEx2TransactionManagerSolution {

	public static void main(String... args) {
		List<Transaction> transactions = getTransactions();
				
		System.out.println("=====");
		
		// Trades Amount by user
		Map<String, IntSummaryStatistics> amountbyTraders = 
				transactions.stream().collect(Collectors.groupingBy((Transaction t) -> t.getTrader().getName(), 
						Collectors.summarizingInt(Transaction::getValue)));
				
		amountbyTraders.forEach((s, i) -> System.out.println(s + " " + i.getSum()));
		
		
		System.out.println("=====");
		// Set containing the years of the transactions made by each trader	
		Map<String, Set<Integer>> yearsByTraders = 
				transactions.stream().collect(Collectors.groupingBy((Transaction t) -> t.getTrader().getName(),	
						Collectors.mapping((Transaction t) -> t.getYear(), Collectors.toSet())));
				
		yearsByTraders.forEach((key, i) -> 
		{
			System.out.println(key);			
			yearsByTraders.get(key).forEach((value) -> System.out.print(" " + value + ","));
			System.out.println("");
		});
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
