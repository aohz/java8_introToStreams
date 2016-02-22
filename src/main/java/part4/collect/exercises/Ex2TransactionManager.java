package part4.collect.exercises;

import java.util.Arrays;
import java.util.List;

import model.Trader;
import model.Transaction;

/**
 * - Print the sum of the transactions amounts made by each Trader Return and
 * - print a Set containing the years of the transactions made by each trader
 * 
 * @author AOHZ
 *
 */
public class Ex2TransactionManager {

	public static void main(String... args) {
		List<Transaction> transactions = getTransactions();

		System.out.println("=====");

		// Trades Amount by user
	
		System.out.println("=====");
		// Set containing the years of the transactions made by each trader
	
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
