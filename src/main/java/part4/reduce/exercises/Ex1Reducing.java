package part4.reduce.exercises;

import java.util.Arrays;
import java.util.List;

import model.Trader;
import model.Transaction;

/**
 * - Get the transaction with the biggest Amount 
 * - Return a new transaction where:
 * -- The author is null 
 * -- The year is the newest 
 * -- The value is the sum of all values
 * 
 * @author AOHZ
 *
 */
public class Ex1Reducing {

	public static void main(String... args) {
		List<Transaction> transactions = getTransactions();
				
		System.out.println("=====");
		// Biggest Transaction	
		
		System.out.println("=====");
		
		// Accumulate Transaction amounts
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
