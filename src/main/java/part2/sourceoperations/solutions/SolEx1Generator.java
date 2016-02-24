package part2.sourceoperations.solutions;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import services.FileService;

public class SolEx1Generator {

	public static void main(String args[]) {

		// Stream.of
		System.out.println("========Sample 1=========");
		Stream<String> stream = generateUsingStreamOf();
		stream.map(String::toUpperCase).forEach(System.out::println);

		// Arrays.stream
		System.out.println("========Sample 2=========");
		IntStream intStream = generateUsingArraysStream();
		System.out.println("Sum is: " + intStream.sum());

		// stream of 1s with Stream.generate
		System.out.println("========Sample 3=========");
		IntStream intSream2 = generateUsingStreamGenerator();
		intSream2.limit(5).forEach(System.out::println);		
		
		// Print File Lines
		System.out.println("========Sample 4=========");
		Stream<String> lines = generateUsingFileLines();
		long nLines = lines.count();
		System.out.println("There are " + nLines + " lines in data.txt");
	}

	private static Stream<String> generateUsingStreamOf() {
		System.out.println("========Sample end=========");
		return Stream.of("Java 8", "Brown", "Bag", "Session");		
	}

	private static IntStream generateUsingArraysStream() {
		int[] numbers = { 2, 3, 5, 7, 11, 13 };
		return Arrays.stream(numbers);
	}

	private static IntStream generateUsingStreamGenerator() {
		IntSupplier supplier = () -> 1;
		return IntStream.generate(supplier);
	}

	private static Stream<String> generateUsingFileLines() {
		Stream<String> lines = Stream.empty();
		try {
			lines =  Files.lines(FileService.getFilePath(), Charset.defaultCharset());
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			lines.close();
		}
		return lines;
	}
}
