package part6.parallel;

import java.util.Random;

/**
 * 
 * @author aohz
 *
 */
public class BenchmarkDataProvider {

	private static final String ABC = "abcdefghijklmnopqrstuvwxyz";
	private static final String CHARACTERS = "0123456789" + ABC + ABC.toUpperCase() + "{}[]()";
	private static final int MAX_WORD_LENGTH = 1000;
	
	public static String generateStringsDefault() {
		return generateStrings(new Random(), CHARACTERS, new Random().nextInt(MAX_WORD_LENGTH));
	}

	public static String generateStrings(Random random, String characters, int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(characters.charAt(random.nextInt(characters.length())));
		}
		return sb.toString();
	}
}
