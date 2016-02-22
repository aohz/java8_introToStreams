package part4.collect.exercises;

import java.util.Arrays;
import java.util.List;

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
public class Ex1TransactionManager {

	public static void main(String... args) {
		List<Transaction> transactions = getTransactions();
		
		System.out.println("=====");
		// Collect trader names into a list
		
		System.out.println("=====");
				
		// Collect trader name into a TreeSet
		
		// Create a Map were the key is the transaction year and the value is the sum of the transacions for that year

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
