package part3.mapping.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import services.FileService;

/**
 * Using “data.txt” 
 * - count the number of words
 * - print the length of each word
 * 
 * @author AOHZ
 *
 */
public class FileManagerSolutionEx2 {

	public static void main(String[] args) {
		Path path = FileService.getFilePath();
		try {
			System.out.println("=======FlapMap==========");
			countWordsUsingFlapMap(path);

			System.out.println("=======MapToInt==========");
			printTheLengthOfEachWordhUsingMapToInt(path);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void countWordsUsingFlapMap(Path path) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {

			System.out.println(lines.flatMap((s) -> Stream.of(s.split(" "))).count());
		}
	}

	public static void printTheLengthOfEachWordhUsingMapToInt(Path path) throws IOException {
		try (Stream<String> lines = Files.lines(path);) {

			lines.flatMap((s) -> Stream.of(s.split(" "))).mapToInt(String::length).forEach(System.out::println);
		}
	};
	
}
