package part3.intermediateoperations.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import services.FileService;

/**
 * Using “data.txt” 
 * - print the total number of words
 * - print the length of each word
 * 
 * @author AOHZ
 *
 */
public class SolEx4AdvancedMapping {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {
			System.out.println("=======FlapMap==========");
			printTheTotalNumberOfWords(path);

			System.out.println("=======MapToInt==========");
			printTheLengthOfEachWordUsingMapToInt(path);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printTheTotalNumberOfWords(Path path) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {

			System.out.println(lines.skip(1).flatMap((s) -> Stream.of(s.split(" "))).count());
		}
	}

	public static void printTheLengthOfEachWordUsingMapToInt(Path path) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {			
			lines
			.skip(1)
			.flatMap((s) -> Stream.of(s.split(" ")))
			//.peek(s -> System.out.print(s + " = "))
			.mapToInt((String s) -> s.length())
			.forEach(System.out::println);
		}
	};
	
}
