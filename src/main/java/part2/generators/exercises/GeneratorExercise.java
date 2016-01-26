package part2.generators.exercises;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import services.FileService;

public class GeneratorExercise {

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
	    // TODO return a stream with Strings: "Java 8", "Brown", "Bag", "Session"
		return null;
	}

	private static IntStream generateUsingArraysStream() {
		int[] numbers = { 2, 3, 5, 7, 11, 13 };
		// TODO return an IntStream from the numbers array
		return null;
	}

	private static IntStream generateUsingStreamGenerator() {
		IntSupplier supplier = () -> 1;
		// TODO return an IntStream generated from the supplier
		return null;
	}
	
	private static Stream<String> generateUsingFileLines() {
		Stream<String> lines = Stream.empty();		
		try {
			// TODO return a stream with the lines of the file at FileService.getFilePath() using the charset Charset.defaultCharset() 
			Path pah = FileService.getFilePath();
			Charset charset = Charset.defaultCharset();
			
		} catch (Exception e) {
			System.out.println(e);			
		}
		return lines;
	}
}
